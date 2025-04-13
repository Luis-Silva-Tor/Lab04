public class Viajes {

    public static int[][] calcularCostosMinimos(int[][] T) {
        int n = T.length;
        int[][] C = new int[n][n];

        // Inicializar C[i][j] con T[i][j]
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                C[i][j] = T[i][j];
            }
        }

        // Calcular costos mínimos usando programación dinámica
        for (int longitud = 2; longitud < n; longitud++) { // diferencia j - i
            for (int i = 0; i < n - longitud; i++) {
                int j = i + longitud;
                for (int k = i + 1; k < j; k++) {
                    C[i][j] = Math.min(C[i][j], T[i][k] + C[k][j]);
                }
            }
        }

        return C;
    }

    // Prueba con una matriz de ejemplo
    public static void main(String[] args) {
        int[][] T = {
            {0, 3, 999, 999, 8},
            {0, 0, 2, 999, 999},
            {0, 0, 0, 1, 999},
            {0, 0, 0, 0, 4},
            {0, 0, 0, 0, 0}
        };

        int[][] C = calcularCostosMinimos(T);

        System.out.println("Matriz de costos mínimos:");
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C.length; j++) {
                System.out.print((C[i][j] == 999 ? "∞" : C[i][j]) + "\t");
            }
            System.out.println();
        }
    }
}
