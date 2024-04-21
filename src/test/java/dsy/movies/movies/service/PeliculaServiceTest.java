package dsy.movies.movies.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dsy.movies.movies.model.Pelicula;
import dsy.movies.movies.repository.PeliculaRepository;

@ExtendWith(MockitoExtension.class)
public class PeliculaServiceTest {

    @InjectMocks
    private PeliculaServiceImpl peliculaService;

    @Mock
    private PeliculaRepository peliculaRepositoryMock;

    @Test
    public void upadatePeliculaTest(){
        
        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo("The Matrix");
        pelicula.setDirector("Wachowski Brothers");
        pelicula.setGenero("Sci-Fi");
        pelicula.setSinopsis("When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence.");
        pelicula.setYear(1999);

        when(peliculaRepositoryMock.save(any())).thenReturn(pelicula);
        when(peliculaRepositoryMock.existsById(any())).thenReturn(true);

        Pelicula savedPelicula = peliculaService.createPelicula(pelicula);

        pelicula.setDirector("Wachowski Sisters");

        Pelicula updatedPelicula = peliculaService.updatePelicula(savedPelicula.getId(), pelicula);

        assertNotNull(updatedPelicula);

        assertEquals("Wachowski Sisters", updatedPelicula.getDirector());
    }

}
