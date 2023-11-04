package co.edu.uptc.models;

import co.edu.uptc.models.Compra;
import co.edu.uptc.models.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ProductoCompra {
    private Producto producto;
    private Compra compra;
    private double precioProducto;
    private int cantidadProducto;
}
