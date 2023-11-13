package co.edu.uptc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Entity @Table(name = "empleados_horarios")
public class EmpleadoHorario {
    @EmbeddedId
    private EmpleadoHorarioPK primaryKey;

    @Column(name = "es_activo_empleado_horario", nullable = false)
    private Boolean esActivo;
}
