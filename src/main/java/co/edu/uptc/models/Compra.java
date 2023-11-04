package co.edu.uptc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data @AllArgsConstructor @NoArgsConstructor
public class Compra {
    private int id;
    private Lote lote;
    private Sujeto proveedor;
    private LocalDate fecha;
    private Set<ProductoCompra> productos = new HashSet<>();
}
