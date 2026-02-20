package io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "ErrorResponseDTO", description = "Detalhes da resposta de erro retornada pela API.")
public class ErrorResponseDTO {
    @Schema(
            name = "status",
            description = "Código de status HTTP da resposta de erro.",
            example = "404 NOT_FOUND")
    private HttpStatus status;
    @Schema(
            name = "message",
            description = "Mensagem detalhada sobre o erro ocorrido.",
            example = "Recurso não encontrado.")
    private String message;
    @Schema(
            name = "path",
            description = "Caminho da requisição que gerou o erro.",
            example = "/api/v1/pessoas/123")
    private String path;
    @Schema(
            name = "timestamp",
            description = "Carimbo de data/hora indicando quando o erro ocorreu.",
            example = "2024-06-15T13:45:30Z")
    private Instant timestamp;

}
