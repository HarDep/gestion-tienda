package co.edu.uptc.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Entity @Table(name = "categorias_producto")
public class CategoriaProducto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria_producto",nullable = false)
    private int id;

    @Column(name = "nombre_categoria_producto", nullable = false, length = 50)
    private String nombre;
}
