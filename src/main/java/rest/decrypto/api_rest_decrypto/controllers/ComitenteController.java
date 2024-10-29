package rest.decrypto.api_rest_decrypto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Comitente> getComitenteById(@PathVariable Long id) {
        Comitente comitente = comitenteService.getComitenteById(id);
        return ResponseEntity.ok(comitente);
    }

    @PostMapping
    public ResponseEntity<Comitente> createComitente(@RequestBody Comitente comitente) {
        Comitente newComitente = comitenteService.createComitente(comitente);
        return ResponseEntity.ok(newComitente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comitente> updateComitente(@PathVariable Long id, @RequestBody Comitente comitente) {
        Comitente updatedComitente = comitenteService.updateComitente(id, comitente);
        return ResponseEntity.ok(updatedComitente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComitente(@PathVariable Long id) {
        comitenteService.deleteComitente(id);
        return ResponseEntity.noContent().build();
    }
}
