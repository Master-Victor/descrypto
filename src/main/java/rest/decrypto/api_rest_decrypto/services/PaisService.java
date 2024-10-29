package rest.decrypto.api_rest_decrypto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.decrypto.api_rest_decrypto.models.Pais;
import rest.decrypto.api_rest_decrypto.repositories.PaisRepository;

import java.util.List;

@Service
public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    public List<Pais> getAllPaises() {
        return paisRepository.findAll();
    }

    public Pais getPaisById(Long id) {
        return paisRepository.findById(id).orElseThrow(() -> new RuntimeException("Pais no encontrado"));
    }

    public Pais createPais(Pais pais) {
        return paisRepository.save(pais);
    }

    public Pais updatePais(Long id, Pais pais) {
        pais.setId(id);
        return paisRepository.save(pais);
    }

    public void deletePais(Long id) {
        paisRepository.deleteById(id);
    }
}
