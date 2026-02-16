package io.github.henriqueaguiiar.rinhaDeBackend.domain.repository;

import io.github.henriqueaguiiar.rinhaDeBackend.domain.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {

    UserDetails findByUsername(String username);

}
