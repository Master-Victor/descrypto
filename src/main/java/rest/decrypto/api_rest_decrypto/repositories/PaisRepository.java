package rest.decrypto.api_rest_decrypto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.decrypto.api_rest_decrypto.models.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {
}
