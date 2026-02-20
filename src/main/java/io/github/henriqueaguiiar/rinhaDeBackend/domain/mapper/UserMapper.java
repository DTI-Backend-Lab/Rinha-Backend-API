package io.github.henriqueaguiiar.rinhaDeBackend.domain.mapper;



import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.request.UserInputDTO;
import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.response.UserOutputDTO;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.model.Users;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserOutputDTO toOutputDTO (Users users) {
        UserOutputDTO userOutputDTO = new UserOutputDTO();
        userOutputDTO.setUsername(users.getUsername());
        userOutputDTO.setHashedPassword(users.getPassword());
        userOutputDTO.setRole(users.getRole().getRole());
        userOutputDTO.setCreatedAt(users.getCreatedAt());
        return userOutputDTO;
    }

    public Users toEntity(UserInputDTO userInputDTO) {
        Users users = new Users();
        users.setUsername(userInputDTO.getUsername());
        users.setPassword(userInputDTO.getPassword());
        users.setRole(userInputDTO.getRole());
        return users;
    }




}
