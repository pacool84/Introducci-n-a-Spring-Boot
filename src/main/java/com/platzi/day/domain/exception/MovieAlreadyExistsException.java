package com.platzi.day.domain.exception;

public class MovieAlreadyExistsException extends RuntimeException{
    public MovieAlreadyExistsException(String movieTitle) {
        super("La pelicula " + movieTitle + " ya existe en la base de datos.");
    }
}
