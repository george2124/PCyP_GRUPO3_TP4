package ar.edu.unju.fi.pcyp.pto7;

public class Contador {
	    private int h = 0; // Variable global h

	    // Método sincronizado para sumar
	    public synchronized void sumar() {
	        h++;
	        System.out.println(Thread.currentThread().getName() + " sumó. Valor de h = " + h);
	        notifyAll(); // Despierta a los hilos que están esperando a que h sea mayor a 0
	    }

	    // Método sincronizado para restar
	    public synchronized void restar() {
	        // Regla: h no puede ser negativa. Si es 0, el hilo espera.
	        while (h == 0) {
	            try {
	                System.out.println(Thread.currentThread().getName() + " espera porque h es 0.");
	                wait(); // Libera el candado y espera
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	        }
	        h--;
	        System.out.println(Thread.currentThread().getName() + " restó. Valor de h = " + h);
	    }

}
