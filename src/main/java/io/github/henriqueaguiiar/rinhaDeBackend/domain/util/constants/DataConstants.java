package io.github.henriqueaguiiar.rinhaDeBackend.domain.util.constants;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class DataConstants {
    public static Instant DATA_EXPIRACAO_TOKEN_JWT = DataConstants.generateExpirationDate();

    /**
     * Metodo que gera a data de expiração do token JWT, nesse caso o token expira em 2 horas
     * @return
     */
    private static Instant generateExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
