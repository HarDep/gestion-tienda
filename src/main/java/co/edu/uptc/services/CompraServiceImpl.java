package co.edu.uptc.services;

import co.edu.uptc.dtos.*;
import co.edu.uptc.entities.*;
import co.edu.uptc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompraServiceImpl implements CompraService {
    @Autowired
    private CompraRepository compraRepository;
    @Autowired
    private ProductoProveedorRepository productoProveedorRepository;
    @Autowired
    private LoteRepository loteRepository;
    @Autowired
    private SujetoRepository sujetoRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ProductoCompraRepository productoCompraRepository;
    @Autowired
    private MapperService mapperService;

    /**
     * Guardar una compra en la base de datos
     * @param compra la compra a guardar, debe tener los productosCompraDTO de la compra
     * @param idLote id del lote de la compra
     * @param idProveedor id del proveedor de la compra
     * @return La compra guardada, si retorna Optional empty es porque no existe lote o proveedor,
     * o no existen al menos un producto
     */
    @Override
    public Optional<CompraDTO> save(CompraDTO compra, int idLote, int idProveedor) {
        if (!loteRepository.existsById(idLote)) {
            return Optional.empty();
        }
        List<Sujeto> proveedores = sujetoRepository.findSuppliers();
        if (proveedores.stream().allMatch(sujeto -> sujeto.getId() != idProveedor)){
            return Optional.empty();
        }
        //¿descalificamos la compra de una o solo quitamos los que no existen?
        if (compra.getProductos().stream().anyMatch(prod -> !productoRepository.existsById(prod.getCodigo()))){
            return Optional.empty();
        }
        Compra compra1 = mapperService.toCompra(idLote, idProveedor);
        Compra guardado = compraRepository.save(compra1);
        List<ProductoCompraDTO> productos = compra.getProductos().stream()
                .map(prod -> saveProductoCompra(prod, guardado.getId())).toList();
        return Optional.of(mapperService.toCompraDTO(guardado, productos));
    }

    /**
     * Obtener los productos de un proveedor
     * @param idProveedor id del proveedor a quien se le buscaran los productos
     * @return productos del proveedor, si retorna lista vacía es porque no existe ese proveedor
     */
    @Override
    public List<ProductoProveedorDTO> getSupplierProducts(int idProveedor) {
        List<Sujeto> proveedores = sujetoRepository.findSuppliers();
        if (proveedores.stream().allMatch(sujeto -> sujeto.getId() != idProveedor)){
            return new ArrayList<>();
        }
        List<ProductoProveedor> productos = productoProveedorRepository.getSupplierProducts(idProveedor);
        return productos.stream().map(prod -> mapperService.toProductoProveedorDTO(prod)).toList();
    }

    //obtener todos los lotes
    @Override
    public List<LoteDTO> getAllLotes() {
        List<Lote> lotes = loteRepository.findAll();
        return lotes.stream().map(lote -> mapperService.toLoteDTO(lote)).toList();
    }

    private ProductoCompraDTO saveProductoCompra(ProductoCompraDTO prod, int compraId){
        ProductoCompra productoCompra = mapperService.toProductoCompra(prod,compraId);
        ProductoCompra guardado = productoCompraRepository.save(productoCompra);
        Producto producto = guardado.getProducto();
        return mapperService.toProductoCompraDTO(producto,guardado);
    }
}
