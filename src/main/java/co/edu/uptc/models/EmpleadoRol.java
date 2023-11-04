package co.edu.uptc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class EmpleadoRol {
    private Sujeto empleado;
    private RolEmpleado rol;
    private boolean esActivo;
}
