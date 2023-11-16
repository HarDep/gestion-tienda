package co.edu.uptc.dtos;

import co.edu.uptc.entities.TipoSujeto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class SujetoDTO {
    private int idSujeto;
    private TipoSujeto tipoSujeto;
    private String municipio;
    @NotEmpty @Size(min = 3, max = 50, message = "El nombre debe contener entre 3 y 50 caracteres")
    private String nombre;
    @Size(min = 3, max = 50, message = "El apellido debe contener entre 3 y 50 caracteres")
    private String apellido;
    @NotEmpty @Size(min = 5, max = 20, message = "El telefono debe contener entre 5 y 20 caracteres")
    private String telefono;
    @Size(min = 5, max = 50, message = "La dirección debe contener entre 5 y 50 caracteres")
    private String direccion;
    @Size(min = 1, max = 50, message = "El numero de documento debe contener entre 1 y 50 caracteres")
    private String numeroDoc;
    @Size(min = 1, max = 255, message = "El NIT debe contener entre 1 y 255 caracteres")
    private String nit;
}
