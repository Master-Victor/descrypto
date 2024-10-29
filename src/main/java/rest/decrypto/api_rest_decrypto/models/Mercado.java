package rest.decrypto.api_rest_decrypto.models;

import jakarta.persistence.*;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Set;

@Entity
@Data
@Schema(description = "Entidad que representa un Mercado en el sistema.")
public class Mercado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único del mercado", example = "1", required = true)
    private Long id;

    @Column(nullable = false)
    @Schema(description = "Código único del mercado", example = "MAE", required = true)
    private String codigo;

    @Column(nullable = false)
    @Schema(description = "Descripción del mercado", example = "Mercado de Acciones", required = true)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false)
    @Schema(description = "País al que pertenece el mercado")
    private Pais pais;

    @OneToMany(mappedBy = "mercado", cascade = CascadeType.ALL, orphanRemoval = true)
    @Schema(description = "Lista de relaciones del mercado con diferentes comitentes")
    private Set<ComitenteMercado> comitentes;
}
