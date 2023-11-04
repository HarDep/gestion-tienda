package co.edu.uptc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data @AllArgsConstructor @NoArgsConstructor
public class Horario {
    private int id;
    private String diaSemana;
    private LocalTime horaInicio;
    private short numeroHoras;
}
