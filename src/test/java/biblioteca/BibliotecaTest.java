package biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Biblioteca
 * Cubre funcionalidad, validación y manejo de errores
 */
public class BibliotecaTest {

    private Biblioteca biblioteca;
    private Libro libro1;
    private Libro libro2;

    /**
     * Se ejecuta antes de cada prueba
     */
    @BeforeEach
    void setUp() {

        biblioteca = new Biblioteca();

        libro1 = new Libro(
                "Clean Code",
                "Robert Martin",
                "ISBN001",
                2008);

        libro2 = new Libro(
                "Effective Java",
                "Joshua Bloch",
                "ISBN002",
                2018);

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
    }

    @Test
    void testAgregarLibroValido() {

        Libro libroNuevo = new Libro(
                "Java Basics",
                "Autor Test",
                "ISBN003",
                2020);

        boolean resultado = biblioteca.agregarLibro(libroNuevo);

        assertTrue(resultado);
        assertEquals(3, biblioteca.listarLibros().size());
    }

    @Test
    void testEliminarLibroExistente() {

        boolean resultado = biblioteca.eliminarLibro("ISBN001");

        assertTrue(resultado);
        assertEquals(1, biblioteca.listarLibros().size());
    }

    @Test
    void testBuscarLibroPorTitulo() {

        List<Libro> resultados = biblioteca.buscarLibroPorTitulo("Java");

        assertEquals(1, resultados.size());
        assertEquals("Effective Java", resultados.get(0).getTitulo());
    }

    @Test
    void testListarLibros() {

        List<Libro> lista = biblioteca.listarLibros();

        assertEquals(2, lista.size());
    }

    @Test
    void testAgregarLibroISBNDuplicado() {

        Libro duplicado = new Libro(
                "Otro libro",
                "Autor",
                "ISBN001",
                2022);

        boolean resultado = biblioteca.agregarLibro(duplicado);

        assertFalse(resultado);
        assertEquals(2, biblioteca.listarLibros().size());
    }

    @Test
    void testBuscarLibroInexistente() {

        List<Libro> resultados = biblioteca.buscarLibroPorTitulo("Python");

        assertTrue(resultados.isEmpty());
    }

    @Test
    void testEliminarLibroInexistente() {

        boolean resultado = biblioteca.eliminarLibro("ISBN999");

        assertFalse(resultado);
    }

    @Test
    void testVerificarDisponibilidad() {

        boolean disponible = biblioteca.verificarDisponibilidad("ISBN001");

        assertTrue(disponible);
    }

    @Test
    void testPrestarLibro() {

        boolean prestado = biblioteca.prestarLibro("ISBN001");

        assertTrue(prestado);
        assertFalse(biblioteca.verificarDisponibilidad("ISBN001"));
    }

    @Test
    void testDevolverLibro() {

        biblioteca.prestarLibro("ISBN001");

        boolean devuelto = biblioteca.devolverLibro("ISBN001");

        assertTrue(devuelto);
        assertTrue(biblioteca.verificarDisponibilidad("ISBN001"));
    }

    @Test
    void testPrestarLibroYaPrestado() {

        biblioteca.prestarLibro("ISBN001");

        boolean resultado = biblioteca.prestarLibro("ISBN001");

        assertFalse(resultado);
    }

    @Test
    void testDevolverLibroNoPrestado() {

        boolean resultado = biblioteca.devolverLibro("ISBN001");

        assertFalse(resultado);
    }

    @Test
    void testVerificarDisponibilidadLibroInexistente() {

        boolean resultado = biblioteca.verificarDisponibilidad("ISBN999");

        assertFalse(resultado);
    }

}