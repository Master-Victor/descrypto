package rest.decrypto.api_rest_decrypto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> getPaisById(@PathVariable Long id) {
        try {
            Pais pais = paisService.getPaisById(id);
            return ResponseEntity.ok(pais);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener el pais: " + e.getMessage());
        }

    }

    @PostMapping
    public ResponseEntity<?> createPais(@RequestBody Pais pais) {
        try {
            Pais newPais = paisService.createPais(pais);
            return ResponseEntity.ok(newPais);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear el pais: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePais(@PathVariable Long id, @RequestBody Pais pais) {
        try {
            Pais updatedPais = paisService.updatePais(id, pais);
            return ResponseEntity.ok(updatedPais);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar el pais: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePais(@PathVariable Long id) {
        try {
            paisService.deletePais(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar el pais: " + e.getMessage());
        }
    }
}
