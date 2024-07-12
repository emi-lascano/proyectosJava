package ar.com.vates.abmLibros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AbmLibrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbmLibrosApplication.class, args);

		System.out.println("\n" +
				"1) Listado de todos los libros ordenados por titulo\n" +
				"localhost:8080/libro\n" +
				"\n" +
				"2) Cantidad de libros de un autor indicado por id\n" +
				"localhost:8080/autor/{idAutor}/CantidadLibrosPorAutor\n" +
				"\n" +
				"3) Listado de todos los libros buscando por titulo\n" +
				"localhost:8080/libro/librosPorTitulo/{titulo\n" +
				"\n" +
				"4) Listado de todos los libros de un autor buscado por nombre\n" +
				"localhost:8080/libro/librosPorAutor/{nombre}");
	}

}
