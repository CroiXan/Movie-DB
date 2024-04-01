package dsy.movies.movies.controller;

import org.springframework.web.bind.annotation.RestController;

import dsy.movies.movies.model.Pelicula;
import dsy.movies.movies.service.PeliculaService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public List<Pelicula> getAllMovies() {
        return peliculaService.getAllPeliculas();
    }

    @GetMapping("/{id}")
    public Optional<Pelicula> getMovieById(@PathVariable Long id) {
        return peliculaService.getPeliculaById(id);
    }
    
    
}
