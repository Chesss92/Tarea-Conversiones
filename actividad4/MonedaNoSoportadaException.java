package actividad4;

/**
 * Excepción para indicar que el código ISO de moneda no es aceptado por el conversor.
 * Estudiante: Cristhian Veliz
 */
public class MonedaNoSoportadaException extends Exception {
    public MonedaNoSoportadaException(String mensaje) {
        super(mensaje);
    }
}