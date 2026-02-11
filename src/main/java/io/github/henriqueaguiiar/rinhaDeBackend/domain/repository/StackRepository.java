package io.github.henriqueaguiiar.rinhaDeBackend.domain.repository;

import io.github.henriqueaguiiar.rinhaDeBackend.domain.model.Stack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StackRepository extends JpaRepository<Stack, UUID> {

    Optional<Stack> findByNameIgnoreCase(String name);

}
