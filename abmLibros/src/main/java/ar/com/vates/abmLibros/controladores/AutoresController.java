package ar.com.vates.abmLibros.controladores;

import ar.com.vates.abmLibros.dominio.Autor;
import ar.com.vates.abmLibros.dominio.Libro;

import ar.com.vates.abmLibros.servicios.AutoresService;
import ar.com.vates.abmLibros.servicios.LibrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autor")
public class AutoresController {

    @Autowired
    private AutoresService serviceA;

    AutoresController(){
    }


    //2 - CANTIDAD DE LIBROS DE UN AUTOR, INDICADOR POR ID
    @GetMapping("/{idAutor}/CantidadLibrosPorAutor")
    public ResponseEntity cantidadLibros(@PathVariable int idAutor){
        return  serviceA.cantidadLibros(idAutor);
    }


    //OPCION
  /*  //4 - LISTADO DE TODOS LOS LIBROS DE UN AUTOR BUSCADO POR NOMBRE
    @GetMapping("/{nombreAutor}/librosDeAutor")
    public ResponseEntity<Collection<Libro>> librosDeAutor(@PathVariable String nombreAutor){
        Optional<Autor> encontrado= listarAutores().stream().filter(a->a.getNombre().equals(nombreAutor)).findFirst();
        return (encontrado.isPresent()) ? ResponseEntity.ok(encontrado.get().getLibros()) : ResponseEntity.notFound().build();

    }*/


    @GetMapping("")
    public Collection<Autor> listarAutores(){
        return serviceA.listarAutores();    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> AutoresPorId(@PathVariable int id){
        return serviceA.AutoresPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity guadarAutor(@PathVariable int id, @RequestBody Autor a ){
        return serviceA.guadarAutor( id,  a ) ;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Autor> borrarAutor(@PathVariable  int id){
      return serviceA.borrarAutor(id);
    }

    @GetMapping("/{idAutor}/libro")
    public ResponseEntity<Collection<Libro>> getLibros(@PathVariable int idAutor){
       return serviceA.getLibros(idAutor);
    }

    @GetMapping("/{idAutor}/libro/{idLibro}")
    public ResponseEntity<Libro> getLibroPorId(@PathVariable int idAutor, @PathVariable int idLibro){
        return serviceA.getLibroPorId(idAutor, idLibro);
    }

    @PostMapping("/{idAutor}/libro")
    public ResponseEntity agregarLibro(@PathVariable int idAutor, @RequestBody Libro libroNuevo) throws URISyntaxException {
        return agregarLibro(idAutor,libroNuevo);
    }




}
