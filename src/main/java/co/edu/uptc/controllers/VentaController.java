package co.edu.uptc.controllers;

import co.edu.uptc.dtos.ProductoVentaDTO;
import co.edu.uptc.dtos.VentaDTO;
import co.edu.uptc.services.VentaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/venta")
@CrossOrigin(origins = {"http://localhost:4200/"})
public class VentaController {
    @Autowired
    private VentaService ventaService;

    @GetMapping("/productos/stock")
    public ResponseEntity<List<ProductoVentaDTO>> getStock(){
        return ResponseEntity.ok(ventaService.getStock());
    }

    //request: api/v1/venta?idCliente={idCliente}&idEmpleado={idEmpleado}
    @PostMapping()
    public ResponseEntity<VentaDTO> saveCompra(@Valid @RequestBody VentaDTO venta, @RequestParam(value = "idCliente") int idCliente,
                                                   @RequestParam(value = "idEmpleado") int idEmpleado){
        return ventaService.save(venta,idCliente,idEmpleado).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
