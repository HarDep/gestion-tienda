package co.edu.uptc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data @AllArgsConstructor @NoArgsConstructor
public class Sujeto {
    private int id;
    private Municipio municipio;
    private String nombre;
    private String apellido;
    private String telefono;
    private String tipoSujeto;
    private String direccion;
    private String numeroDocumento;
    private String nit;
    private Set<EmpleadoRol> roles = new HashSet<>();
    private Set<EmpleadoHorario> horarios = new HashSet<>();
}
