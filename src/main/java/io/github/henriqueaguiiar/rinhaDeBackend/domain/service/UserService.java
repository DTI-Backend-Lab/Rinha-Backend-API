package io.github.henriqueaguiiar.rinhaDeBackend.domain.service;

import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.request.UserInputDTO;
import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.response.UserOutputDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

   UserOutputDTO createUser (UserInputDTO userInputDTO);

   UserDetails getUserByLogin(String login);


}
