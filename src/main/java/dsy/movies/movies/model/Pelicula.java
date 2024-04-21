package dsy.movies.movies.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;

@Entity
@Table (name = "pelicula")
public class Pelicula extends RepresentationModel<Pelicula> {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name="id_pelicula")
    private Long id;

    @Column(name="titulo")
    private String titulo;
    
    @Column(name="pelicula_year")
    private int year;

    @Column(name="director")
    private String director;

    @Column(name="genero")
    private String genero;

    @Column(name="sinopsis")
    private String sinopsis;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

}
