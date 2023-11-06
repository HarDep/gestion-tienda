package co.edu.uptc.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class CompraDTO {
    @NotEmpty
    private int idLote;
    @NotEmpty
    private SujetoDTO proveedor;
    @NotEmpty
    private List<ProductoDTO> productos;
}
