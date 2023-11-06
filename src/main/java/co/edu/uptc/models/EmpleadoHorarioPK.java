package co.edu.uptc.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Embeddable
public class EmpleadoHorarioPK {
    @Column(name = "id_empleado", nullable = false)
    private int empleadoId;

    @Column(name = "id_horario", nullable = false)
    private int horarioId;
}
