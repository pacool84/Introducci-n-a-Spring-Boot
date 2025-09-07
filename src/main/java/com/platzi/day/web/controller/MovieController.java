package com.platzi.day.web.controller;

import com.platzi.day.domain.dto.MovieDto;
import com.platzi.day.domain.dto.SuggestRequestDto;
import com.platzi.day.domain.dto.UpdateMovieDto;
import com.platzi.day.domain.service.MovieService;
import com.platzi.day.domain.service.PlatziPlayAIService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies") // Ruta base para todos los endpoints en este controlador
public class MovieController {
    private final MovieService movieService;
    private final PlatziPlayAIService aiService;

    public MovieController(MovieService movieService, PlatziPlayAIService aiService) {
        this.movieService = movieService;
        this.aiService = aiService;
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

    // Endpoint para generar una sugerencia de pelicula
    @PostMapping("/suggest") // Indica que responde a peticiones POST en la ruta /movies/suggestion
    public ResponseEntity<String> generateMovieSuggestion(@RequestBody SuggestRequestDto suggestRequestDto) {
        return ResponseEntity.ok(this.aiService.generateMovieSuggestion(suggestRequestDto.userPreferences()));
    }

    // Endpoint para agregar una nueva pelicula
    @PostMapping // Indica que responde a peticiones POST en la ruta /movies
    public ResponseEntity<MovieDto> add(@RequestBody MovieDto movieDto) {
        MovieDto movieDtoResponse = this.movieService.add(movieDto); // Llama al servicio para agregar la pelicula
        return ResponseEntity.status(HttpStatus.CREATED).body(movieDtoResponse); // Devuelve 201 Created con la pelicula creada
    }

    // Endpoint para actualizar una pelicula existente
    @PutMapping("/{id}") // Indica que responde a peticiones PUT en la ruta /movies/{id}
    public ResponseEntity<MovieDto> update(@PathVariable long id, @RequestBody @Valid UpdateMovieDto updateMovieDto) {
        return ResponseEntity.ok(this.movieService.update(id, updateMovieDto)); // Devuelve 200 OK con la pelicula actualizada
    }

    // Endpoint para eliminar una pelicula
    @DeleteMapping("/{id}") // Indica que responde a peticiones DELETE en la ruta /movies/{id}
    public ResponseEntity<Void> delete(@PathVariable long id) {
        this.movieService.delete(id);
        return ResponseEntity.ok().build();
    }

}
