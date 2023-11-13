package co.edu.uptc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Embeddable
public class ProductoVentaPK {

    @ManyToOne @JoinColumn(name = "codigo_producto", referencedColumnName = "codigo_producto", nullable = false)
    private Producto producto;

    @ManyToOne @JoinColumn(name = "id_venta", referencedColumnName = "id_venta",nullable = false)
    private Venta venta;
}
