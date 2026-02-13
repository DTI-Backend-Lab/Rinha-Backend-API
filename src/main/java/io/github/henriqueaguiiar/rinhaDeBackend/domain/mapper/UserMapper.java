package io.github.henriqueaguiiar.rinhaDeBackend.domain.mapper;



import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.input.UserInputDTO;
import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.output.UserOutputDTO;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserOutputDTO toOutputDTO (User user) {
        UserOutputDTO userOutputDTO = new UserOutputDTO();
        userOutputDTO.setUsername(user.getUsername());
        userOutputDTO.setHashedPassword(user.getPassword());
        userOutputDTO.setRole(user.getRole().getRole());
        userOutputDTO.setCreatedAt(user.getCreatedAt());
        return userOutputDTO;
    }

    public User toEntity(UserInputDTO userInputDTO) {
        User user = new User();
        user.setUsername(userInputDTO.getUsername());
        user.setPassword(userInputDTO.getPassword());
        user.setRole(userInputDTO.getRole());
        return user;
    }

}
