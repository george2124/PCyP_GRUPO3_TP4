package ar.edu.unju.fi.pcyp.pto6;

public class Comensales {

    static class Mesa {

        private int turno = 0;

        public synchronized void servirse(int numeroComensal) {

            try {
                // Espera hasta que sea el turno de este comensal
                while (turno != numeroComensal) {
                    wait();
                }

                System.out.println("--------------------------------");
                System.out.println("Comensal " + (numeroComensal + 1) + " tiene el cucharon.");
                System.out.println("Comensal " + (numeroComensal + 1) + " se sirve arroz.");
                System.out.println("Comensal " + (numeroComensal + 1) + " termina de servirse.");
                System.out.println("--------------------------------");

                // Pasa el turno al siguiente comensal
                turno++;

                notifyAll();

            } catch (InterruptedException e) {
                System.out.println("El comensal " + (numeroComensal + 1) + " fue interrumpido.");
            }
        }
    }

    static class Comensal extends Thread {

        private int numero;
        private Mesa mesa;

        public Comensal(int numero, Mesa mesa) {
            this.numero = numero;
            this.mesa = mesa;
        }

        @Override
        public void run() {
            mesa.servirse(numero);
        }
    }

    public static void main(String[] args) {

        Mesa mesa = new Mesa();

        Comensal[] comensales = new Comensal[5];

        System.out.println("Comienza la comida.");
        System.out.println();

        // Crear los cinco hilos
        for (int i = 0; i < 5; i++) {
            comensales[i] = new Comensal(i, mesa);
            comensales[i].start();
        }

        // Esperar que terminen los cinco hilos
        for (int i = 0; i < 5; i++) {
            try {
                comensales[i].join();
            } catch (InterruptedException e) {
                System.out.println("El hilo principal fue interrumpido.");
            }
        }

        System.out.println();
        System.out.println("Todos los comensales terminaron de servirse.");
    }
}