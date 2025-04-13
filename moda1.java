public static int moda1(int[] array) {  
    // O(1) - Operación de comparación constante
    if (array.length == 0) {
        throw new IllegalArgumentException("El array no puede estar vacío");
    }
    
    // Todas estas asignaciones son O(1)
    int currentPosition = 0;
    int moda = array[0];  
    int currentFrequency = 1;  
    int maxFrequency = 1;  

    // Bucle principal: O(n) donde n es array.length
    // Se ejecuta n-1 veces (desde i=1 hasta i=array.length-1)
    for (int i = 1; i < array.length; i++) {  
        // O(1) - Comparación y operación aritmética
        if (array[currentPosition] == array[i]) {  
            currentFrequency++;  // O(1)
        }  
        else {  
            // O(1) - Todas estas operaciones son constantes
            if (currentFrequency > maxFrequency) {  
                maxFrequency = currentFrequency;  
                moda = array[currentPosition];  
            }  
            currentPosition = i;  
            currentFrequency = 1;  
        }  
    }
    
    // O(1) - Última comparación y posible asignación
    if (currentFrequency > maxFrequency) {
        moda = array[currentPosition];
    }
    
    return moda;  // O(1)
}