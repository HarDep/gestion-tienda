package co.edu.uptc.models;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @Column(name = "id_lote",nullable = false)
    private int id;

    @JsonFormat(pattern = "YYYY-MM-DD")
    @Column(name = "fecha_lote", nullable = false)
    private LocalDate fechaLote;
}
