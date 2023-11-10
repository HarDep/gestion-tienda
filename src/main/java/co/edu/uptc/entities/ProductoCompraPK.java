package co.edu.uptc.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Embeddable
public class ProductoCompraPK {
    @Column(name = "codigo_producto", nullable = false)
    private String codigoProducto;

    @Column(name = "id_compra", nullable = false)
    private int compraId;
}
