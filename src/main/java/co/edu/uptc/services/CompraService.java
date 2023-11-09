package co.edu.uptc.services;

import co.edu.uptc.dtos.CompraDTO;
import co.edu.uptc.dtos.ProductoProveedorDTO;
import co.edu.uptc.models.Lote;

import java.util.List;
import java.util.Optional;

public interface CompraService {
    Optional<CompraDTO> save(CompraDTO compra, int idLote, int idProveedor);
    List<ProductoProveedorDTO> getSupplierProducts(int idProveedor);
    List<Lote> getAllLotes();
}
