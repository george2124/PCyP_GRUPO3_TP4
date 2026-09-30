package ar.edu.unju.fi.pcyp.pto4;

import java.util.Random;

public class HiloVector extends Thread {

    private int[] vector;
    private int numeroVector;

    public HiloVector(int tamaño, int numeroVector) {
        this.vector = new int[tamaño];
        this.numeroVector = numeroVector;
    }

    @Override
    public void run() {

        Random random = new Random();

        int suma = 0;
        int sumaCuadrados = 0;

        // Llenamos el vector con números aleatorios
        for (int i = 0; i < vector.length; i++) {
            vector[i] = random.nextInt(10) + 1;
        }

        // Calculamos la suma y la suma de los cuadrados
        for (int i = 0; i < vector.length; i++) {
            suma = suma + vector[i];
            sumaCuadrados = sumaCuadrados + (vector[i] * vector[i]);
        }

        // Calculamos la media
        double media = (double) suma / vector.length;

        // Mostramos los resultados
        System.out.println();
        System.out.println("======================================");
        System.out.println("           VECTOR " + numeroVector);
        System.out.println("======================================");

        System.out.print("Elementos: ");

        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i]);

            if (i < vector.length - 1) {
                System.out.print(" - ");
            }
        }

        System.out.println();
        System.out.println("Cantidad de elementos: " + vector.length);
        System.out.println("Suma de los elementos: " + suma);
        System.out.println("Suma de los cuadrados: " + sumaCuadrados);
        System.out.println("Media: " + media);
        System.out.println("======================================");
    }

    public static void main(String[] args) {

        // Se crean dos vectores con diferente tamaño
    	HiloVector vector1 = new HiloVector(5, 1);
    	HiloVector vector2 = new HiloVector(8, 2);

        // Se ejecuta el primer hilo
        vector1.start();

        try {
            vector1.join();
        } catch (InterruptedException e) {
            System.out.println("Se interrumpió el hilo del vector 1.");
        }

        // Se ejecuta el segundo hilo
        vector2.start();

        try {
            vector2.join();
        } catch (InterruptedException e) {
            System.out.println("Se interrumpió el hilo del vector 2.");
        }

        System.out.println();
        System.out.println("Los dos vectores fueron procesados correctamente.");
    }
}