package co.edu.uptc.dtos;

import co.edu.uptc.models.TipoSujeto;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class SujetoDTO {
    private int idSujeto;
    private TipoSujeto tipoSujeto;
    private String municipio;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String numeroDoc;
    private String nit;
}
