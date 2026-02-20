package io.github.henriqueaguiiar.rinhaDeBackend.domain.service.validation;


import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.request.PersonInputDTO;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.exception.CreatePersonException;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.model.Stack;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StackValidationStrategy implements ValidateInputPersonStrategy {

    @Override
    public void validateInputPerson(PersonInputDTO personInputDTO) {
        if (personInputDTO.getStack() != null) {
            for (Stack stackItem : personInputDTO.getStack()) {
                if (stackItem == null || stackItem.getName() == null || stackItem.getName().trim().isEmpty()) {
                    log.error("Nome da Stack não pode ser nulo ou vazio: {}", stackItem);
                    throw new CreatePersonException("Nome da Stack não pode ser nulo ou vazio");
                }
                if (stackItem.getName().length() > 32) {
                    log.error("Limite máximo de até 32 caracteres por item na Stack {}", stackItem);
                    throw new CreatePersonException("Limite máximo de até 32 caracteres por item na Stack");
                }
            }
            for(Stack stackItem : personInputDTO.getStack()) {
                stackItem.getName().toUpperCase();
            }

        }

    }
}
