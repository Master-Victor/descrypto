package rest.decrypto.api_rest_decrypto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.decrypto.api_rest_decrypto.models.Mercado;
import rest.decrypto.api_rest_decrypto.repositories.MercadoRepository;

import java.util.List;

@Service
public class MercadoService {

    @Autowired
    private MercadoRepository mercadoRepository;

    public List<Mercado> getAllMercados() {
        return mercadoRepository.findAll();
    }

    public Mercado getMercadoById(Long id) {
        return mercadoRepository.findById(id).orElseThrow(() -> new RuntimeException("Mercado no encontrado"));
    }

    public Mercado createMercado(Mercado mercado) {
        return mercadoRepository.save(mercado);
    }

    public Mercado updateMercado(Long id, Mercado mercado) {
        mercado.setId(id);
        return mercadoRepository.save(mercado);
    }

    public void deleteMercado(Long id) {
        mercadoRepository.deleteById(id);
    }
}
