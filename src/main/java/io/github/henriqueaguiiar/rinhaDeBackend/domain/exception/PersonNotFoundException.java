package io.github.henriqueaguiiar.rinhaDeBackend.domain.exception;

/**
 * Classe de Exception para tratar de buscas de recursos do tipo Person
 *  @author Henrique Pacheco
 */

public class PersonNotFoundException extends RuntimeException{
    private static final long serialVersionUUID = 1L;

    public PersonNotFoundException(String message) {
        super(message);
    }
}
