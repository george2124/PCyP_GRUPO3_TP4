package ar.edu.unju.fi.pcyp.pto8;

public class CalculadorTablas {
	// Método sincronizado: evita que las salidas de consola de diferentes hilos se mezclen
    public synchronized void imprimirTabla(int numero) {
        System.out.println("\n=== TABLA DEL " + numero + " (Calculada por: " + Thread.currentThread().getName() + ") ===");
        
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
            // Agregamos una mínima pausa para simular procesamiento
            try {
                Thread.sleep(50); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("=========================================\n");
    }
}
