package io.github.henriqueaguiiar.rinhaDeBackend.domain.exception;

/**
 * Classe de Exception para Criação de Recurso do tipo Person
 *  @author Henrique Pacheco
 */

public class CreatePersonException extends RuntimeException{
    private static final long serialVersionUUID = 1L;



    public CreatePersonException(String message) {
        super(message);
    }
}
