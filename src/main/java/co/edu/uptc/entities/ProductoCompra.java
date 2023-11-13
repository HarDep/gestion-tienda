package co.edu.uptc.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Entity @Table(name = "productos_compras")
public class ProductoCompra {
    @EmbeddedId
    private ProductoCompraPK primaryKey;

    @Column(name = "precio_producto_compra", nullable = false)
    private double precioProducto;

    @Column(name = "cantidad_producto_compra", nullable = false)
    private int cantidadProducto;

    @JsonFormat(pattern = "YYYY-MM-DD")
    @Column(name = "fecha_vencimiento_producto_compra", nullable = false)
    private LocalDate fechaVencimientoProducto;
}
