package co.edu.uptc.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Entity @Table(name = "horarios")
public class Horario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario",nullable = false)
    private int id;

    @Column(name = "dia_semana_horario", nullable = false, length = 3)
    private String diaSemana;

    @JsonFormat(pattern = "HH24:MI:SS")
    @Column(name = "hora_inicio_horario", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "numero_horas_horario", nullable = false)
    private short numeroHoras;
}
