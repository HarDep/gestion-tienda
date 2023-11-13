package co.edu.uptc.entities;

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

    @Column(name = "es_activo_empleado_rol", nullable = false)
    private Boolean esActivo;
}
