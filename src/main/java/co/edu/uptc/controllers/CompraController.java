package co.edu.uptc.controllers;

import co.edu.uptc.dtos.CompraDTO;
import co.edu.uptc.dtos.LoteDTO;
import co.edu.uptc.dtos.ProductoProveedorDTO;
import co.edu.uptc.services.CompraService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/compra")
public class CompraController {
    @Autowired
    private CompraService compraService;

    @GetMapping("/lotes")
    public ResponseEntity<List<LoteDTO>> getLotes(){
        return ResponseEntity.ok(compraService.getAllLotes());
    }

    @GetMapping("/proveedor/{id}/productos")
    public ResponseEntity<List<ProductoProveedorDTO>> getProductosProveedor(@PathVariable Integer id){
        List<ProductoProveedorDTO> productos = compraService.getSupplierProducts(id);
        return productos.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(productos);
    }

    //request -> api/v1/compra?idLote={idLote}&idProveedor={idProveedor}
    @PostMapping()
    public ResponseEntity<CompraDTO> saveCompra(@Valid @RequestBody CompraDTO compra, @RequestParam(value = "idLote") int idLote,
                                                @RequestParam(value = "idProveedor") int idProveedor){
        return compraService.save(compra,idLote,idProveedor).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
