package co.edu.uptc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ProductoProveedor {
    private Producto producto;
    private Sujeto proveedor;
    private double precioProducto;
    private int diasDuracionProducto;
}
