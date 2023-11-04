package co.edu.uptc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data @AllArgsConstructor @NoArgsConstructor
public class Venta {
    private int id;
    private Sujeto cliente;
    private Sujeto empleado;
    private LocalDate fechaVenta;
    private LocalDate fechaEntrega;
    private double precioEntrega;
    private Set<ProductoVenta> productos = new HashSet<>();
}
