package co.edu.uptc.services;

import co.edu.uptc.dtos.SujetoDTO;

import java.util.List;

public interface SujetoService {
    List<SujetoDTO> getAll();
    List<SujetoDTO> getSellers();
    List<SujetoDTO> getSuppliers();
}
