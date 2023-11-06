package co.edu.uptc.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class VentaDTO {
    @NotEmpty
    private SujetoDTO cliente;
    @NotEmpty
    private SujetoDTO empleado;
    @NotEmpty
    private List<ProductoDTO> productos;
    private double precioEntrega;
}
