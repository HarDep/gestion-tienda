package co.edu.uptc.controllers;

import co.edu.uptc.dtos.SujetoDTO;
import co.edu.uptc.services.SujetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/sujeto")
public class SujetoController {
    @Autowired
    private SujetoService sujetoService;

    @GetMapping("/clientes")
    public ResponseEntity<List<SujetoDTO>> getClients(){
        return ResponseEntity.ok(sujetoService.getAll());
    }

    @GetMapping("/empleados")
    public ResponseEntity<List<SujetoDTO>> getSellers(){
        return ResponseEntity.ok(sujetoService.getSellers());
    }

    @GetMapping("/proveedores")
    public ResponseEntity<List<SujetoDTO>> getSuppliers(){
        return ResponseEntity.ok(sujetoService.getSuppliers());
    }
}
