package io.github.henriqueaguiiar.rinhaDeBackend.domain.service;

import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.input.UserInputDTO;
import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.output.UserOutputDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

   UserOutputDTO createUser (UserInputDTO userInputDTO);

   UserOutputDTO getUserByLogin(String login);


}
