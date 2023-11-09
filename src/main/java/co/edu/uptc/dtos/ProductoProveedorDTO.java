package co.edu.uptc.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ProductoProveedorDTO {
    private String codigoProducto;
    private String nombreProducto;
    private String categoriaProducto;
    private String descripcionProducto;
    private SujetoDTO proveedor;
    private double precio;
}
