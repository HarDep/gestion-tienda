package co.edu.uptc.services;

import co.edu.uptc.dtos.ProductoVentaDTO;
import co.edu.uptc.dtos.SujetoDTO;
import co.edu.uptc.dtos.VentaDTO;
import co.edu.uptc.entities.Producto;
import co.edu.uptc.entities.ProductoVenta;
import co.edu.uptc.entities.Venta;
import co.edu.uptc.exceptions.InvalidResource;
import co.edu.uptc.exceptions.ResourceNotFound;
import co.edu.uptc.repositories.ProductoRepository;
import co.edu.uptc.repositories.ProductoVentaRepository;
import co.edu.uptc.repositories.SujetoRepository;
import co.edu.uptc.repositories.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaServiceImpl implements VentaService{
    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private SujetoRepository sujetoRepository;
    @Autowired
    private SujetoService sujetoService;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ProductoVentaRepository productoVentaRepository;
    @Autowired
    private MapperService mapperService;

    /**
     * Guardar una venta en la base de datos
     * @param venta la venta a guardar, debe tener los productosVentaDTO de la venta
     * @param idCliente id del cliente de la venta
     * @param idEmpleado id del empleado de la venta
     * @return La venta guardada, si retorna Optional empty es porque no existe cliente,
     * o no existe o está atendiendo el empleado, o no existen al menos un producto,
     * o algún producto tiene una cantidad que supera las disponibles de ese mismo
     */
    @Override
    public Optional<VentaDTO> save(VentaDTO venta, int idCliente, int idEmpleado) {
        sujetoRepository.findById(idCliente).orElseThrow(
                () -> new ResourceNotFound("Cliente","id",idCliente + ""));
        List<SujetoDTO> empleados = sujetoService.getSellers();
        if (empleados.stream().allMatch(sujeto -> sujeto.getIdSujeto() != idEmpleado)){
            throw new ResourceNotFound("Empleado", "id", "" + idEmpleado);
        }
        //¿descalificamos la venta de una o solo quitamos los que no existen?
        //Verificar cantidad y precio de productos con el stock
        List<ProductoVentaDTO> stock = getStock();
        venta.getProductos().forEach(prod ->{
            if(!productoRepository.existsById(prod.getCodigo()))
                throw new ResourceNotFound("Producto", "id", prod.getCodigo());
            stock.forEach(stProd ->{
                if(stProd.getCodigo().equals(prod.getCodigo())){
                    if (prod.getCantidad() > stProd.getCantidad())
                        throw new InvalidResource("Producto",
                                "la cantidad del producto es mayor al disponible en stock",
                                prod.getNombre());
                    if (prod.getPrecio() != stProd.getPrecio())
                        throw new InvalidResource("Producto",
                                "el precio del producto no es el mismo que el registrado en stock",
                                prod.getNombre());
                }
            });
        });
        Venta venta1 = mapperService.toVenta(idCliente, idEmpleado);
        Venta guardado = ventaRepository.save(venta1);
        List<ProductoVentaDTO> productos = venta.getProductos().stream()
                .map(prod -> saveProductoVenta(prod, guardado.getId())).toList();
        return Optional.of(mapperService.toVentaDTO(guardado,productos));
    }

    /**
     * Obtener el stock de productos disponibles para la venta
     * @return productos disponibles para la venta
     */
    @Override
    public List<ProductoVentaDTO> getStock() {
        List<ProductoVenta> productos = productoVentaRepository.getStock();
        return productos.stream().map(prod -> {
            Producto producto = prod.getPrimaryKey().getProducto();
            //porcentaje adicional en el precio de venta
            prod.setPrecioProducto(prod.getPrecioProducto() + prod.getPrecioProducto() * 0.15);
            return mapperService.toProductoVentaDTO(producto,prod);
        }).toList();
    }

    private ProductoVentaDTO saveProductoVenta(ProductoVentaDTO prod, int ventaId) {
        ProductoVenta productoVenta = mapperService.toProductoVenta(prod,ventaId);
        ProductoVenta guardado = productoVentaRepository.save(productoVenta);
        Producto producto = guardado.getPrimaryKey().getProducto();
        return mapperService.toProductoVentaDTO(producto,guardado);
    }
}
