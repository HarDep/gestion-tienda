package co.edu.uptc.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Entity @Table(name = "productos_ventas")
public class ProductoVenta {
    @EmbeddedId
    private ProductoVentaPK primaryKey;

    @Column(name = "precio_producto_venta", nullable = false)
    private double precioProducto;

    @Column(name = "cantidad_producto_venta", nullable = false)
    private int cantidadProducto;
}
