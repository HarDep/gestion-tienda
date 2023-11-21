package co.edu.uptc.services;

import co.edu.uptc.dtos.MunicipioDTO;
import co.edu.uptc.dtos.SujetoDTO;
import co.edu.uptc.entities.Municipio;
import co.edu.uptc.entities.Sujeto;
import co.edu.uptc.entities.TipoSujeto;
import co.edu.uptc.exceptions.InvalidRequest;
import co.edu.uptc.exceptions.InvalidResource;
import co.edu.uptc.exceptions.ResourceNotFound;
import co.edu.uptc.repositories.MunicipioRepository;
import co.edu.uptc.repositories.SujetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
public class SujetoServiceImpl implements SujetoService {
    @Autowired
    private SujetoRepository repository;
    @Autowired
    private MapperService mapperService;
    @Autowired
    private MunicipioRepository municipioRepository;

    @Override
    public Optional<SujetoDTO> save(SujetoDTO sujeto, int idMunicipio) {
        validations(sujeto,idMunicipio);
        if(repository.existsByTelefono(sujeto.getTelefono()))
            throw new InvalidResource("Telefono de "+sujeto.getTipoSujeto().getValue(),
                    "el telefono ya existe", sujeto.getTelefono());
        switch (sujeto.getTipoSujeto()){
            case PER -> {
                if (sujeto.getApellido() == null)
                    throw new InvalidResource("Apellido de Persona","el apellido no es valido", null);
                if (sujeto.getNumeroDoc() == null)
                    throw new InvalidResource("Numero de documento de Persona","el numero de documento no es valido", null);
                if(repository.existsByNumeroDocumento(sujeto.getNumeroDoc()))
                    throw new InvalidResource("Numero de documento de Persona","el numero de documento ya existe", sujeto.getNumeroDoc());
            }
            case EMP -> {
                if (sujeto.getNit() == null)
                    throw new InvalidResource("NIT de Empresa","el NIT no es valido", null);
                if(repository.existsByNit(sujeto.getNit()))
                    throw new InvalidResource("NIT de Empresa","el NIT ya existe", sujeto.getNit());
            }
        }
        Sujeto sujeto1 = mapperService.toSujeto(sujeto, idMunicipio);
        Sujeto saved = repository.save(sujeto1);
        return Optional.of(mapperService.toSujetoDTO(saved));
    }

    @Override
    public Optional<SujetoDTO> update(SujetoDTO sujeto, int idSujeto, int idMunicipio) {
        List<Sujeto> empleados = repository.findEmployees();
        if (empleados.stream().anyMatch(emp -> emp.getId() == idSujeto)
                && sujeto.getTipoSujeto() == TipoSujeto.EMP)
            throw new InvalidRequest("Actualización",
                    "se esta actualizando un empleado y los empleados únicamente pueden ser de tipo Persona",
                    "cambiar a Tipo Empresa");
        validateExists(idSujeto);
        validations(sujeto,idMunicipio);
        repository.findByTelefono(sujeto.getTelefono()).map(suj ->{
            if (suj.getId() != idSujeto)
                throw new InvalidResource("Telefono de "+sujeto.getTipoSujeto().getValue(),
                        "el telefono ya existe", sujeto.getTelefono());
            return null;
        });
        switch (sujeto.getTipoSujeto()){
            case PER -> {
                if (sujeto.getApellido() == null)
                    throw new InvalidResource("Apellido de Persona","el apellido no es valido", null);
                if (sujeto.getNumeroDoc() == null)
                    throw new InvalidResource("Numero de documento de Persona","el numero de documento no es valido", null);
                repository.findByNumeroDocumento(sujeto.getNumeroDoc()).map(suj -> {
                    if (suj.getId() != idSujeto)
                        throw new InvalidResource("Numero de documento de Persona","el numero de documento ya existe",
                                sujeto.getNumeroDoc());
                    return null;
                });
            }
            case EMP -> {
                if (sujeto.getNit() == null)
                    throw new InvalidResource("NIT de Empresa","el NIT no es valido", null);
                repository.findByNit(sujeto.getNit()).map(suj -> {
                    if (suj.getId() != idSujeto)
                        throw new InvalidResource("NIT de Empresa","el NIT ya existe",
                                sujeto.getNit());
                    return null;
                });
            }
        }
        Sujeto sujeto1 = mapperService.toSujeto(sujeto, idMunicipio);
        sujeto1.setId(idSujeto);
        Sujeto saved = repository.save(sujeto1);
        return Optional.of(mapperService.toSujetoDTO(saved));
    }

    @Override
    public void delete(int id) {
        List<Sujeto> empleados = repository.findEmployees();
        if (empleados.stream().anyMatch(emp -> emp.getId() == id))
            throw new InvalidRequest("Borrar registro",
                    "no se pueden eliminar los empleados",
                    "eliminar Empleado");
        List<Sujeto> suppliers = repository.findSuppliers();
        if (suppliers.stream().anyMatch(sup -> sup.getId() == id))
            throw new InvalidRequest("Borrar registro",
                    "no se pueden eliminar los proveedores",
                    "eliminar Proveedor");
        validateExists(id);
        repository.deleteById(id);
    }

    //obtener todos los sujetos, sirve para obtener posibles clientes
    @Override
    public List<SujetoDTO> getAll() {
        List<Sujeto> sujetos = repository.findAll();
        return sujetos.stream().map(sujeto -> mapperService.toSujetoDTO(sujeto)).toList();
    }

    //obtener todos los empleados que son vendedores y atiende en el instante en que se hace la consulta
    @Override
    public List<SujetoDTO> getSellers() {
        LocalDateTime now = LocalDateTime.now();
        Date date = Date.from(now.toLocalDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String dayOfWeek = new SimpleDateFormat("EEE", new Locale("es", "ES"))
                .format(calendar.getTime());
        String dia = Normalizer.normalize(dayOfWeek, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "").toUpperCase().substring(0, 3);
        String hor = now.getHour() < 10 ? "0" + now.getHour() : now.getHour() + "";
        String min = now.getMinute() < 10 ? "0" + now.getMinute() : now.getMinute() + "";
        String sec = now.getSecond() < 10 ? "0" + now.getSecond() : now.getSecond() + "";
        String hora =  hor + ":" + min + ":" + sec;
        List<Sujeto> sujetos = repository.findSellers(hora,dia);
        return sujetos.stream().map(sujeto -> mapperService.toSujetoDTO(sujeto)).toList();
    }

    //obtener todos los proveedores
    @Override
    public List<SujetoDTO> getSuppliers() {
        List<Sujeto> sujetos = repository.findSuppliers();
        return sujetos.stream().map(sujeto -> mapperService.toSujetoDTO(sujeto)).toList();
    }

    @Override
    public List<MunicipioDTO> getMunicipios() {
        List<Municipio> municipios = municipioRepository.findAll();
        return municipios.stream().map(mun -> mapperService.toMunicipioDTO(mun)).toList();
    }

    private void validations(SujetoDTO sujeto, int idMunicipio){
        municipioRepository.findById(idMunicipio).orElseThrow(
                () -> new ResourceNotFound("Municipio","id",idMunicipio + ""));
        if (sujeto.getDireccion() == null)
            throw new InvalidResource("Direccion de "+sujeto.getTipoSujeto().getValue(),
                    "la direccion no es valida", null);
    }

    private void validateExists(int id){
        if (!repository.existsById(id))
            throw new ResourceNotFound("Persona", "la persona indicada no existe", id+ "");
    }
}
