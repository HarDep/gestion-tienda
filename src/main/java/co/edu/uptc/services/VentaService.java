package co.edu.uptc.services;

import co.edu.uptc.dtos.ProductoVentaDTO;
import co.edu.uptc.dtos.VentaDTO;

import java.util.List;
import java.util.Optional;

public interface VentaService {
    Optional<VentaDTO> save(VentaDTO venta, int idCliente, int idEmpleado);
    List<ProductoVentaDTO> getStock();
}
