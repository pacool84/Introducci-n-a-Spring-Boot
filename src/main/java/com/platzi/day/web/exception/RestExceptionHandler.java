package com.platzi.day.web.exception;

import com.platzi.day.domain.exception.MovieAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // Indica que esta clase manejará excepciones para controladores REST
public class RestExceptionHandler {

    @ExceptionHandler(MovieAlreadyExistsException.class) // Maneja excepciones de tipo MovieAlreadyExistsException
    public ResponseEntity<Error> handleException(MovieAlreadyExistsException ex) {
        Error error = new Error("movie-already-exists", ex.getMessage()); // Crea un objeto Error con el tipo y mensaje de la excepción
        return ResponseEntity.badRequest().body(error); // Devuelve una respuesta 400 Bad Request
    }
}
