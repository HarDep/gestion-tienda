package co.edu.uptc.repositories;

import co.edu.uptc.models.ProductoCompra;
import co.edu.uptc.models.ProductoCompraPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoCompraRepository extends JpaRepository<ProductoCompra, ProductoCompraPK> {
}
