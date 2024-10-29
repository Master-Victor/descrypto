package rest.decrypto.api_rest_decrypto.models;

import jakarta.persistence.*;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Set;

@Entity
@Data
@Schema(description = "Entidad que representa un Comitente en el sistema.")
public class Comitente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único del comitente", example = "1", required = true)
    private Long id;

    @Column(unique = true, nullable = false)
    @Schema(description = "Descripción única del comitente", example = "Comitente ABC", required = true)
    private String descripcion;

    @OneToMany(mappedBy = "comitente", cascade = CascadeType.ALL, orphanRemoval = true)
    @Schema(description = "Lista de relaciones del comitente con diferentes mercados")
    private Set<ComitenteMercado> mercados;
}
