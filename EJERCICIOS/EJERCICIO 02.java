import java.util.Arrays;
public class Subconjunto {
    public static int findKthSmallest(int[] arr, int k) {
        // Validación de parámetros
        if (arr == null || arr.length == 0 || k < 1 || k > arr.length) {
            throw new IllegalArgumentException("Parámetros inválidos");
        }
                // Hacemos una copia para no modificar el arreglo original
        int[] copy = arr.clone();
        return quickSelect(copy, 0, copy.length - 1, k - 1);
    }
    private static int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }
        int pivotIndex = partition(arr, left, right);

        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return quickSelect(arr, left, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, right, k);
        }
    }
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right]; // Elegimos el último elemento como pivote
        int i = left; // Índice del elemento más pequeño

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        // Casos de prueba proporcionados
        int[][] testCases = {
            {4, 2, 7, 10, 4, 17},    // k=3 → 4
            {4, 2, 7, 10, 4, 1, 6},   // k=5 → 6
            {4, 2, 7, 1, 4, 6},       // k=1 → 1
            {9, 2, 7, 1, 7}           // k=4 → 7
        };
        int[] ks = {3, 5, 1, 4};

        for (int i = 0; i < testCases.length; i++) {
            int[] arr = testCases[i];
            int k = ks[i];
            System.out.println("Array " + Arrays.toString(arr));
            int result = findKthSmallest(arr, k);
            System.out.println(k + " elemento más pequeño: " + result);
            System.out.println();
        }
    }
}
