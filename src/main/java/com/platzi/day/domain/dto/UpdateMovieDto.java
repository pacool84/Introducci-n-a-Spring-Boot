package com.platzi.day.domain.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

//Este RECORD nos permitira desaclopar nuestra capa de persistencia/ base de datos de nuestra capa WEB
public record UpdateMovieDto(
        @NotBlank(message = "El titulo es obligatorio ") // Validacion para que el titulo no sea nulo o vacio
        String title,

        @PastOrPresent(message = "La fecha de lanzamiento no puede ser en el futuro") // Validacion para que la fecha no sea futura
        LocalDate releaseDate,

        @Min(value = 0, message = "El rating no puede ser menor a 0") // Validacion para que el rating sea mayor o igual a 0
        @Max(value = 5, message = "Ek rating no puede ser mayor a 10") // Validacion para que el rating sea menor o igual a 10
        Double rating
) {
}
