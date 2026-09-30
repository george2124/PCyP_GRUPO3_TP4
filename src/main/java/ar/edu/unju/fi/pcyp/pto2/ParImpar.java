package ar.edu.unju.fi.pcyp.pto2;

public class ParImpar {

    static class NumerosPares extends Thread {

        @Override
        public void run() {
            

            for (int i = 1; i <= 10; i++) {
                if (i % 2 == 0) {
                    System.out.println("Par: " + i);
                }
            }
        }
    }

    static class NumerosImpares extends Thread {

        @Override
        public void run() {
           

            for (int i = 1; i <= 10; i++) {
                if (i % 2 != 0) {
                    System.out.println("Impar: " + i);
                }
            }
        }
    }

    public static void main(String[] args) {

        NumerosPares pares = new NumerosPares();
        NumerosImpares impares = new NumerosImpares();

        pares.start();
        impares.start();
    }
}