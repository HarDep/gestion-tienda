package co.edu.uptc.services;

import co.edu.uptc.dtos.ProductoDTO;

import java.util.List;

public interface ProductoProveedorService {
    List<ProductoDTO> getSupplierProducts();
}
