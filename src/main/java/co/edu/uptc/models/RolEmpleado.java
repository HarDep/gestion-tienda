package co.edu.uptc.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Entity @Table(name = "roles_empleado")
public class RolEmpleado {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol_empleado",nullable = false)
    private int id;

    @Column(name = "nombre_rol_empleado", nullable = false, length = 50)
    private int nombre;
}
