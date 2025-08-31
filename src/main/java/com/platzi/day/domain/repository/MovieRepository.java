package com.platzi.day.domain.repository;

import com.platzi.day.domain.dto.MovieDto;
import com.platzi.day.domain.dto.UpdateMovieDto;

import java.util.List;

//Quien quiera consultarme tendra acceso a consultar todas las peliculas
public interface MovieRepository {
    List<MovieDto> getAllMovies();
    MovieDto getById(long id);
    MovieDto save(MovieDto movieDto);
    MovieDto update(long id, UpdateMovieDto updateMovieDto);
    void delete(long id);
}
