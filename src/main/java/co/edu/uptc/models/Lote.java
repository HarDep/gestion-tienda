package co.edu.uptc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @AllArgsConstructor @NoArgsConstructor
public class Lote {
    private int id;
    private LocalDate fechaLote;
}
