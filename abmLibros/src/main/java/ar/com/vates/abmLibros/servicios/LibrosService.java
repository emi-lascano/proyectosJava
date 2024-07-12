package ar.com.vates.abmLibros.servicios;

import ar.com.vates.abmLibros.dominio.Libro;
import ar.com.vates.abmLibros.repositorios.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.Collection;
import java.util.Optional;

@Service
public class LibrosService {

        @Autowired
        private LibrosRepository repoL;

        public LibrosService() {
        }

        //1 - LISTADO DE TODOS LOS LIBROS ORDENADOS POR TITULO
        public Collection<Libro> librosOrdenados(){
                return repoL.getLibrosByOrderByTitulo();
        }



        //3 - LISTADO DE TODOS LOS LIBROS BUSCANDO POR TITULO
        public Collection<Libro> getLibrosPorTitulo(String titulo){
                return repoL.findByTituloContaining(titulo);
        }



        //4 - Listado de todos los libros de un autor buscado por nombre
        public Collection<Libro> librosPorNombreAutor (String nombre){
             return  repoL.librosPorNombre(nombre) ;}

}


