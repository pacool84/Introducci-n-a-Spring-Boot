package com.platzi.day.web.exception;

import com.platzi.day.domain.exception.MovieAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice // Indica que esta clase manejará excepciones para controladores REST
public class RestExceptionHandler {

    @ExceptionHandler(MovieAlreadyExistsException.class) // Maneja excepciones de tipo MovieAlreadyExistsException
    public ResponseEntity<Error> handleException(MovieAlreadyExistsException ex) {
        Error error = new Error("movie-already-exists", ex.getMessage()); // Crea un objeto Error con el tipo y mensaje de la excepción
        return ResponseEntity.badRequest().body(error); // Devuelve una respuesta 400 Bad Request
    }

    @ExceptionHandler(MethodArgumentNotValidException.class) // Maneja excepciones de validación de argumentos
    public ResponseEntity<List<Error>> handleException(MethodArgumentNotValidException ex) {
        List<Error> errors = new ArrayList<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
          errors.add(new Error(error.getField(), error.getDefaultMessage()));

        });
        return ResponseEntity.badRequest().body(errors); // Devuelve una respuesta 400 Bad Request con la lista de errores

    }

    @ExceptionHandler(Exception.class) // Maneja cualquier otra excepción no manejada específicamente
    public ResponseEntity<Error> handleException(Exception ex) {
        Error error = new Error("unKnown-error", ex.getMessage());
        return ResponseEntity.internalServerError().body(error); // Devuelve una respuesta 500 Internal Server Error
    }
}
