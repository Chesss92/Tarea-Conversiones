package actividad2;

/**
 * Excepción personalizada para validación de edad de estudiantes.
 * Estudiante: Cristhian Veliz
 */
public class EdadInvalidaException extends Exception {
    private final int edadIngresada;

    // Constructor que recibe la edad y un mensaje descriptivo
    public EdadInvalidaException(int edadIngresada, String mensaje) {
        super(mensaje);
        this.edadIngresada = edadIngresada;
    }

    // Getter para obtener el atributo de la edad que causó el error
    public int getEdadIngresada() {
        return edadIngresada;
    }
}