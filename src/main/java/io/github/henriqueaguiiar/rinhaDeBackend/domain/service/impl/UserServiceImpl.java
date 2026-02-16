package io.github.henriqueaguiiar.rinhaDeBackend.domain.service.impl;

import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.input.UserInputDTO;
import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.output.UserOutputDTO;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.mapper.UserMapper;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.model.Users;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.repository.UserRepository;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
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
            Users users = userMapper.toEntity(userInputDTO);
            users.setPassword(passwordEncoder.encode(users.getPassword()));
            userRepository.save(users);
            return userMapper.toOutputDTO(users);
    }

    @Override
    public UserDetails getUserByLogin(String username) {
        var users = userRepository.findByUsername(username);
        return users;
    }
}
