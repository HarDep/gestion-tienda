package co.edu.uptc.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @ManyToOne @JoinColumn(name = "codigo_producto")
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "id_compra", nullable = false)
    private Compra compra;

    @Column(name = "precio_producto_compra", nullable = false)
    private double precioProducto;

    @Column(name = "cantidad_producto_compra", nullable = false)
    private int cantidadProducto;

    @JsonFormat(pattern = "YYYY-MM-DD")
    @Column(name = "fecha_vencimiento_producto_compra", nullable = false)
    private LocalDate fechaVencimientoProducto;
}
