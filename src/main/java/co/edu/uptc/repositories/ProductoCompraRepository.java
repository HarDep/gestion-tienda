package co.edu.uptc.repositories;

import co.edu.uptc.models.ProductoCompra;
import co.edu.uptc.models.ProductoCompraPK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoCompraRepository extends CrudRepository<ProductoCompra, ProductoCompraPK> {
}
