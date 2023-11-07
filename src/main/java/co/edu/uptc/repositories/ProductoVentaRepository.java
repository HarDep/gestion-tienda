package co.edu.uptc.repositories;

import co.edu.uptc.models.ProductoVenta;
import co.edu.uptc.models.ProductoVentaPK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoVentaRepository extends CrudRepository<ProductoVenta, ProductoVentaPK> {
}
