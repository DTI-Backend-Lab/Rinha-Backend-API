package io.github.henriqueaguiiar.rinhaDeBackend.domain.service.validation;


import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.input.PersonInputDTO;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.exception.CreatePersonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StackValidationStrategy implements ValidateInputPersonStrategy {

    @Override
    public void validateInputPerson(PersonInputDTO personInputDTO) {
        if (personInputDTO.getStack() != null) {
            for (String stackItem : personInputDTO.getStack()) {
                if (stackItem == null || stackItem.length() > 32) {
                    log.error("Limite máximo de até 32 caracteres por item na Stack {}", stackItem);
                    throw new CreatePersonException("Limite máximo de até 32 caracteres por item na Stack");
                }
            }
        }
    }
}
