package co.edu.uptc.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Embeddable
public class ProductoProveedorPK {
    @Column(name = "codigo_producto", nullable = false)
    private String codigoProducto;

    @Column(name = "id_proveedor", nullable = false)
    private int proveedorId;
}
