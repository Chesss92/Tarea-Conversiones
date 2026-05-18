package actividad2;

/**
 * Clase Estudiante que valida sus restricciones en el constructor.
 * Estudiante: Cristhian Veliz
 */
public class Estudiante {
    private String nombre;
    private int edad;
    private double promedio;

    // El constructor usa la cláusula 'throws' para indicar que puede propagar esta excepción
    public Estudiante(String nombre, int edad, double promedio) throws EdadInvalidaException {
        if (edad < 0 || edad > 120) {
            // Se usa 'throw' para instanciar y lanzar activamente la excepción personalizada
            throw new EdadInvalidaException(edad, "La edad " + edad + " está fuera del rango permitido (0 - 120 años).");
        }
        this.nombre = nombre;
        this.edad = edad;
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Estudiante[Nombre: " + nombre + ", Edad: " + edad + ", Promedio: " + promedio + "]";
    }
}