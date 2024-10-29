package rest.decrypto.api_rest_decrypto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.decrypto.api_rest_decrypto.models.Pais;
import rest.decrypto.api_rest_decrypto.services.PaisService;

import java.util.List;

@RestController
@RequestMapping("/api/paises")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping
    public List<Pais> getAllPaises() {
        return paisService.getAllPaises();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pais> getPaisById(@PathVariable Long id) {
        Pais pais = paisService.getPaisById(id);
        return ResponseEntity.ok(pais);
    }

    @PostMapping
    public ResponseEntity<Pais> createPais(@RequestBody Pais pais) {
        Pais newPais = paisService.createPais(pais);
        return ResponseEntity.ok(newPais);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pais> updatePais(@PathVariable Long id, @RequestBody Pais pais) {
        Pais updatedPais = paisService.updatePais(id, pais);
        return ResponseEntity.ok(updatedPais);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePais(@PathVariable Long id) {
        paisService.deletePais(id);
        return ResponseEntity.noContent().build();
    }
}
