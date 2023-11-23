package co.edu.uptc.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Entity @Table(name = "stock")
public class Stock {

    @Id @Column(name = "codigo_producto",insertable=false, updatable=false)
    private String codigo;

    @Column(name = "precio_producto",insertable=false, updatable=false)
    private double precioProducto;

    @Column(name = "cantidad_producto",insertable=false, updatable=false)
    private int cantidadProducto;
}
