package co.edu.uptc.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Embeddable
public class EmpleadoRolPK {

    @ManyToOne
    @JoinColumn(name = "id_empleado",referencedColumnName = "id_sujeto")
    private Sujeto empleado;

    @ManyToOne @JoinColumn(name = "id_rol_empleado",referencedColumnName = "id_rol_empleado")
    private RolEmpleado rol;
}
