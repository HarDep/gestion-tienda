package co.edu.uptc.services;

import co.edu.uptc.dtos.ProductoDTO;
import co.edu.uptc.models.ProductoVenta;

import java.util.List;

public interface ProductoVentaService {
    ProductoVenta save(ProductoVenta productoVenta);
    List<ProductoDTO> getStock();
}
