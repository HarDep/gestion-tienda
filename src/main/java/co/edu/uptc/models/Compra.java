package co.edu.uptc.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Entity @Table(name = "compras")
public class Compra {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra",nullable = false)
    private int id;

    @ManyToOne @JoinColumn(name = "id_lote")
    private Lote lote;

    @ManyToOne @JoinColumn(name = "id_proveedor")
    private Sujeto proveedor;

    @JsonFormat(pattern = "YYYY-MM-DD HH24:MI:SS")
    @Column(name = "fecha_hora_compra", nullable = false)
    private LocalDateTime fecha;

    @OneToMany(mappedBy = "compras", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ProductoCompra> productos = new HashSet<>();
}
