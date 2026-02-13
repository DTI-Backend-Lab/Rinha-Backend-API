package io.github.henriqueaguiiar.rinhaDeBackend.api.v1.auth;

import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.input.AuthInputDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody @Valid AuthInputDTO authInputDTO) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(authInputDTO.username(), authInputDTO.password());
        var auth = authenticationManager.authenticate(usernamePassword);
        return ResponseEntity.ok().body("Login successful for user: " + auth.getName());
    }


}
