package io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.input;


import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Henrique Pacheco
 * Input DTO to Person Entity
 */

public class PersonInputDTO {

    private String surName;
    private String name;
    private LocalDate bornDate;
    private List<String> stack;

}
