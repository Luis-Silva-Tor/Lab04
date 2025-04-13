import java.util.*;
/**
 * Clase para verificar si existe un subconjunto que sume un objetivo
  */
public class BuscarElementoMenor {
    public static void main(String[] args) {
        // Casos de prueba con formato: {n, elementos..., objetivo}
        int[][] casos = {
            {5, 4, 8, 10, 3, 5, 27},    // true (4+8+5+10=27)
            {5, 4, 8, 10, 3, 6, 27},    // false
            {6, 2, 16, 5, 7, 10, 33},   // true (2+16+10+5=33)
            {6, 2, 16, 5, 3, 10, 33},   // false
            {4, 2, 5, 1, 6, 13}         // true (2+5+6=13)
        };
        // Ejecutar y mostrar resultados
        for (int[] caso : casos) {
            System.out.println(Arrays.toString(caso) + " → " + verificar(caso));
        }
    }
    /**
     * Verifica si existe un subconjunto válido que sume el objetivo
         */
    public static boolean verificar(int[] arr) {
        int n = arr[0];                     // Cantidad de elementos
        int objetivo = arr[arr.length-1];    // Valor objetivo
        int[] nums = Arrays.copyOfRange(arr, 1, arr.length-1); // Extraer números
        
        int sumaFija = 0;                    // Suma de potencias 
        List<Integer> opcionales = new ArrayList<>(); // Números opcionales
        // Clasificar números según restricciones
        for (int i = 0; i < nums.length; i++) {
            if (esPotencia2(nums[i])) {
                sumaFija += nums[i];         // Sumar potencias 
            }
            // Excluir múltiplos de 5 seguidos de impares
            else if (!(esMultiplo5(nums[i]) && i < nums.length-1 && nums[i+1]%2 == 1)) {
                opcionales.add(nums[i]);     // Agregar a opcionales
            }
        }
        // Verificar si ya se cumple con las obligatorias o buscar combinaciones
        return sumaFija == objetivo || buscar(opcionales, 0, sumaFija, objetivo);
    }
    /**
     * Busca recursivamente combinaciones de números opcionales
       */
    private static boolean buscar(List<Integer> nums, int i, int suma, int objetivo) {
        // Caso base: terminó de procesar números
        if (i >= nums.size()) return suma == objetivo;
        
        // Probar incluyendo o excluyendo el número actual
        return buscar(nums, i+1, suma + nums.get(i), objetivo) ||  
               buscar(nums, i+1, suma, objetivo);                 
    }
    // Verifica si un número es potencia de 2 1, 2, 4, 8, 16.
    private static boolean esPotencia2(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }
    // Verifica si un número es múltiplo de 5
    private static boolean esMultiplo5(int n) {
        return n % 5 == 0;
    }
}