package io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.output;


import io.github.henriqueaguiiar.rinhaDeBackend.domain.util.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserOutputDTO {

    private String username;
    private String hashedPassword;
    private String role;
    private Instant createdAt;

}
