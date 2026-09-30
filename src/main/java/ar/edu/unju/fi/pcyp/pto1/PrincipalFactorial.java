package ar.edu.unju.fi.pcyp.pto1;

public class PrincipalFactorial {
	public static void main(String [] args) {
		//definimos dos numero de pruebas 
		int num1 = 17;
		int num2 = 14;
		
		//ejecutamos el proceso tres veces consecutuivas
		for(int i = 1; i <= 3; i++) {
			System.out.println("****ejecucion numero "+ i +" ****");
			ejecutarCalculo(num1,num2);
			System.out.println();
		}
	}
		
		private static void ejecutarCalculo(int n1, int n2) {
			HiloFactorial hilo1 = new HiloFactorial(n1);
			HiloFactorial hilo2 = new HiloFactorial(n2);
			
			//inicial los hilos en paralelos
			hilo1.start();
			hilo2.start();
			
			try {
		           // El hilo principal (main) espera a que ambos hilos terminen
		           hilo1.join();
		           hilo2.join();
		       } catch (InterruptedException e) {
	            System.out.println("La ejecución fue interrumpida.");
	        }
			
			  // Mostrar los resultados en la consola
	        System.out.println("Resultado Hilo 1 -> Factorial de " + hilo1.getNumero() + " es: " + hilo1.getResultado());
	        System.out.println("Resultado Hilo 2 -> Factorial de " + hilo2.getNumero() + " es: " + hilo2.getResultado());
	    
	        System.out.println("hola estoy subiendo cambios");
	        
		}
		
		

}
