package co.edu.uptc.services;

import co.edu.uptc.dtos.*;
import co.edu.uptc.entities.*;

import java.util.List;

public interface MapperService {
    ProductoProveedorDTO toProductoProveedorDTO(ProductoProveedor prod);
    Compra toCompra(int idLote, int idProveedor);
    Venta toVenta(int idCliente, int idEmpleado);
    CompraDTO toCompraDTO(Compra compra, List<ProductoCompraDTO> productos);
    VentaDTO toVentaDTO(Venta venta, List<ProductoVentaDTO> productos);
    SujetoDTO toSujetoDTO(Sujeto sujeto);
    Sujeto toSujeto(SujetoDTO sujeto, int idMunicipio);
    ProductoCompra toProductoCompra(ProductoCompraDTO prod, int compraId);
    ProductoVenta toProductoVenta(ProductoVentaDTO prod, int ventaId);
    ProductoCompraDTO toProductoCompraDTO(Producto producto, ProductoCompra productoCompra);
    ProductoVentaDTO toProductoVentaDTO(Producto producto, ProductoVenta productoVenta);
    LoteDTO toLoteDTO(Lote lote);
    MunicipioDTO toMunicipioDTO(Municipio municipio);
    ProductoVentaDTO toProductoVentaDTO(Stock stock);
}
