package co.edu.uptc.repositories;

import co.edu.uptc.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock,String> {
    //obtener el stock de productos
    @Query(value = "SELECT * FROM (SELECT * FROM (SELECT productos.codigo_producto, " +
            "AVG(productos_compras.precio_producto_compra) AS precio_producto, " +
            "SUM(productos_compras.cantidad_producto_compra) - SUM(productos_ventas.cantidad_producto_venta) " +
            "AS cantidad_producto FROM productos JOIN productos_compras ON productos.codigo_producto = " +
            "productos_compras.codigo_producto JOIN productos_ventas ON productos.codigo_producto = " +
            "productos_ventas.codigo_producto GROUP BY productos.codigo_producto, productos.nombre_producto) " +
            "AS compras_ventas UNION SELECT codigo_producto, precio_producto_compra AS precio_producto, " +
            "cantidad_producto_compra AS cantidad_producto FROM productos_compras WHERE codigo_producto " +
            "NOT IN (SELECT codigo_producto FROM productos_ventas)) AS stock", nativeQuery = true)
    List<Stock> getStock();
}
