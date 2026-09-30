package ar.edu.unju.fi.pcyp.pto7;

public class ClasePrincipalPto7 {
	public static void main(String[] args) {
	     Contador recurso = new Contador();

	   

	     for (int i = 0; i <= 5; i++) {
	        Thread sumadores = new Thread(new HiloSuma(recurso),"Sumador-" + i );
	        Thread restadores = new Thread(new HiloResta(recurso),"Restador-" + i );
	        
	        sumadores.start();
	        restadores.start();
	     }
	    
	 }
}

//Recurso compartido controlado (Monitor)



