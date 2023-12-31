package co.edu.uptc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Entity @Table(name = "lotes")
public class Lote {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lote")
    private int id;

    @Column(name = "fecha_lote")
    private LocalDate fechaLote;
}
