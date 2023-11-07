package co.edu.uptc.services;

import co.edu.uptc.dtos.ProductoDTO;
import co.edu.uptc.models.ProductoVenta;
import co.edu.uptc.repositories.ProductoVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoVentaServiceImpl implements ProductoVentaService{
    @Autowired
    private ProductoVentaRepository repository;

    @Override
    public ProductoVenta save(ProductoVenta productoVenta) {
        return null;
    }

    //obtener el stock
    @Override
    public List<ProductoDTO> getStock() {
        return null;
    }
}
