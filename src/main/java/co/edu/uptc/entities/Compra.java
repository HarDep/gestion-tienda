package co.edu.uptc.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "productos_compras", joinColumns = @JoinColumn(name = "id_compra", referencedColumnName = "id_compra"),
            inverseJoinColumns = @JoinColumn(name = "codigo_producto", referencedColumnName = "codigo_producto"))
    private Set<Producto> productos = new HashSet<>();
}
