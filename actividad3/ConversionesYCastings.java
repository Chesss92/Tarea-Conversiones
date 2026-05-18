package actividad3;

/**
 * Actividad 3 — Conversión Implícita y Explícita (Widening, Narrowing, Strings y Object Casting)
 * Estudiante: Cristhian Veliz
 */
public class ConversionesYCastings {

    // Clases anidadas estáticas para la jerarquía de la PARTE D
    static class Animal {
        public void hacerSonido() {
            System.out.println("El animal hace un sonido genérico.");
        }
    }

    static class Perro extends Animal {
        @Override
        public void hacerSonido() {
            System.out.println("El perro ladra: ¡Guau, guau!");
        }
        
        public void moverCola() {
            System.out.println("El perro está moviendo la cola felizmente.");
        }
    }

    public static void main(String[] args) {
        // =====================================================================
        // PARTE A — Conversión implícita (Widening)
        // =====================================================================
        System.out.println("=== PARTE A: Conversión Implícita (Widening) ===");
        byte miByte = 12;
        short miShort = miByte;  // byte a short automáticamente
        int miInt = miShort;     // short a int automáticamente
        long miLong = miInt;     // int a long automáticamente
        float miFloat = miLong;   // long a float automáticamente (puede perder precisión en bits muy grandes, pero es seguro en rango)
        double miDouble = miFloat; // float a double automáticamente

        System.out.println("byte original: " + miByte);
        System.out.println("short (desde byte): " + miShort);
        System.out.println("int (desde short): " + miInt);
        System.out.println("long (desde int): " + miLong);
        System.out.println("float (desde long): " + miFloat);
        System.out.println("double (desde float): " + miDouble);


        // =====================================================================
        // PARTE B — Casting explícito (Narrowing)
        // =====================================================================
        System.out.println("\n=== PARTE B: Casting Explícito (Narrowing) ===");
        double doubleOriginal = 45.89;
        
        float versionFloat = (float) doubleOriginal;
        int versionInt = (int) doubleOriginal; 
        short versionShort = (short) doubleOriginal;
        byte versionByte = (byte) doubleOriginal;

        System.out.println("double Original: " + doubleOriginal);
        System.out.println("float obtenido: " + versionFloat + " -> Pérdida menor de precisión en los decimales más lejanos.");
        System.out.println("int obtenido: " + versionInt + " -> Se pierde TODA la parte decimal (.89) por truncamiento.");
        System.out.println("short obtenido: " + versionShort + " -> Conserva el valor truncado 45 porque cabe en 16 bits.");
        System.out.println("byte obtenido: " + versionByte + " -> Conserva el valor truncado 45 porque cabe en el rango -128 a 127.");
        
        /* * NOTA EXPLICATIVA SOBRE PÉRDIDA DE INFORMACIÓN:
         * 1. Al pasar de double a float, se reduce la precisión de 64 a 32 bits.
         * 2. Al transformar a tipos enteros (int, short, byte), ocurre un TRUNCAMIENTO absoluto
         * de la sección fraccionaria, eliminando el .89 por completo.
         * 3. Si el número original excediera los límites del byte (-128 a 127) o short (-32768 a 32767),
         * ocurriría además un desbordamiento (overflow), alterando el valor entero drásticamente por envoltura binaria.
         */


        // =====================================================================
        // PARTE C — Conversión con Strings
        // =====================================================================
        System.out.println("\n=== PARTE C: Conversión con Strings ===");
        String strInt = "2024";
        String strDouble = "98.6";
        String strBool = "false";

        // De String a Primitivo (Parsing)
        int parsedInt = Integer.parseInt(strInt);
        double parsedDouble = Double.parseDouble(strDouble);
        boolean parsedBool = Boolean.parseBoolean(strBool);

        System.out.println("Strings Parseados a tipos correspondientes: " + parsedInt + " (int), " + parsedDouble + " (double), " + parsedBool + " (boolean)");

        // De vuelta a String usando 3 métodos diferentes exigidos por la rúbrica
        // Método 1: String.valueOf()
        String metodo1_Int = String.valueOf(parsedInt);
        // Método 2: Métodos wrapper toString()
        String metodo2_Double = Double.toString(parsedDouble);
        // Método 3: Concatenación con cadena vacía "" o String.format()
        String metodo3_Bool = "" + parsedBool; 

        System.out.println("De vuelta a String - Método 1 (String.valueOf): " + metodo1_Int);
        System.out.println("De vuelta a String - Método 2 (Double.toString): " + metodo2_Double);
        System.out.println("De vuelta a String - Método 3 (Concatenación ""): " + metodo3_Bool);


        // =====================================================================
        // PARTE D — Casting de objetos (Polimorfismo e instanceof)
        // =====================================================================
        System.out.println("\n=== PARTE D: Casting de Objetos ===");
        
        // 1. Instanciar clase hija Perro
        Perro miPerro = new Perro();
        
        // 2. Asignarlo implícitamente a una referencia de tipo padre Animal (Upcasting)
        Animal miAnimal = miPerro; 
        System.out.println("Upcasting ejecutado con éxito. La referencia es de tipo Animal.");
        
        // El objeto sigue siendo un perro, pero a través de miAnimal solo podemos acceder a métodos de Animal.
        miAnimal.hacerSonido(); // Ejecuta el método sobreescrito de Perro por enlace dinámico

        // 3. Evaluar y volver a castear a Perro de forma segura usando instanceof (Downcasting)
        if (miAnimal instanceof Perro) {
            System.out.println("Comprobación instanceof exitosa: El Animal es realmente un Perro.");
            Perro perroCasteado = (Perro) miAnimal; // Casting explícito de objeto
            
            // Ahora podemos acceder a comportamientos específicos de la subclase
            perroCasteado.moverCola();
        } else {
            System.out.println("La conversión no es segura.");
        }
    }
}