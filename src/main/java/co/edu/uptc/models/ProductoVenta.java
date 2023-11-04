package co.edu.uptc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ProductoVenta {
    private Producto producto;
    private Venta venta;
    private double precioProducto;
    private int cantidadProducto;
}
