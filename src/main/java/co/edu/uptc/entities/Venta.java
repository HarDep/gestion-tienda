package co.edu.uptc.entities;

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
@Entity @Table(name = "ventas")
public class Venta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta",nullable = false)
    private int id;

    @ManyToOne @JoinColumn(name = "id_cliente", referencedColumnName = "id_sujeto")
    private Sujeto cliente;

    @ManyToOne @JoinColumn(name = "id_empleado", referencedColumnName = "id_sujeto")
    private Sujeto empleado;

    @JsonFormat(pattern = "YYYY-MM-DD HH24:MI:SS")
    @Column(name = "fecha_hora_venta", nullable = false)
    private LocalDateTime fechaVenta;

    @JsonFormat(pattern = "YYYY-MM-DD HH24:MI:SS")
    @Column(name = "fecha_hora_entrega_venta")
    private LocalDateTime fechaEntrega;

    @Column(name = "precio_entrega_venta")
    private double precioEntrega;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "productos_ventas", joinColumns = @JoinColumn(name = "id_venta", referencedColumnName = "id_venta"),
            inverseJoinColumns = @JoinColumn(name = "codigo_producto", referencedColumnName = "codigo_producto"))
    private Set<Producto> productos = new HashSet<>();
}
