package io.github.henriqueaguiiar.rinhaDeBackend.domain.service.impl;

import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.input.UserInputDTO;
import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.output.UserOutputDTO;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.mapper.UserMapper;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.model.User;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.repository.UserRepository;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserOutputDTO createUser(UserInputDTO userInputDTO) {
        if(getUserByLogin(userInputDTO.getUsername()) != null){
            throw new RuntimeException("Usuario com este username ja existe");
        }
            User user = userMapper.toEntity(userInputDTO);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return userMapper.toOutputDTO(user);
    }

    @Override
    public UserOutputDTO getUserByLogin(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return null;
        }
        return userMapper.toOutputDTO(user);
    }
}
