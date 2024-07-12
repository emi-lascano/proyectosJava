package ar.com.vates.abmLibros.controladores;

import ar.com.vates.abmLibros.dominio.Libro;
import ar.com.vates.abmLibros.servicios.LibrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/libro")
public class LibrosController {
    @Autowired
    private LibrosService serviceL;


    //1 - LISTADO DE TODOS LOS LIBROS ORDENADOS POR TITULO
    @GetMapping("")
    public Collection<Libro> librosOrdenados(){
        return serviceL.librosOrdenados();
    }


    //3 - LISTADO DE TODOS LOS LIBROS BUSCANDO POR TITULO
    @GetMapping("/librosPorTitulo/{titulo}")
    public ResponseEntity<Collection<Libro>> getLibrosPorTitulo(@PathVariable String titulo){
        return (serviceL.getLibrosPorTitulo(titulo).isEmpty()) ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(serviceL.getLibrosPorTitulo(titulo));
    }

    //4 - LISTADO DE TODOS LOS LIBROS DE UN AUTOR BUSCADO POR NOMBRE
    @GetMapping("/librosPorAutor/{nombre}")
    public ResponseEntity<Collection<Libro>> librosPorNombreAutor (@PathVariable String nombre){
        if(serviceL.librosPorNombreAutor(nombre).isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(serviceL.librosPorNombreAutor(nombre)) ;
    }

}
