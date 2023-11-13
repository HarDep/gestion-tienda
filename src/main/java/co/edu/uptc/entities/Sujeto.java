package co.edu.uptc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Entity @Table(name = "sujetos", uniqueConstraints = {@UniqueConstraint(columnNames = "telefono_sujeto"),
        @UniqueConstraint(columnNames = "nit_empresa"), @UniqueConstraint(columnNames = "numero_documento_persona")})
public class Sujeto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sujeto",nullable = false)
    private int id;

    @ManyToOne @JoinColumn(name = "id_municipio", referencedColumnName = "id_municipio")
    private Municipio municipio;

    @Column(name = "nombre_sujeto", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido_persona", length = 50)
    private String apellido;

    @Column(name = "telefono_sujeto", nullable = false, length = 20)
    private String telefono;

    @Enumerated(EnumType.STRING) @Column(name = "tipo_sujeto", nullable = false, length = 3)
    private TipoSujeto tipoSujeto;

    @Column(name = "direccion_sujeto", length = 50)
    private String direccion;

    @Column(name = "numero_documento_persona", length = 50)
    private String numeroDocumento;

    @Column(name = "nit_empresa")
    private String nit;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "empleados_roles", joinColumns = @JoinColumn(name = "id_empleado", referencedColumnName = "id_sujeto"),
            inverseJoinColumns = @JoinColumn(name = "id_rol_empleado", referencedColumnName = "id_rol_empleado"))
    private Set<RolEmpleado> roles = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "empleados_horarios", joinColumns = @JoinColumn(name = "id_empleado", referencedColumnName = "id_sujeto"),
            inverseJoinColumns = @JoinColumn(name = "id_horario", referencedColumnName = "id_horario"))
    private Set<Horario> horarios = new HashSet<>();
}
