package dsy.movies.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dsy.movies.movies.model.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula,Long>{

}
