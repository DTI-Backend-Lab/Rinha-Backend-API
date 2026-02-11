package io.github.henriqueaguiiar.rinhaDeBackend.domain.service.validation;


import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.input.PersonInputDTO;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.exception.CreatePersonException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class NameValidationStrategy implements ValidateInputPersonStrategy {

    @Override
    public void validateInputPerson(PersonInputDTO personInputDTO) {

        if(personInputDTO.getName() == null || personInputDTO.getName().isBlank()){
            log.error("O campos nome está vazio ou nulo {}", personInputDTO.getName());
            throw new CreatePersonException("O preenchimento do nome é Obrigatorio");
        }


        if (personInputDTO.getName().length() > 100) {
            log.error("O limite máximo do nome é 100 caracteres {}", personInputDTO.getName().length());
            throw new CreatePersonException("O limite máximo do nome é 100 caracteres");
        }

    }
}
