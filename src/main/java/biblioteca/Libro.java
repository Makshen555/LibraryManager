package biblioteca;


public class Libro {

    private String titulo;
    private String autor;
    private String isbn;
    private int anioPublicacion;
    private boolean disponible;

    /// Constructor de la clase Libro
    public Libro(String titulo, String autor, String isbn, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.disponible = true; // Por defecto el libro está disponible
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    // Setter para disponibilidad
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }


     /// Metodo toString para mostrar la información del libro
    @Override
    public String toString() {
        return "Libro {" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", anioPublicacion=" + anioPublicacion +
                ", disponible=" + (disponible ? "Si" : "No") +
                '}';
    }
}