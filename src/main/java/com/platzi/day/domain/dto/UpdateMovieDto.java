package com.platzi.day.domain.dto;

import java.time.LocalDate;

//Este RECORD nos permitira desaclopar nuestra capa de persistencia/ base de datos de nuestra capa WEB
public record UpdateMovieDto(
        String title,
        LocalDate releaseDate,
        Double rating
) {
}
