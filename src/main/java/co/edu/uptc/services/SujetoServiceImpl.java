package co.edu.uptc.services;

import co.edu.uptc.dtos.SujetoDTO;
import co.edu.uptc.repositories.SujetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SujetoServiceImpl implements SujetoService {
    @Autowired
    private SujetoRepository repository;

    //obtener todos los sujetos, sirve para obtener posibles clientes
    @Override
    public List<SujetoDTO> getAll() {
        return null;
    }

    //obtener todos los empleados
    @Override
    public List<SujetoDTO> getEmployees() {
        return null;
    }

    //obtener todos los proveedores
    @Override
    public List<SujetoDTO> getSuppliers() {
        return null;
    }
}
