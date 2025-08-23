package com.platzi.day.domain.dto;

import com.platzi.day.domain.Genre;

import java.time.LocalDate;

//Este RECORD nos permitira desaclopar nuestra capa de persistencia/ base de datos de nuestra capa WEB
public record MovieDto(
        Long id,
        String title,
        Integer duration,
        Genre genre, // Enum que representa el genero de la pelicula
        LocalDate releaseDate,
        Double rating
) {
}
