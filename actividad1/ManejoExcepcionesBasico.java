package actividad1;

import java.util.Scanner;

/**
 * Actividad 1 — Manejo de Excepciones Básico
 * Estudiante: Cristhian Veliz
 */
public class ManejoExcepcionesBasico {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== ACTIVIDAD 1: Manejo de Excepciones Básico ===");
        System.out.print("Por favor, ingrese un número entero: ");
        
        try {
            // Lectura del número como String para capturar fallas de formato de manera controlada
            String entrada = scanner.nextLine();
            
            // Si el texto no es un número entero válido, lanzará NumberFormatException
            int numero = Integer.parseInt(entrada);
            
            // División de 100 entre el número. Si es 0, lanzará ArithmeticException
            int resultado = 100 / numero;
            
            System.out.println("Resultado exitoso: 100 / " + numero + " = " + resultado);
            
        } catch (NumberFormatException e) {
            System.err.println("Error: El valor ingresado no es un número entero válido. [NumberFormatException]");
        } catch (ArithmeticException e) {
            System.err.println("Error: No es posible dividir por cero de forma entera. [ArithmeticException]");
        } finally {
            // Bloque que se ejecuta obligatoriamente sin importar si hubo excepción o no
            System.out.println("Programa finalizado correctamente.");
            scanner.close();
        }
    }
}