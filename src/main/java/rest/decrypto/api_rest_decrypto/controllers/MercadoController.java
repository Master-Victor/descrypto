package rest.decrypto.api_rest_decrypto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.decrypto.api_rest_decrypto.models.Mercado;
import rest.decrypto.api_rest_decrypto.services.MercadoService;

import java.util.List;

@RestController
@RequestMapping("/api/mercados")
public class MercadoController {

    @Autowired
    private MercadoService mercadoService;

    @GetMapping
    public List<Mercado> getAllMercados() {
        return mercadoService.getAllMercados();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMercadoById(@PathVariable Long id) {
        try {
            Mercado mercado = mercadoService.getMercadoById(id);
            return ResponseEntity.ok(mercado);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener el mercado: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createMercado(@RequestBody Mercado mercado) {
        try {
            Mercado newMercado = mercadoService.createMercado(mercado);
            return ResponseEntity.ok(newMercado);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear el mercado: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMercado(@PathVariable Long id, @RequestBody Mercado mercado) {
        try {
            Mercado updatedMercado = mercadoService.updateMercado(id, mercado);
            return ResponseEntity.ok(updatedMercado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar el mercado: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMercado(@PathVariable Long id) {
        try {
            mercadoService.deleteMercado(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar el mercado: " + e.getMessage());
        }
    }
}
