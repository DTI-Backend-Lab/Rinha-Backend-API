package io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.response;


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
