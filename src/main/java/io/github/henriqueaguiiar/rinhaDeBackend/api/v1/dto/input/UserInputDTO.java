package io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.input;

import io.github.henriqueaguiiar.rinhaDeBackend.domain.util.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserInputDTO {
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
