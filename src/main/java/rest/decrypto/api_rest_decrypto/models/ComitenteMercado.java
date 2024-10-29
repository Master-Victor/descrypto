package rest.decrypto.api_rest_decrypto.models;

import jakarta.persistence.*;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Data
@Schema(description = "Entidad intermedia que representa la relación entre Comitente y Mercado.")
public class ComitenteMercado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único de la relación", example = "1", required = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "comitente_id", nullable = false)
    @Schema(description = "El comitente asociado a esta relación")
    private Comitente comitente;

    @ManyToOne
    @JoinColumn(name = "mercado_id", nullable = false)
    @Schema(description = "El mercado asociado a esta relación")
    private Mercado mercado;
}
