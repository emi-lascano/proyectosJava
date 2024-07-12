package ar.com.vates.abmLibros.servicios;

import ar.com.vates.abmLibros.dominio.Autor;
import ar.com.vates.abmLibros.dominio.Libro;
import ar.com.vates.abmLibros.repositorios.AutoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@Service
public class AutoresService {
    @Autowired
    private AutoresRepository repoA;

    public AutoresService() {
    }


    //2 - CANTIDAD DE LIBROS DE UN AUTOR, INDICADOR POR ID
    public ResponseEntity cantidadLibros(int idAutor){
        Optional<Autor> encontrado= repoA.findById(idAutor);
        if(encontrado.isPresent()){
            Long cantidad= encontrado.get().getLibros().stream().count();
            return ResponseEntity.ok(String.format("Cantidad de libros del autor: " + encontrado.get().getNombre() + " es: " + cantidad));
        }
        return    ResponseEntity.notFound().build();
    }



    public Collection<Autor> listarAutores(){
        return repoA.findAll();    }


    public ResponseEntity<Autor> AutoresPorId(int id){
        Optional<Autor> existeA= repoA.findById(id) ;
        return (existeA.isPresent()) ? ResponseEntity.ok(existeA.get()) : ResponseEntity.notFound().build();
    }

    public ResponseEntity guadarAutor(int id, Autor a ){
        a.setIdAutor(id);
        return (repoA.save(a)==null) ?  ResponseEntity.created(URI.create(String.format("autor /%d", id))).build(): ResponseEntity.ok().build() ;
    }


    public ResponseEntity<Collection<Libro>> getLibros(int idAutor){
        Optional<Autor> encontrado= repoA.findById(idAutor);
        return (encontrado.isPresent()) ? ResponseEntity.ok(encontrado.get().getLibros()) : ResponseEntity.notFound().build();
    }


    public ResponseEntity<Libro> getLibroPorId(int idAutor, int idLibro){
        Optional<Autor> AutorEncontrado= repoA.findById(idAutor);
        if(AutorEncontrado != null) {
            Optional<Libro> libroEncontrado = AutorEncontrado.get().getLibros().stream().filter(t->t.getIdLibro()== idLibro).findFirst();
            if(libroEncontrado.isPresent()) return ResponseEntity.ok(libroEncontrado.get());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity agregarLibro(int idAutor, Libro libroNuevo) throws URISyntaxException {
        Optional<Autor> encontrado= repoA.findById(idAutor);
        if(encontrado.isPresent())
        {
            libroNuevo.setAutor(encontrado.get());
            encontrado.get().getLibros().add(libroNuevo);
            repoA.save(encontrado.get());

            int nuevoId = encontrado.get().getLibros().stream().filter(t->t.getTitulo().equals(libroNuevo.getTitulo())).findFirst().get().getIdLibro();
            return ResponseEntity.created(new URI(String.format("/autor /%d /libro /%d", idAutor, libroNuevo.getIdLibro()))).build();

        }
        else return ResponseEntity.notFound().build();
    }




    public ResponseEntity<Autor> borrarAutor(int id){
        Optional<Autor> existeA= repoA.findById(id);
        if(existeA.isPresent()){
            repoA.delete(existeA.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }





}
