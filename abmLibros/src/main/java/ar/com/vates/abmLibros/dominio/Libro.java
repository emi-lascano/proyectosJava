package ar.com.vates.abmLibros.dominio;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {


    @Id
    @Column(name= "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idLibro;
    @Basic
    private String titulo;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name= "id_autor")
    private Autor autor;

    public Libro() {
    }

    public Libro(int idLibro, String titulo, Autor autor) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "idLibro=" + idLibro +
                ", titulo='" + titulo + '\'' +
                ", autor=" + autor +
                '}';
    }
}
