public class BinarySearch {

    /**
     * Método recursivo de búsqueda binaria

     * x Elemento a buscar
     * Índice del elemento encontrado, o -1 si no existe
     */
    public int binarySearch(int arr[], int lo, int hi, int x) {
        // Caso base: el elemento no está presente
        if (hi < lo || lo >= arr.length) {
            return -1;
        }

        // Calcular punto medio
        int mid = lo + (hi - lo) / 2;

        // Si encontramos el elemento en el medio
        if (arr[mid] == x) {
            return mid;
        }
        // Si el elemento es menor que el medio, buscar en la mitad izquierda
        else if (arr[mid] > x) {
            return binarySearch(arr, lo, mid - 1, x);
        }
        // Si el elemento es mayor que el medio, buscar en la mitad derecha
        else {
            return binarySearch(arr, mid + 1, hi, x);
        }
    }
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] arr = {1,2,3,4,5,78,54,1,14,12,10,2}; // Array debe estar ordenado
        int x = 5; // Elemento a buscar
                int result = bs.binarySearch(arr, 0, arr.length - 1, x);
               if (result == -1) {
            System.out.println("Elemento no encontrado");
        } else {
            System.out.println("Elemento encontrado en el índice: " + result);
        }
    }
}