    package io.github.henriqueaguiiar.rinhaDeBackend.domain.service.validation;

    import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.input.PersonInputDTO;
    import io.github.henriqueaguiiar.rinhaDeBackend.domain.exception.CreatePersonException;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.stereotype.Component;

    import java.time.Instant;
    import java.time.LocalDate;
    import java.time.format.DateTimeFormatter;
    import java.time.format.DateTimeParseException;

    @Component
    @Slf4j
    public class BirthDateValidationStrategy implements ValidateInputPersonStrategy {
        private static final DateTimeFormatter BIRTHDATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");


        @Override
        public void validateInputPerson(PersonInputDTO personInputDTO) {

            if(personInputDTO.getBornDate() == null || personInputDTO.getBornDate().isBlank()){
                log.error("A data de nascimento é obrigatória {}", personInputDTO.getBornDate());
                throw new CreatePersonException("A data de nascimento é obrigatória");
            }

            LocalDate bornDate;

            try {
                bornDate = LocalDate.parse(personInputDTO.getBornDate(), BIRTHDATE_FORMATTER);
            } catch (DateTimeParseException e) {
                log.error("A data de nascimento deve estar no formato AAAA-MM-DD {}", personInputDTO.getBornDate());
                throw new CreatePersonException("A data de nascimento deve estar no formato AAAA-MM-DD");
            }

            if (bornDate.isAfter(LocalDate.now())) {
                log.error("A data de nascimento não pode ser no futuro: {}", personInputDTO.getBornDate());
                throw new CreatePersonException("A data de nascimento não pode ser no futuro");
            }
        }
    }

