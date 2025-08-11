package com.platzi.day.domain.repository;

import com.platzi.day.domain.dto.MovieDto;

import java.util.List;

//Quien quiera consultarme tendra acceso a consultar todas las peliculas
public interface MovieRepository {
    List<MovieDto> getAllMovies();
}
