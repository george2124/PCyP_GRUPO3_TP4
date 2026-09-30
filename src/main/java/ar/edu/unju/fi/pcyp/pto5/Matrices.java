package ar.edu.unju.fi.pcyp.pto5;

public class Matrices {

    // Método sincronizado para imprimir una matriz
    public static synchronized void imprimirMatriz(int[][] matriz, String nombre) {

        System.out.println();
        System.out.println("===== " + nombre + " =====");

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }

            System.out.println();
        }

        System.out.println("======================");
    }

    // Hilo que se encarga de una matriz
    static class HiloMatriz extends Thread {

        private int[][] matriz;
        private String nombre;

        public HiloMatriz(int[][] matriz, String nombre) {
            this.matriz = matriz;
            this.nombre = nombre;
        }

        @Override
        public void run() {
            imprimirMatriz(matriz, nombre);
        }
    }

    public static void main(String[] args) {

        int[][] matriz1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] matriz2 = {
            {10, 11, 12},
            {13, 14, 15},
            {16, 17, 18}
        };

        int[][] matriz3 = {
            {19, 20, 21},
            {22, 23, 24},
            {25, 26, 27}
        };

        HiloMatriz hilo1 = new HiloMatriz(matriz1, "Matriz 1");
        HiloMatriz hilo2 = new HiloMatriz(matriz2, "Matriz 2");
        HiloMatriz hilo3 = new HiloMatriz(matriz3, "Matriz 3");

        hilo1.start();
        hilo2.start();
        hilo3.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            System.out.println("Se interrumpió un hilo.");
        }

        System.out.println();
        System.out.println("Las tres matrices fueron mostradas correctamente.");
    }
}