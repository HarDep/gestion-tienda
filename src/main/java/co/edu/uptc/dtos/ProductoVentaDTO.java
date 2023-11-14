package co.edu.uptc.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ProductoVentaDTO {
    @NotEmpty @Size(min = 5,message = "El codigo de producto debe tener entre 5 y 255 caracteres",max = 255)
    private String codigo;
    private String categoria;
    private String nombre;
    private String descripcion;
    @NotEmpty @Min(value = 1, message = "No pueden haber números de cantidad iguales inferiores a 0")
    private int cantidad;
    @NotEmpty @Min(value = 1, message = "No pueden haber números de precio iguales inferiores a 0")
    private double precio;
}
