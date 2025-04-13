import java.util.HashMap;
import java.util.Map;


public class Moda {

    /**
     * 
     * Ejemplo de uso:
     * int[] datos = {1, 2, 2, 3, 3, 3, 4};
     * int moda = Moda.modal(datos); // Retorna 3
     */
    public static int modal(int[] array) {
        if (array.length == 0) throw new IllegalArgumentException("Array vacío");

        // Mapa para almacenar frecuencias (número -> cantidad de ocurrencias)
        Map<Integer, Integer> frecuencias = new HashMap<>();
        
        int moda = array[0];       // Moda provisional (primer elemento)
        int maxFrecuencia = 1;     // Frecuencia máxima encontrada

        // Recorremos cada número del arreglo
        for (int num : array) {
            // Actualizamos la frecuencia del número actual (+1)
            int freq = frecuencias.getOrDefault(num, 0) + 1;
            frecuencias.put(num, freq);

            // Verificamos si es la nueva moda:
            // 1. Si tiene mayor frecuencia que la actual
            // 2. Si tiene igual frecuencia pero es un número mayor
            if (freq > maxFrecuencia || (freq == maxFrecuencia && num > moda)) {
                maxFrecuencia = freq;
                moda = num;
            }
        }
        
        return moda;
    }

    /**
     * Método principal con ejemplo de uso
     */
    public static void main(String[] args) {
        // Ejemplo básico
        int[] numeros = {1, 2, 2, 3, 3, 3, 4};
        System.out.println("La moda es: " + modal(numeros));  // Output: 3
        
        // Ejemplo con empate (selecciona el mayor)
        int[] empate = {5, 5, 2, 2, 5, 2};
        System.out.println("Moda con empate: " + modal(empate)); // Output: 5
    }
}