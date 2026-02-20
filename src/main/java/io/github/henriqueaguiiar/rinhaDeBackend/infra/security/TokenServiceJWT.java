package io.github.henriqueaguiiar.rinhaDeBackend.infra.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.util.constants.DataConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceJWT {
    @Value("${api.security.jwt.secret}")
    private String secret;

    /**
     * Metodo Que Gera o Token JWT para o usuario logado
     * @param userDetails detalhes do usuário autenticado
     * @return String token JWT
     */
    public String getToken(UserDetails userDetails) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("rinhaDeBackend")
                    .withSubject(userDetails.getUsername())
                    .withExpiresAt(DataConstants.DATA_EXPIRACAO_TOKEN_JWT)
                    .sign(algorithm);
        }catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token JWT", exception);
        }
    }

    /**
     * Metodo que valida o token JWT, caso o token seja valido ele retorna o username do usuario logado, caso o token seja invalido ele retorna uma string vazia
     * @param tokenJWT
     * @return
     */
    public String validateToken(String tokenJWT){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("rinhaDeBackend")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        }catch (JWTVerificationException exception){
            return "";
        }
    }



}
