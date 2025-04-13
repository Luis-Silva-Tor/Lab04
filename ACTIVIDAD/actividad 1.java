public class torrehanoi {  // Clase renombrada
    public static void main(String[] args) {
        int numberOfDisks = 3;  // Número de discos
        int sourceTower = 1;    // Torre de origen (torre 1)
        int auxiliaryTower = 2; // Torre auxiliar (torre 2)
        int targetTower = 3;    // Torre destino (torre 3)

        // Llamada al método recursivo
        solveHanoi(numberOfDisks, sourceTower, auxiliaryTower, targetTower);
    }
    /**
     * Método recursivo para resolver el problema de las Torres de Hanoi.
     *
     * @param disks Número de discos a mover.
     * @param source Torre de origen (donde están inicialmente los discos).
     * @param auxiliary Torre auxiliar (para usar como apoyo en el movimiento).
     * @param target Torre destino (donde deben quedar los discos al final).
     */
    public static void solveHanoi(int disks, int source, int auxiliary, int target) {
        if (disks == 1) {
            // Caso base: Si solo hay un disco, moverlo directamente de la torre de origen a la de destino.

            System.out.println("Mover disco de torre " + source + " a torre " + target);
        } else {
        	            // Paso 1: Mover (n-1) discos de la torre de origen a la torre auxiliar, usando la torre destino como auxiliar.
            solveHanoi(disks - 1, source, target, auxiliary);
                        // Paso 2: Mover el disco más grande (que queda en la torre de origen) a la torre destino.

            System.out.println("Mover disco de torre " + source + " a torre " + target);
            solveHanoi(disks - 1, auxiliary, source, target);
                        // Paso 3: Mover los (n-1) discos de la torre auxiliar a la torre destino, usando la torre de origen como auxiliar.
        }
    }
}