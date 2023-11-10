package co.edu.uptc.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Entity @Table(name = "empleados_roles")
public class EmpleadoRol {
    @EmbeddedId
    private EmpleadoRolPK primaryKey;

    @ManyToOne @JoinColumn(name = "id_empleado") @JsonBackReference
    private Sujeto empleado;

    @ManyToOne @JoinColumn(name = "id_rol_empleado")
    private RolEmpleado rol;

    @Column(name = "es_activo_empleado_rol", nullable = false)
    private Boolean esActivo;
}
