package io.github.henriqueaguiiar.rinhaDeBackend.domain.service.validation;


import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.request.PersonInputDTO;
import org.springframework.stereotype.Service;

@Service
public interface ValidateInputPersonStrategy {

    void validateInputPerson(PersonInputDTO personInputDTO);
}
