package com.platzi.day.web.controller;

import com.platzi.day.domain.dto.MovieDto;
import com.platzi.day.domain.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // Endpoint para obtener todas las peliculas
    @GetMapping("/movies")// Indica que responde a peticiones GET en la ruta /movies
    public List<MovieDto> getAllMovies() {
        return this.movieService.getAllMovies();
    }
}
