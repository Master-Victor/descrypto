package rest.decrypto.api_rest_decrypto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.decrypto.api_rest_decrypto.models.Comitente;

public interface ComitenteRepository extends JpaRepository<Comitente, Long> {
}
