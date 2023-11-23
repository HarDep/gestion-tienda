package co.edu.uptc.services;

import co.edu.uptc.dtos.*;
import co.edu.uptc.entities.*;
import co.edu.uptc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MapperServiceImpl implements MapperService{
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CategoriaProductoRepository categoriaProductoRepository;
    @Autowired
    private LoteRepository loteRepository;
    @Autowired
    private SujetoRepository sujetoRepository;
    @Autowired
    private MunicipioRepository municipioRepository;
    @Override
    public ProductoProveedorDTO toProductoProveedorDTO(ProductoProveedor prod) {
        SujetoDTO proveedor = toSujetoDTO(prod.getPrimaryKey().getProveedor());
        Producto producto = prod.getPrimaryKey().getProducto();
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
        Lote lote1 = loteRepository.findById(compra.getLote().getId()).orElse(new Lote());
        LoteDTO lote = LoteDTO.builder().id(lote1.getId()).fecha(lote1.getFechaLote()).build();
        Sujeto sujeto1 = sujetoRepository.findById(compra.getProveedor().getId()).orElse(new Sujeto());
        SujetoDTO sujeto = toSujetoDTO(sujeto1);
        return CompraDTO.builder().id(compra.getId()).lote(lote).proveedor(sujeto)
                .fecha(compra.getFecha()).productos(productos).build();
    }

    @Override
    public VentaDTO toVentaDTO(Venta venta, List<ProductoVentaDTO> productos) {
        Sujeto cliente1 = sujetoRepository.findById(venta.getCliente().getId()).orElse(new Sujeto());
        SujetoDTO cliente = toSujetoDTO(cliente1);
        Sujeto empleado1 = sujetoRepository.findById(venta.getEmpleado().getId()).orElse(new Sujeto());
        SujetoDTO empleado = toSujetoDTO(empleado1);
        return VentaDTO.builder().id(venta.getId()).cliente(cliente).empleado(empleado)
                .fecha(venta.getFechaVenta()).productos(productos).build();
    }

    @Override
    public SujetoDTO toSujetoDTO(Sujeto sujeto){
        Municipio mun = sujeto.getMunicipio() != null ? municipioRepository.findById(sujeto.getMunicipio()
                .getId()).orElse(new Municipio()) : new Municipio();
        return SujetoDTO.builder().idSujeto(sujeto.getId()).tipoSujeto(sujeto.getTipoSujeto())
                .municipio(MunicipioDTO.builder().id(mun.getId()).nombre(mun.getNombre()).build()).nombre(sujeto.getNombre())
                .apellido(sujeto.getApellido()).telefono(sujeto.getTelefono()).direccion(sujeto.getDireccion())
                .numeroDoc(sujeto.getNumeroDocumento()).nit(sujeto.getNit()).build();
    }

    @Override
    public Sujeto toSujeto(SujetoDTO sujeto, int idMunicipio) {
        Sujeto sujeto1 = Sujeto.builder().nombre(sujeto.getNombre()).telefono(sujeto.getTelefono())
                .tipoSujeto(sujeto.getTipoSujeto()).municipio(Municipio.builder().id(idMunicipio).build())
                .direccion(sujeto.getDireccion()).build();
        switch (sujeto.getTipoSujeto()){
            case PER -> {
                sujeto1.setApellido(sujeto.getApellido());
                sujeto1.setNumeroDocumento(sujeto.getNumeroDoc());
                sujeto1.setNit(null);
            }
            case EMP -> {
                sujeto1.setNit(sujeto.getNit());
                sujeto1.setApellido(null);
                sujeto1.setNumeroDocumento(null);
            }
        }
        return sujeto1;
    }

    @Override
    public ProductoCompra toProductoCompra(ProductoCompraDTO prod, int compraId) {
        LocalDate fechaVencimiento = prod.getAnioVencimiento() != -1 && prod.getMesVencimiento() != -1 &&
                prod.getDiaVencimiento() != -1? LocalDate.of(prod.getAnioVencimiento(),prod.getMesVencimiento(),
                prod.getDiaVencimiento()) : null;
        Producto producto = Producto.builder().codigo(prod.getCodigo()).build();
        Compra compra = Compra.builder().id(compraId).build();
        ProductoCompraPK primaryKey = ProductoCompraPK.builder().compra(compra).producto(producto).build();
        return ProductoCompra.builder().primaryKey(primaryKey)
                .precioProducto(prod.getPrecio()).cantidadProducto(prod.getCantidad())
                .fechaVencimientoProducto(fechaVencimiento).build();
    }

    @Override
    public ProductoVenta toProductoVenta(ProductoVentaDTO prod, int ventaId) {
        Venta venta = Venta.builder().id(ventaId).build();
        Producto producto = Producto.builder().codigo(prod.getCodigo()).build();
        ProductoVentaPK primaryKey = ProductoVentaPK.builder().venta(venta).producto(producto).build();
        return ProductoVenta.builder().primaryKey(primaryKey).precioProducto(prod.getPrecio())
                .cantidadProducto(prod.getCantidad()).build();
    }

    @Override
    public ProductoCompraDTO toProductoCompraDTO(Producto producto, ProductoCompra productoCompra) {
        Producto producto1 = productoRepository.findById(producto.getCodigo()).orElse(new Producto());
        CategoriaProducto categoriaProducto = categoriaProductoRepository.findById(producto1.getCategoria()
                        .getId()).orElse(new CategoriaProducto());
        LocalDate fechaVencimiento = productoCompra.getFechaVencimientoProducto() == null ? null :
                productoCompra.getFechaVencimientoProducto();
        return ProductoCompraDTO.builder().codigo(producto1.getCodigo())
                .nombre(producto1.getNombre()).categoria(categoriaProducto.getNombre())
                .descripcion(producto1.getDescripcion()).cantidad(productoCompra.getCantidadProducto())
                .precio(productoCompra.getPrecioProducto()).anioVencimiento(fechaVencimiento != null?
                        fechaVencimiento.getYear() : -1)
                .mesVencimiento(fechaVencimiento != null? fechaVencimiento.getMonthValue() : -1)
                .diaVencimiento(fechaVencimiento != null? fechaVencimiento.getDayOfMonth() : -1).build();
    }

    @Override
    public ProductoVentaDTO toProductoVentaDTO(Producto producto, ProductoVenta productoVenta) {
        Producto producto1 = productoRepository.findById(producto.getCodigo()).orElse(new Producto());
        CategoriaProducto categoriaProducto = categoriaProductoRepository.findById(producto1.getCategoria()
                .getId()).orElse(new CategoriaProducto());
        return ProductoVentaDTO.builder().codigo(producto1.getCodigo()).nombre(producto1.getNombre())
                .categoria(categoriaProducto.getNombre()).descripcion(producto1.getDescripcion())
                .cantidad(productoVenta.getCantidadProducto()).precio(productoVenta.getPrecioProducto())
                .build();
    }

    public LoteDTO toLoteDTO(Lote lote){
        return LoteDTO.builder().id(lote.getId()).fecha(lote.getFechaLote()).build();
    }

    @Override
    public MunicipioDTO toMunicipioDTO(Municipio municipio) {
        return MunicipioDTO.builder().id(municipio.getId()).nombre(municipio.getNombre()).build();
    }

    @Override
    public ProductoVentaDTO toProductoVentaDTO(Stock stock) {
        return ProductoVentaDTO.builder().codigo(stock.getCodigo()).precio(stock.getPrecioProducto())
                .cantidad(stock.getCantidadProducto()).build();
    }
}
