public class Viajes {

    /**
     * Calcula los costos mínimos de viaje entre pares de ciudades consecutivas,
     * permitiendo hacer paradas intermedias para minimizar el costo total.
     */
    public static int[][] calcularCostosMinimos(int[][] T) {
        int n = T.length;
        int[][] C = new int[n][n];
        // Inicializa la matriz C con los costos directos desde la matriz T
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                C[i][j] = T[i][j];
            }
        }
        // Calcula los costos mínimos entre pares de ciudades usando programación dinámica
        // longitud: diferencia entre j e i 
        for (int longitud = 2; longitud < n; longitud++) {
            for (int i = 0; i < n - longitud; i++) {
                int j = i + longitud;
                // Se busca una ciudad intermedia k que minimice el costo total
                for (int k = i + 1; k < j; k++) {
                    C[i][j] = Math.min(C[i][j], T[i][k] + C[k][j]);
                }
            }
        }
        return C;
    }
    /**
     * Método principal para probar el algoritmo con un ejemplo de matriz de costos directos.
     */
    public static void main(String[] args) {
        // Matriz de costos directos entre ciudades (0 significa sin costo, 999 significa sin conexión directa)
        int[][] T = {
            {0, 3, 999, 999, 8},
            {0, 0, 2, 999, 999},
            {0, 0, 0, 1, 999},
            {0, 0, 0, 0, 4},
            {0, 0, 0, 0, 0}
        };
        // Calcula los costos mínimos usando el algoritmo
        int[][] C = calcularCostosMinimos(T);

        // Muestra la matriz resultante de costos mínimos
        System.out.println("Matriz de costos mínimos:");
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C.length; j++) {
                // Muestra '∞' si el valor es 999 (inaccesible)
                System.out.print((C[i][j] == 999 ? "∞" : C[i][j]) + "\t");
            }
            System.out.println();
        }
    }
}
