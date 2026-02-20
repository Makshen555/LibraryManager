package biblioteca;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static Biblioteca biblioteca = new Biblioteca();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {

            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1:
                    agregarLibro();
                    break;

                case 2:
                    eliminarLibro();
                    break;

                case 3:
                    buscarLibroPorTitulo();
                    break;

                case 4:
                    listarLibros();
                    break;

                case 5:
                    prestarLibro();
                    break;

                case 6:
                    devolverLibro();
                    break;

                case 7:
                    verificarDisponibilidad();
                    break;

                case 8:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 8);
    }

    private static void mostrarMenu() {

        System.out.println("\n===== SISTEMA DE BIBLIOTECA =====");
        System.out.println("1. Agregar libro");
        System.out.println("2. Eliminar libro");
        System.out.println("3. Buscar libro por título");
        System.out.println("4. Listar todos los libros");
        System.out.println("5. Prestar libro");
        System.out.println("6. Devolver libro");
        System.out.println("7. Verificar disponibilidad");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void agregarLibro() {

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        System.out.print("Año: ");
        int anio = scanner.nextInt();
        scanner.nextLine();

        try {
            biblioteca.agregarLibro(new Libro(titulo, autor, isbn, anio));
            System.out.println("Libro agregado correctamente.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void eliminarLibro() {

        System.out.print("Ingrese ISBN: ");
        String isbn = scanner.nextLine();

        if (biblioteca.eliminarLibro(isbn)) {
            System.out.println("Libro eliminado.");
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    private static void buscarLibroPorTitulo() {

        System.out.print("Ingrese título a buscar: ");
        String titulo = scanner.nextLine();

        List<Libro> resultados = biblioteca.buscarLibroPorTitulo(titulo);

        mostrarLista(resultados);
    }

    private static void listarLibros() {

        mostrarLista(biblioteca.listarLibros());
    }

    private static void prestarLibro() {

        System.out.print("Ingrese ISBN: ");
        String isbn = scanner.nextLine();

        biblioteca.prestarLibro(isbn);
    }

    private static void devolverLibro() {

        System.out.print("Ingrese ISBN: ");
        String isbn = scanner.nextLine();

        biblioteca.devolverLibro(isbn);
    }

    private static void verificarDisponibilidad() {

        System.out.print("Ingrese ISBN: ");
        String isbn = scanner.nextLine();

        boolean disponible = biblioteca.verificarDisponibilidad(isbn);

        if (disponible) {
            System.out.println("El libro está disponible.");
        } else {
            System.out.println("El libro NO está disponible.");
        }
    }

    private static void mostrarLista(List<Libro> libros) {

        if (libros.isEmpty()) {
            System.out.println("No hay libros.");
            return;
        }

        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }
}