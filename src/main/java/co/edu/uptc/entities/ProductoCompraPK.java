package co.edu.uptc.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Embeddable
public class ProductoCompraPK {

    @ManyToOne
    @JoinColumn(name = "codigo_producto",referencedColumnName = "codigo_producto")
    private Producto producto;

    @ManyToOne @JoinColumn(name = "id_compra",referencedColumnName = "id_compra")
    private Compra compra;
}
