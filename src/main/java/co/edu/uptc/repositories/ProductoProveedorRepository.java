package co.edu.uptc.repositories;

import co.edu.uptc.entities.ProductoProveedor;
import co.edu.uptc.entities.ProductoProveedorPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoProveedorRepository extends JpaRepository<ProductoProveedor, ProductoProveedorPK> {
    //query para obtener los productos de un proveedor
    @Query(value = "SELECT * FROM productos_proveedores WHERE id_proveedor = :supplierId", nativeQuery = true)
    List<ProductoProveedor> getSupplierProducts(@Param("supplierId") int supplierId);
}
