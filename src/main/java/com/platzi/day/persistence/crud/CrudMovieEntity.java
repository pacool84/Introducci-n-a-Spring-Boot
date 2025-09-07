package com.platzi.day.persistence.crud;

import com.platzi.day.persistence.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

// This interface extends CrudRepository to provide CRUD operations for MovieEntity
public interface CrudMovieEntity extends CrudRepository<MovieEntity, Long> {
    MovieEntity findFirstByTitulo(String titulo);
}

