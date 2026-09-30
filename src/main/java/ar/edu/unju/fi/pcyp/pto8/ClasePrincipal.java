package ar.edu.unju.fi.pcyp.pto8;

public class ClasePrincipal {
	 public static void main(String[] args) {
	        System.out.println("Iniciando programa de tablas de multiplicar...");

	        // Objeto único compartido por los 10 hilos
	        CalculadorTablas calculadorCompartido = new CalculadorTablas();
	        
	        // Arreglo para guardar las referencias de los hilos y poder usar .join()
	        Thread[] hilos = new Thread[10];

	        // Creación y arranque de los 10 hilos de forma concurrente
	        for (int i = 0; i < 10; i++) {
	            int numeroTabla = i + 1; // Tablas del 1 al 10
	            hilos[i] = new Thread(new HiloTabla(numeroTabla, calculadorCompartido), "Hilo-Tabla-" + numeroTabla);
	            hilos[i].start(); // Inicia la ejecución concurrente
	        }

	        // Sincronización del hilo principal: Esperar a que terminen los 10 hilos
	        for (int i = 0; i < 10; i++) {
	            try {
	                hilos[i].join(); // El hilo principal se frena hasta que hilos[i] finalice
	            } catch (InterruptedException e) {
	                System.out.println("El hilo principal fue interrumpido.");
	            }
	        }

	        // Este mensaje solo se verá cuando los 10 hilos hayan finalizado por completo
	        System.out.println("PROGRAMA TERMINADO: Todas las tablas han sido procesadas.");
	    }
}
