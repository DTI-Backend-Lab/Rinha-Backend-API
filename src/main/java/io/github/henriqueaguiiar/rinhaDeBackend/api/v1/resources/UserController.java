package io.github.henriqueaguiiar.rinhaDeBackend.api.v1.resources;

import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.input.UserInputDTO;
import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.output.UserOutputDTO;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserOutputDTO> createUser(@RequestBody @Valid UserInputDTO userInputDTO){
        UserOutputDTO userOutputDTO = userService.createUser(userInputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userOutputDTO);
    }
}
