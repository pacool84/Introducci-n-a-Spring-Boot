package com.platzi.day.persistence;

import com.platzi.day.domain.dto.MovieDto;
import com.platzi.day.domain.repository.MovieRepository;
import com.platzi.day.persistence.crud.CrudMovieEntity;
import com.platzi.day.persistence.entity.MovieEntity;
import com.platzi.day.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieEntityRepository implements MovieRepository {
    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;


    public MovieEntityRepository(CrudMovieEntity crudMovieEntity, MovieMapper movieMapper) {
        this.crudMovieEntity = crudMovieEntity;
        this.movieMapper = movieMapper;
    }

    @Override // Implementación del método para obtener todas las películas
    public List<MovieDto> getAllMovies() {
        return this.movieMapper.toDto(this.crudMovieEntity.findAll());
    }

    @Override
    public MovieDto getById(long id) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);
        return this.movieMapper.toDto(movieEntity);

    }
}
