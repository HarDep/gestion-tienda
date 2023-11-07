package co.edu.uptc.services;

import co.edu.uptc.models.ProductoCompra;
import co.edu.uptc.repositories.ProductoCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoCompraServiceImpl implements ProductoCompraService{
    @Autowired
    private ProductoCompraRepository repository;

    @Override
    public ProductoCompra save(ProductoCompra productoCompra) {
        return null;
    }
}
