package co.edu.uptc.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class CompraDTO {
    private int id;
    private LoteDTO lote;
    private SujetoDTO proveedor;
    private LocalDateTime fecha;
    @NotNull
    private List<ProductoCompraDTO> productos;
}
