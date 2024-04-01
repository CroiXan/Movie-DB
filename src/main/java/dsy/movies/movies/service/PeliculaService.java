package dsy.movies.movies.service;

import java.util.List;
import java.util.Optional;

import dsy.movies.movies.model.Pelicula;

public interface PeliculaService {
    List<Pelicula> getAllPeliculas();
    Optional<Pelicula> getPeliculaById(Long id);
}
