package co.edu.uptc.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne @JoinColumn(name = "id_empleado") @JsonBackReference
    private Sujeto empleado;

    @ManyToOne @JoinColumn(name = "id_horario")
    private Horario horario;

    @Column(name = "es_activo_empleado_horario", nullable = false)
    private Boolean esActivo;
}
