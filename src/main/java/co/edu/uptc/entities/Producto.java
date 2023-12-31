package co.edu.uptc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Entity @Table(name = "productos")
public class Producto {
    @Id @Column(name = "codigo_producto")
    private String codigo;

    @ManyToOne @JoinColumn(name = "id_categoria_producto", referencedColumnName = "id_categoria_producto")
    private CategoriaProducto categoria;

    @Column(name = "nombre_producto")
    private String nombre;

    @Column(name = "descripcion_producto")
    private String descripcion;
}
