package co.edu.uptc.services;

import co.edu.uptc.dtos.MunicipioDTO;
import co.edu.uptc.dtos.SujetoDTO;
import co.edu.uptc.exceptions.InvalidResource;

import java.util.List;
import java.util.Optional;

public interface SujetoService {
    Optional<SujetoDTO> save(SujetoDTO sujeto, int idMunicipio);
    Optional<SujetoDTO> update(SujetoDTO sujeto, int idSujeto, int idMunicipio);
    void delete(int id);
    List<SujetoDTO> getAll();
    List<SujetoDTO> getSellers();
    List<SujetoDTO> getSuppliers();
    List<MunicipioDTO> getMunicipios();
}
