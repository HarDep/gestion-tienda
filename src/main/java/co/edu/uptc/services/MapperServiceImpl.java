package co.edu.uptc.services;

import co.edu.uptc.dtos.*;
import co.edu.uptc.models.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MapperServiceImpl implements MapperService{
    @Override
    public ProductoProveedorDTO toProductoProveedorDTO(ProductoProveedor prod) {
        SujetoDTO proveedor = toSujetoDTO(prod.getProveedor());
        Producto producto = prod.getProducto();
        return ProductoProveedorDTO.builder().proveedor(proveedor).codigoProducto(producto.getCodigo())
                .nombreProducto(producto.getNombre()).categoriaProducto(producto.getCategoria().getNombre())
                .descripcionProducto(producto.getDescripcion()).precio(prod.getPrecioProducto()).build();
    }

    @Override
    public Compra toCompra(int idLote, int idProveedor) {
        Lote lote = Lote.builder().id(idLote).build();
        Sujeto sujeto = Sujeto.builder().id(idProveedor).build();
        return Compra.builder().lote(lote).proveedor(sujeto).fecha(LocalDateTime.now()).build();
    }

    @Override
    public Venta toVenta(int idCliente, int idEmpleado) {
        Sujeto cliente = Sujeto.builder().id(idCliente).build();
        Sujeto empleado = Sujeto.builder().id(idEmpleado).build();
        return Venta.builder().cliente(cliente).empleado(empleado).fechaVenta(LocalDateTime.now()).build();
    }

    @Override
    public CompraDTO toCompraDTO(Compra compra, List<ProductoCompraDTO> productos) {
        Lote lote1 = compra.getLote();
        LoteDTO lote = LoteDTO.builder().id(lote1.getId()).fecha(lote1.getFechaLote()).build();
        Sujeto sujeto1 = compra.getProveedor();
        SujetoDTO sujeto = toSujetoDTO(sujeto1);
        return CompraDTO.builder().id(compra.getId()).lote(lote).proveedor(sujeto)
                .fecha(compra.getFecha()).productos(productos).build();
    }

    @Override
    public VentaDTO toVentaDTO(Venta venta, List<ProductoVentaDTO> productos) {
        Sujeto cliente1 = venta.getCliente();
        SujetoDTO cliente = toSujetoDTO(cliente1);
        Sujeto empleado1 = venta.getEmpleado();
        SujetoDTO empleado = toSujetoDTO(empleado1);
        return VentaDTO.builder().id(venta.getId()).cliente(cliente).empleado(empleado)
                .fecha(venta.getFechaVenta()).productos(productos).build();
    }

    @Override
    public SujetoDTO toSujetoDTO(Sujeto sujeto){
        return SujetoDTO.builder().idSujeto(sujeto.getId()).tipoSujeto(sujeto.getTipoSujeto())
                .municipio(sujeto.getMunicipio().getNombre()).nombre(sujeto.getNombre())
                .apellido(sujeto.getApellido()).telefono(sujeto.getTelefono()).direccion(sujeto.getDireccion())
                .numeroDoc(sujeto.getNumeroDocumento()).nit(sujeto.getNit()).build();
    }

    @Override
    public ProductoCompra toProductoCompra(ProductoCompraDTO prod, int compraId) {
        LocalDate fechaVencimiento = LocalDate.of(prod.getAnioVencimiento(),prod.getMesVencimiento(),
                prod.getDiaVencimiento());
        ProductoCompraPK primaryKey = ProductoCompraPK.builder().compraId(compraId).codigoProducto(prod.getCodigo()).build();
        return ProductoCompra.builder().primaryKey(primaryKey)
                .precioProducto(prod.getPrecio()).cantidadProducto(prod.getCantidad())
                .fechaVencimientoProducto(fechaVencimiento).build();
    }

    @Override
    public ProductoVenta toProductoVenta(ProductoVentaDTO prod, int ventaId) {
        ProductoVentaPK primaryKey = ProductoVentaPK.builder().ventaId(ventaId).codigoProducto(prod.getCodigo()).build();
        return ProductoVenta.builder().primaryKey(primaryKey).precioProducto(prod.getPrecio())
                .cantidadProducto(prod.getCantidad()).build();
    }

    @Override
    public ProductoCompraDTO toProductoCompraDTO(Producto producto, ProductoCompra productoCompra) {
        LocalDate fechaVencimiento = productoCompra.getFechaVencimientoProducto();
        return ProductoCompraDTO.builder().codigo(producto.getCodigo())
                .nombre(producto.getNombre()).categoria(producto.getCategoria().getNombre())
                .descripcion(producto.getDescripcion()).cantidad(productoCompra.getCantidadProducto())
                .precio(productoCompra.getPrecioProducto()).anioVencimiento(fechaVencimiento.getYear())
                .mesVencimiento(fechaVencimiento.getMonthValue())
                .diaVencimiento(fechaVencimiento.getDayOfMonth()).build();
    }

    @Override
    public ProductoVentaDTO toProductoVentaDTO(Producto producto, ProductoVenta productoVenta) {
        return ProductoVentaDTO.builder().codigo(producto.getCodigo()).nombre(producto.getNombre())
                .categoria(producto.getCategoria().getNombre()).descripcion(producto.getDescripcion())
                .cantidad(productoVenta.getCantidadProducto()).precio(productoVenta.getPrecioProducto())
                .build();
    }
}
