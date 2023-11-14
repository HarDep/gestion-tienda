package co.edu.uptc.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Entity @Table(name = "compras")
public class Compra {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private int id;

    @ManyToOne @JoinColumn(name = "id_lote", referencedColumnName = "id_lote")
    private Lote lote;

    @ManyToOne @JoinColumn(name = "id_proveedor", referencedColumnName = "id_sujeto")
    private Sujeto proveedor;

    @Column(name = "fecha_hora_compra")
    private LocalDateTime fecha;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "productos_compras", joinColumns = @JoinColumn(name = "id_compra", referencedColumnName = "id_compra"),
            inverseJoinColumns = @JoinColumn(name = "codigo_producto", referencedColumnName = "codigo_producto"))
    private Set<Producto> productos = new HashSet<>();
}
