package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Libro> libros;

    public Biblioteca() {
        libros = new ArrayList<>();
    }

    public boolean agregarLibro(Libro libro) {

        if (buscarLibroPorISBN(libro.getIsbn()) != null) {
            System.out.println("Error: El libro con ese ISBN ya existe.");
            return false;
        }

        libros.add(libro);
        return true;
    }

    public boolean eliminarLibro(String isbn) {

        Libro libro = buscarLibroPorISBN(isbn);

        if (libro != null) {
            libros.remove(libro);
            return true;
        }

        return false;
    }

    public List<Libro> buscarLibroPorTitulo(String titulo) {

        List<Libro> resultados = new ArrayList<>();

        for (Libro libro : libros) {

            if (libro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultados.add(libro);
            }

        }

        return resultados;
    }

    public List<Libro> listarLibros() {
        return new ArrayList<>(libros);
    }

    public boolean verificarDisponibilidad(String isbn) {

        Libro libro = buscarLibroPorISBN(isbn);

        if (libro != null) {
            return libro.isDisponible();
        }

        return false;
    }

    public boolean prestarLibro(String isbn) {

        Libro libro = buscarLibroPorISBN(isbn);

        if (libro != null && libro.isDisponible()) {
            libro.setDisponible(false);
            return true;
        }

        return false;
    }

    public boolean devolverLibro(String isbn) {

        Libro libro = buscarLibroPorISBN(isbn);

        if (libro != null && !libro.isDisponible()) {
            libro.setDisponible(true);
            return true;
        }

        return false;
    }

    private Libro buscarLibroPorISBN(String isbn) {

        for (Libro libro : libros) {

            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }

        }

        return null;
    }
}