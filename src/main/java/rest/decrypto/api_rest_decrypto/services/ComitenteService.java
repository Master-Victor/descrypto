package rest.decrypto.api_rest_decrypto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.decrypto.api_rest_decrypto.models.Comitente;
import rest.decrypto.api_rest_decrypto.repositories.ComitenteRepository;

import java.util.List;

@Service
public class ComitenteService {

    @Autowired
    private ComitenteRepository comitenteRepository;

    public List<Comitente> getAllComitentes() {
        return comitenteRepository.findAll();
    }

    public Comitente getComitenteById(Long id) {
        return comitenteRepository.findById(id).orElseThrow(() -> new RuntimeException("Comitente no encontrado"));
    }

    public Comitente createComitente(Comitente comitente) {
        return comitenteRepository.save(comitente);
    }

    public Comitente updateComitente(Long id, Comitente comitente) {
        comitente.setId(id);
        return comitenteRepository.save(comitente);
    }

    public void deleteComitente(Long id) {
        comitenteRepository.deleteById(id);
    }
}
