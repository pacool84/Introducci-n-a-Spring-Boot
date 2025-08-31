package com.platzi.day.domain.service;

import com.platzi.day.domain.dto.MovieDto;
import com.platzi.day.domain.dto.UpdateMovieDto;
import com.platzi.day.domain.repository.MovieRepository;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository; //

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    //Metodo para recuperar una lista de peliculas DTO
    @Tool("Busca todas las peliculas dentro de la plataforma")
    public List<MovieDto> getAllMovies(){
        return this.movieRepository.getAllMovies();
    }

    //Metodo para recuperar una pelicula por su ID
    public MovieDto getById(long id) {
        return this.movieRepository.getById(id);
    }

    //Metodo para agregar una nueva pelicula
    public MovieDto add(MovieDto movieDto) {
        return this.movieRepository.save(movieDto);
    }

    //Metodo para actualizar una pelicula existente
    public MovieDto update(long id, UpdateMovieDto updateMovieDto) {
        return this.movieRepository.update(id, updateMovieDto);
    }

    public void delete(long id) {
        this.movieRepository.delete(id);
    }
}
