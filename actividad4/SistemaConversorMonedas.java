package actividad4;

import java.util.Scanner;

/**
 * Sistema Integrado de Conversión de Monedas con manejo de robustez de tipos.
 * Estudiante: Cristhian Veliz
 */
public class SistemaConversorMonedas {

    // Tasas de cambio hardcodeadas tomando como base común de pivote el USD
    // Tasas ilustrativas estables
    private static final double TASAS_USD_A_EUR = 0.92;
    private static final double TASAS_EUR_A_USD = 1.09;

    /**
     * Realiza el cálculo matemático si las monedas suministradas son USD o EUR.
     */
    public static double convertir(String monedaOrigen, String monedaDestino, double cantidad) 
            throws MonedaNoSoportadaException {
        
        // Limpieza de cadenas de entrada para evitar fallas por espacios o minúsculas
        String origen = monedaOrigen.trim().toUpperCase();
        String destino = monedaDestino.trim().toUpperCase();

        // Validación estricta de soporte de monedas
        if (!origen.equals("USD") && !origen.equals("EUR")) {
            throw new MonedaNoSoportadaException("La moneda de origen '" + monedaOrigen + "' no está soportada.");
        }
        if (!destino.equals("USD") && !destino.equals("EUR")) {
            throw new MonedaNoSoportadaException("La moneda de destino '" + monedaDestino + "' no está soportada.");
        }

        // Lógica de conversión
        if (origen.equals(destino)) {
            return cantidad; // Misma moneda
        } else if (origen.equals("USD") && destino.equals("EUR")) {
            return cantidad * TASAS_USD_A_EUR;
        } else {
            return cantidad * TASAS_EUR_A_USD;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== ACTIVIDAD 4: Sistema de Conversión de Monedas ===");
        System.out.println("Monedas soportadas oficialmente: USD, EUR");
        
        try {
            System.out.print("Ingrese la moneda de origen (Ej: USD): ");
            String mOrigen = sc.nextLine();
            
            System.out.print("Ingrese la moneda de destino (Ej: EUR): ");
            String mDestino = sc.nextLine();
            
            System.out.print("Ingrese la cantidad a convertir: ");
            String cantidadStr = sc.nextLine();
            
            // Conversión segura de tipo String a double (Exigencia de NumberFormatException)
            double cantidad = Double.parseDouble(cantidadStr);
            
            // Llamada al core del método de conversión con throws
            double resultado = convertir(mOrigen, mDestino, cantidad);
            
            // Impresión formateada con exactamente 2 decimales usando String.format
            System.out.println("\n=======================================");
            System.out.println("  RESULTADO DE LA CONVERSIÓN  ");
            System.out.println("=======================================");
            System.out.println(String.format("Monto original: %.2f %s", cantidad, mOrigen.toUpperCase()));
            System.out.println(String.format("Monto final:    %.2f %s", resultado, mDestino.toUpperCase()));
            System.out.println("=======================================");

        } catch (NumberFormatException e) {
            System.err.println("\n[Error de Formato]: La cantidad ingresada no es un número decimal o entero válido.");
        } catch (MonedaNoSoportadaException e) {
            System.err.println("\n[Error de Moneda]: " + e.getMessage());
        } finally {
            System.out.println("\nProceso de conversión finalizado. Gracias por utilizar el sistema.");
            sc.close();
        }
    }
}