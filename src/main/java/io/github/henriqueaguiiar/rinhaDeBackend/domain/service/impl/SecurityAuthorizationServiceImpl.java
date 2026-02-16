package io.github.henriqueaguiiar.rinhaDeBackend.domain.service.impl;

import io.github.henriqueaguiiar.rinhaDeBackend.domain.repository.UserRepository;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.service.SecurityAuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor


/**
 * Implementação do serviço de autorização de segurança, responsável por carregar os detalhes do usuário para autenticação.
 * Esta classe implementa a interface UserDetailsService do Spring Security, permitindo que o framework
 * de autenticação do Spring Security utilize esta implementação para carregar os detalhes do usuário durante o processo de autenticação
 */
public class SecurityAuthorizationServiceImpl implements UserDetailsService, SecurityAuthorizationService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}

