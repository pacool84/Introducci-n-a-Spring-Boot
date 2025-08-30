package com.platzi.day.web.controller;

import com.platzi.day.domain.dto.MovieDto;
import com.platzi.day.domain.dto.UpdateMovieDto;
import com.platzi.day.domain.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        return ResponseEntity.ok(this.movieService.getAllMovies()); // Devuelve 200 OK con la lista de peliculas
    }

    // Endpoint para obtener una pelicula por su ID
    @GetMapping("/{id}") // Indica que responde a peticiones GET en la ruta /movies/{id}
    public ResponseEntity<MovieDto> getById(@PathVariable long id) {
        MovieDto movieDto = this.movieService.getById(id);

        if (movieDto != null) {
            return ResponseEntity.ok(movieDto); // Devuelve 200 OK con la pelicula encontrada
        } else {
            return ResponseEntity.notFound().build(); // Devuelve 404 Not Found si no se encuentra
        }
    }

    // Endpoint para agregar una nueva pelicula
    @PostMapping // Indica que responde a peticiones POST en la ruta /movies
    public ResponseEntity<MovieDto> add(@RequestBody MovieDto movieDto) {
        MovieDto movieDtoResponse = this.movieService.add(movieDto); // Llama al servicio para agregar la pelicula
        return ResponseEntity.status(HttpStatus.CREATED).body(movieDtoResponse); // Devuelve 201 Created con la pelicula creada
    }

    // Endpoint para actualizar una pelicula existente
    @PutMapping("/{id}") // Indica que responde a peticiones PUT en la ruta /movies/{id}
    public ResponseEntity<MovieDto> update(@PathVariable long id, @RequestBody UpdateMovieDto updateMovieDto) {
        return ResponseEntity.ok(this.movieService.update(id, updateMovieDto)); // Devuelve 200 OK con la pelicula actualizada
    }

}
