package co.edu.uptc.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Entity @Table(name = "municipios")
public class Municipio {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_municipio",nullable = false)
    private int id;

    @Column(name = "nombre_municipio", nullable = false, length = 50)
    private String nombre;
}
