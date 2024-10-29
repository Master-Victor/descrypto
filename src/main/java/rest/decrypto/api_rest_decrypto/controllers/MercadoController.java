package rest.decrypto.api_rest_decrypto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Mercado> getMercadoById(@PathVariable Long id) {
        Mercado mercado = mercadoService.getMercadoById(id);
        return ResponseEntity.ok(mercado);
    }

    @PostMapping
    public ResponseEntity<Mercado> createMercado(@RequestBody Mercado mercado) {
        Mercado newMercado = mercadoService.createMercado(mercado);
        return ResponseEntity.ok(newMercado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mercado> updateMercado(@PathVariable Long id, @RequestBody Mercado mercado) {
        Mercado updatedMercado = mercadoService.updateMercado(id, mercado);
        return ResponseEntity.ok(updatedMercado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMercado(@PathVariable Long id) {
        mercadoService.deleteMercado(id);
        return ResponseEntity.noContent().build();
    }
}
