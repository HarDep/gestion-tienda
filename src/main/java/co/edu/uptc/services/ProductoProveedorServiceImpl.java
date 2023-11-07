package co.edu.uptc.services;

import co.edu.uptc.dtos.ProductoDTO;
import co.edu.uptc.repositories.ProductoProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoProveedorServiceImpl implements ProductoProveedorService{
    @Autowired
    private ProductoProveedorRepository repository;

    //obtener los productos de un proveedor
    @Override
    public List<ProductoDTO> getSupplierProducts() {
        return null;
    }
}
