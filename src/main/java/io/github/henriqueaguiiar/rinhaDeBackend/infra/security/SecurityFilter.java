package io.github.henriqueaguiiar.rinhaDeBackend.infra.security;

import io.github.henriqueaguiiar.rinhaDeBackend.domain.model.Users;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenServiceJWT tokenServiceJWT;
    private final UserService userService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var tokenJWT = this.recoverToken(request);
        if(tokenJWT != null){
            var login = tokenServiceJWT.validateToken(tokenJWT);
            Users users = (Users) userService.getUserByLogin(login);
            var authenticacion = new UsernamePasswordAuthenticationToken(users, null, users.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticacion);
        }
        //Chama o proximo filtro da cadeia de fultros caso seja null o token
        filterChain.doFilter(request, response);
    }

    /**
     * Metodo que recupera o token JWT do header da requisição, caso o header "Authorization"
     * seja nulo ele retorna null, caso contrário ele retorna o token JWT sem o prefixo "Bearer "
     * @param request
     * @return
     */

    private String recoverToken(HttpServletRequest request ){
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null){
            return null;
        }
        else{
            return authHeader.replace("Bearer ", "");
        }
    }
}
