package io.github.henriqueaguiiar.rinhaDeBackend.domain.service.validation;


import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.request.PersonInputDTO;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.exception.CreatePersonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SurNameValidationStrategy implements ValidateInputPersonStrategy {

    @Override
    public void validateInputPerson(PersonInputDTO personInputDTO) {

        if (personInputDTO.getSurName() == null || personInputDTO.getSurName().isBlank()) {
            log.error("O campos sobrenome está vazio ou nulo {}", personInputDTO.getSurName());
            throw new CreatePersonException("O preenchimento do sobrenome é Obrigatorio");
        }
        if (personInputDTO.getSurName().length() > 32) {
            log.error("O limite máximo do sobrenome é 32 caracteres {}", personInputDTO.getSurName().length());
            throw new CreatePersonException("O limite máximo do sobrenome é 32 caracteres");
        }

    }
}
