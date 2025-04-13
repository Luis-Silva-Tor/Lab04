/**
 * Clase que implementa una solución recursiva para el problema de corte de varilla.
 */
public class NaiveSolution {
    /**
     * Calcula el valor máximo obtenible al cortar una varilla de longitud dada.
     * 
     */
    static int getValue(int[] values, int length) {
        // Caso base: varilla de longitud 0 no tiene valor
        if (length <= 0)
            return 0;
                   int tmpMax = -1;
               // Prueba todos los posibles cortes iniciales
        for (int i = 0; i < length; i++) {
            // Valor del primer corte + mejor valor del resto
            tmpMax = Math.max(tmpMax, values[i] + getValue(values, length - i - 1));
        }
                return tmpMax;
    }
    public static void main(String[] args) {
        int[] values = new int[]{3, 7, 1, 3, 9}; // Precios para longitudes 1-5
        int rodLength = values.length;
                System.out.println("El valor máximo: " + getValue(values, rodLength));
        // Output: 9 (mejor opción es no cortar)
    }
}