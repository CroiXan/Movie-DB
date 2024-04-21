package dsy.movies.movies.controller;

import java.util.List;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import dsy.movies.movies.model.Pelicula;
import dsy.movies.movies.service.PeliculaServiceImpl;

@WebMvcTest(PeliculaController.class)
public class PeliculaControllerTest {

    @Autowired 
    private MockMvc mockMvc;

    @MockBean 
    private PeliculaServiceImpl peliculaServiceImplMock;

    @Test
    public void gellAllMoviesTest() throws Exception{

        Pelicula pelicula1 = new Pelicula();
        pelicula1.setTitulo("The Matrix");
        pelicula1.setDirector("Wachowski Sisters");
        pelicula1.setGenero("Sci-Fi");
        pelicula1.setSinopsis("When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence.");
        pelicula1.setYear(1999);

        Pelicula pelicula2 = new Pelicula();
        pelicula2.setTitulo("Pulp Fiction");
        pelicula2.setDirector("Quentin Tarantino");
        pelicula2.setGenero("Crime");
        pelicula2.setSinopsis("The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.");
        pelicula2.setYear(1994);

        List<Pelicula> peliculaList = new ArrayList<Pelicula>();

        peliculaList.add(pelicula1);
        peliculaList.add(pelicula2);

        when(peliculaServiceImplMock.getAllPeliculas()).thenReturn(peliculaList);

        mockMvc.perform(MockMvcRequestBuilders.get("/peliculas"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$",Matchers.hasSize(2)))
            .andExpect(MockMvcResultMatchers.jsonPath("$[0].titulo",Matchers.is("The Matrix")))
            .andExpect(MockMvcResultMatchers.jsonPath("$[1].titulo",Matchers.is("Pulp Fiction")));
    }
    
}
