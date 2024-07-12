package ar.com.vates.abmLibros.repositorios;

import ar.com.vates.abmLibros.dominio.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Collection;
import java.util.Optional;

public interface LibrosRepository extends JpaRepository<Libro, Integer> {

    //1- LISTADO DE TODOS LOS LIBROS ORDENADOS POR TITULO
    public Collection<Libro> getLibrosByOrderByTitulo();


    //3 - LISTADO DE TODOS LOS LIBROS BUSCANDO POR TITULO
    public Collection<Libro> findByTituloContaining(String prefix);


    //4 - LISTADO DE TODOS LOS LIBROS DE UN AUTOR BUSCADO POR NOMBRE
    @Query("Select a.libros from Autor a where a.nombre like :nombre ")
    Collection<Libro> librosPorNombre(String nombre);

}
