package rest.decrypto.api_rest_decrypto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.decrypto.api_rest_decrypto.models.Comitente;
import rest.decrypto.api_rest_decrypto.services.ComitenteService;

import java.util.List;

@RestController
@RequestMapping("/api/comitentes")
public class ComitenteController {

    @Autowired
    private ComitenteService comitenteService;

    @GetMapping
    public List<Comitente> getAllComitentes() {
        return comitenteService.getAllComitentes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getComitenteById(@PathVariable Long id) {
        try {
            Comitente comitente = comitenteService.getComitenteById(id);
            return ResponseEntity.ok(comitente);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al obtener el comitente: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createComitente(@RequestBody Comitente comitente) {
        try {
            Comitente newComitente = comitenteService.createComitente(comitente);
            return ResponseEntity.ok(newComitente);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al crear el comitente: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateComitente(@PathVariable Long id, @RequestBody Comitente comitente) {
        try {
            Comitente updatedComitente = comitenteService.updateComitente(id, comitente);
            return ResponseEntity.ok(updatedComitente);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al actualizar el comitente: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComitente(@PathVariable Long id) {
        try {
            comitenteService.deleteComitente(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al eliminar el comitente: " + e.getMessage());
        }
    }
}
