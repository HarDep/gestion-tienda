package co.edu.uptc.repositories;

import co.edu.uptc.entities.ProductoVenta;
import co.edu.uptc.entities.ProductoVentaPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoVentaRepository extends JpaRepository<ProductoVenta, ProductoVentaPK> {
    //obtener el stock de productos
    @Query(value = "SELECT *, NULL AS id_venta FROM (SELECT productos.codigo_producto AS codigo_producto, " +
            "AVG(productos_compras.precio_producto_compra) AS precio_producto_venta, " +
            "SUM(productos_compras.cantidad_producto_compra) - SUM(productos_ventas.cantidad_producto_venta) AS " +
            "cantidad_producto_venta FROM productos JOIN productos_compras ON productos.codigo_producto = " +
            "productos_compras.codigo_producto JOIN productos_ventas ON productos.codigo_producto = " +
            "productos_ventas.codigo_producto GROUP BY productos.codigo_producto, productos.nombre_producto) AS " +
            "productos_ventas", nativeQuery = true)
    List<ProductoVenta> getStock();
}
