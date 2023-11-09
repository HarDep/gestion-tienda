package co.edu.uptc.repositories;

import co.edu.uptc.models.ProductoVenta;
import co.edu.uptc.models.ProductoVentaPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoVentaRepository extends JpaRepository<ProductoVenta, ProductoVentaPK> {
    //obtener el stock de productos
    @Query(value = "SELECT ...", nativeQuery = true)
    List<ProductoVenta> getStock();
}
