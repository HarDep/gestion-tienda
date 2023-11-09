package co.edu.uptc.services;

import co.edu.uptc.dtos.SujetoDTO;
import co.edu.uptc.models.Sujeto;
import co.edu.uptc.repositories.SujetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class SujetoServiceImpl implements SujetoService {
    @Autowired
    private SujetoRepository repository;
    @Autowired
    private MapperService mapperService;

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
}
