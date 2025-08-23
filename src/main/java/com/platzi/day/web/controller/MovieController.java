package com.platzi.day.web.controller;

import com.platzi.day.domain.dto.MovieDto;
import com.platzi.day.domain.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies") // Ruta base para todos los endpoints en este controlador
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // Endpoint para obtener todas las peliculas
    @GetMapping// Indica que responde a peticiones GET en la ruta /movies
    public List<MovieDto> getAllMovies() {
        return this.movieService.getAllMovies();
    }

    // Endpoint para obtener una pelicula por su ID
    @GetMapping("/{id}") // Indica que responde a peticiones GET en la ruta /movies/{id}
    public MovieDto getById(@PathVariable long id) {
        return this.movieService.getById(id);
    }
}
