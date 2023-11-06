package co.edu.uptc.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne @JoinColumn(name = "codigo_producto")
    private Producto producto;

    @ManyToOne @JoinColumn(name = "id_venta") @JsonBackReference
    private Venta venta;

    @Column(name = "precio_producto_venta", nullable = false)
    private double precioProducto;

    @Column(name = "cantidad_producto_venta", nullable = false)
    private int cantidadProducto;
}
