package co.edu.uptc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class EmpleadoHorario {
    private Horario horario;
    private Sujeto empleado;
    private boolean esActivo;
}
