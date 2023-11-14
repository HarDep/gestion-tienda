package co.edu.uptc.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class VentaDTO {
    private int id;
    private SujetoDTO cliente;
    private SujetoDTO empleado;
    private LocalDateTime fecha;
    @NotNull
    private List<ProductoVentaDTO> productos;
    @Min(value = 1, message = "No pueden haber números de precio iguales inferiores a 0")
    private double precioEntrega;
}
