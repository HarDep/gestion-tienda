package co.edu.uptc.services;

import co.edu.uptc.dtos.CompraDTO;
import co.edu.uptc.repositories.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraServiceImpl implements CompraService {
    @Autowired
    private CompraRepository compraRepository;

    //guardar una - debe tener los productosDTO que se utilizaran para la compra,
    // el loteDTO y el proveedor (SujetoDTO)
    @Override
    public CompraDTO save(CompraDTO compra) {
        return null;
    }
}
