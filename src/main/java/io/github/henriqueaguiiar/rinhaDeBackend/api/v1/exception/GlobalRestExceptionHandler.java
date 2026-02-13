package io.github.henriqueaguiiar.rinhaDeBackend.api.v1.exception;


import io.github.henriqueaguiiar.rinhaDeBackend.api.v1.dto.output.ErrorResponseDTO;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.exception.CreatePersonException;
import io.github.henriqueaguiiar.rinhaDeBackend.domain.exception.PersonNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(CreatePersonException.class)
    public ResponseEntity<ErrorResponseDTO> handleCreatePersonException(CreatePersonException exception, HttpServletRequest request) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                request.getRequestURI() ,
                Instant.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDTO);
    }

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handlePersonNotFoundException(PersonNotFoundException exception, HttpServletRequest request) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(HttpStatus.NOT_FOUND,
                exception.getMessage(),
                request.getRequestURI(),
                Instant.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDTO);
    }

    public ResponseEntity<ErrorResponseDTO> handdleGenericException(Exception exception, HttpServletRequest request) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "An unexpected error occurred",
                request.getRequestURI(),
                Instant.now()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDTO);
    }

    public ResponseEntity<ErrorResponseDTO> handleRuntimeException(RuntimeException exception, HttpServletRequest request) {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "An unexpected error occurred",
                request.getRequestURI(),
                Instant.now()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDTO);
    }

}
