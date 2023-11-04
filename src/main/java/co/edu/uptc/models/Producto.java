package co.edu.uptc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Producto {
    private String codigo;
    private CategoriaProducto categoria;
    private String nombre;
    private String descripcion;
}
