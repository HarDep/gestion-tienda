package co.edu.uptc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Entity @Table(name = "productos_proveedores")
public class ProductoProveedor {
    @EmbeddedId
    private ProductoProveedorPK primaryKey;

    @Column(name = "precio_producto_proveedor", nullable = false)
    private double precioProducto;
}
