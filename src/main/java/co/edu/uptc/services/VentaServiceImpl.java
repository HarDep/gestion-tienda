package co.edu.uptc.services;

import co.edu.uptc.dtos.VentaDTO;
import co.edu.uptc.repositories.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaServiceImpl implements VentaService{
    @Autowired
    private VentaRepository repository;

    //guardar una venta, debe tener los productosDTO, el cliente y el empleado (SujetoDTO),
    @Override
    public VentaDTO save(VentaDTO venta) {
        return null;
    }
}
