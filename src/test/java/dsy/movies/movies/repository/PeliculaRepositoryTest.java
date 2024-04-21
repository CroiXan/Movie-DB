package dsy.movies.movies.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import dsy.movies.movies.model.Pelicula;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PeliculaRepositoryTest {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Test
    public void savePeliculaTest(){

        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo("Pulp Fiction");
        pelicula.setDirector("Quentin Tarantino");
        pelicula.setGenero("Crime");
        pelicula.setSinopsis("The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.");
        pelicula.setYear(1994);

        Pelicula savedPelicula = peliculaRepository.save(pelicula);

        assertNotNull(savedPelicula.getId());

        assertEquals("Pulp Fiction", savedPelicula.getTitulo());
        assertEquals("Quentin Tarantino", savedPelicula.getDirector());
        assertEquals("Crime", savedPelicula.getGenero());
        assertEquals("The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.", savedPelicula.getSinopsis());
        assertEquals(1994, savedPelicula.getYear());
    }

}
