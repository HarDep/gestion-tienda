package co.edu.uptc.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Embeddable
public class EmpleadoRolPK {
    @Column(name = "id_empleado", nullable = false)
    private int empleadoId;

    @Column(name = "id_rol_empleado", nullable = false)
    private int rolId;
}
