package actividad2;

/**
 * Clase Principal para probar el comportamiento de EdadInvalidaException.
 * Estudiante: Cristhian Veliz
 */
public class Principal {

    public static void main(String[] args) {
        System.out.println("=== ACTIVIDAD 2: Excepción Personalizada ===");

        // Arreglo de datos de prueba para inicializar estudiantes
        String[] nombres = {"Leandro Jacho", "Lorena Chulde", "Cristhian Veliz"};
        int[] edades = {21, -5, 125}; // Incluye intencionalmente dos edades inválidas
        double[] promedios = {9.2, 8.5, 9.8};

        for (int i = 0; i < nombres.length; i++) {
            try {
                System.out.println("\nIntentando registrar a: " + nombres[i] + " con edad: " + edades[i]);
                Estudiante est = new Estudiante(nombres[i], edades[i], promedios[i]);
                // Si la línea anterior falla, el flujo salta al bloque catch e impide esta impresión
                System.out.println(">> ¡Registro Exitoso!: " + est);
            } catch (EdadInvalidaException e) {
                System.err.println(">> Error de Registro: " + e.getMessage());
                System.err.println("   Valor rechazado registrado en la excepción: " + e.getEdadIngresada());
            }
        }
    }
}