package io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.input;


import io.github.henriqueaguiiar.rinhaDeBackend.domain.model.Stack;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author Henrique Pacheco
 * Input DTO to Person Entity
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "PersonInputDTO",description = "Dados necessarios para criar ou atualizar uma pessoa.")
public class PersonInputDTO {

    @Schema(example = "Aguiar", description = "Sobrenome da pessoa.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    private String surName;
    @Schema(example = "Henrique", description = "Nome da pessoa.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank
    private String name;
    @Schema(example = "1995-08-15", description = "Data de nascimento da pessoa.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull
    private String bornDate;
    @Schema(example = "[\"Java\",\"Spring Boot\",\"Docker\"]", description = "Lista de tecnologias que a pessoa domina.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Set<Stack> stack;

    @Override
    public String toString() {
        return "PersonInputDTO{" +
                "surName='" + surName + '\'' +
                ", name='" + name + '\'' +
                ", bornDate='" + bornDate + '\'' +
                ", stack=" + stack +
                '}';
    }
}
