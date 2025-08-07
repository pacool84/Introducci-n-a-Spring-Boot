package com.platzi.day.web.controller;

import com.platzi.day.persistence.crud.CrudMovieEntity;
import com.platzi.day.persistence.entity.MovieEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {


    private final CrudMovieEntity crudMovieEntity;

    public MovieController(CrudMovieEntity crudMovieEntity) {
        this.crudMovieEntity = crudMovieEntity;
    }


    // Endpoint para obtener todas las peliculas
    // Se utiliza el metodo findAll de CrudRepository
    @GetMapping("/movies")
    public List<MovieEntity> getAllMovies() {
        return (List<MovieEntity>) this.crudMovieEntity.findAll();
    }
}
