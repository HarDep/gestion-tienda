package co.edu.uptc.repositories;

import co.edu.uptc.entities.ProductoCompra;
import co.edu.uptc.entities.ProductoCompraPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoCompraRepository extends JpaRepository<ProductoCompra, ProductoCompraPK> {
}
