package co.edu.uptc.controllers;

import co.edu.uptc.dtos.MunicipioDTO;
import co.edu.uptc.dtos.SujetoDTO;
import co.edu.uptc.entities.TipoSujeto;
import co.edu.uptc.exceptions.InvalidResource;
import co.edu.uptc.services.SujetoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sujeto")
@CrossOrigin(origins = {"http://localhost:4200/"})x
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

    @GetMapping("/municipios")
    public ResponseEntity<List<MunicipioDTO>> getMunicipios(){
        return ResponseEntity.ok(sujetoService.getMunicipios());
    }

    //request: api/v1/sujeto?idMunicipio={idMunicipio}&tipo={tipo}
    @PostMapping
    private ResponseEntity<SujetoDTO> saveSujeto(@Valid @RequestBody SujetoDTO sujeto,
                                                 @RequestParam(name = "idMunicipio") int idMunicipio,
                                                 @RequestParam(name = "tipo") int tipo){
        putTipoSujetoAndValidate(sujeto, tipo);
        return sujetoService.save(sujeto,idMunicipio).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //request: api/v1/sujeto?idSujeto={idSujeto}&idMunicipio={idMunicipio}&tipo={tipo}
    @PutMapping
    public ResponseEntity<SujetoDTO> updateSujeto(@Valid @RequestBody SujetoDTO sujeto,
                                                  @RequestParam(name = "idSujeto") int idSujeto,
                                                  @RequestParam(name = "idMunicipio") int idMunicipio,
                                                  @RequestParam(name = "tipo") int tipo){
        putTipoSujetoAndValidate(sujeto, tipo);
        return sujetoService.update(sujeto,idSujeto,idMunicipio).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        sujetoService.delete(id);
        return ResponseEntity.ok("Eliminado correctamente");
    }

    private void putTipoSujetoAndValidate(SujetoDTO sujeto, int tipo){
        TipoSujeto tipoSujeto = tipo == 1 ? TipoSujeto.PER : (tipo == 2 ? TipoSujeto.EMP : null);
        if (tipoSujeto == null)
            throw new InvalidResource("Tipo", "no se estableció un valor valido para saber" +
                    " si el tipo es persona o empresa", null);
        sujeto.setTipoSujeto(tipoSujeto);
    }
}