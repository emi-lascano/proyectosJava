package ar.com.vates.abmLibros.repositorios;

import ar.com.vates.abmLibros.dominio.Autor;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;


@Repository
public interface AutoresRepository extends JpaRepository<Autor, Integer> {


}
