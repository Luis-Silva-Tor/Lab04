import java.util.*;

public class BuscarElementoMenor {
    public static void main(String[] args) {
        int[][] casos = {
            {5, 4, 8, 10, 3, 5, 27},    // true
            {5, 4, 8, 10, 3, 6, 27},    // false
            {6, 2, 16, 5, 7, 10, 33},   // true
            {6, 2, 16, 5, 3, 10, 33},   // false
            {4, 2, 5, 1, 6, 13}         // true
        };

        for (int[] caso : casos) {
            System.out.println(Arrays.toString(caso) + " → " + verificar(caso));
        }
    }

    public static boolean verificar(int[] arr) {
        int n = arr[0], objetivo = arr[arr.length-1];
        int[] nums = Arrays.copyOfRange(arr, 1, arr.length-1);
        int sumaFija = 0;
        List<Integer> opcionales = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (esPotencia2(nums[i])) sumaFija += nums[i];
            else if (!(esMultiplo5(nums[i]) && i < nums.length-1 && nums[i+1]%2 == 1))
                opcionales.add(nums[i]);
        }

        return sumaFija == objetivo || buscar(opcionales, 0, sumaFija, objetivo);
    }

    private static boolean buscar(List<Integer> nums, int i, int suma, int objetivo) {
        if (i >= nums.size()) return suma == objetivo;
        return buscar(nums, i+1, suma + nums.get(i), objetivo) || 
               buscar(nums, i+1, suma, objetivo);
    }

    private static boolean esPotencia2(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }

    private static boolean esMultiplo5(int n) {
        return n % 5 == 0;
    }
}