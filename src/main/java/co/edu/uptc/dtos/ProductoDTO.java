package co.edu.uptc.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ProductoDTO {
    @NotEmpty @Size(min = 5,message = "El codigo de producto debe tener entre 5 y 255 caracteres",max = 255)
    private String codigo;
    private String categoria;
    private String nombre;
    private String descripcion;
    @NotEmpty
    private int cantidad;
    @NotEmpty
    private double precio;
    private LocalDate fechaVencimiento;
}
