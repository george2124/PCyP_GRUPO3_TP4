package ar.edu.unju.fi.pcyp.pto7;

public class HiloResta implements Runnable{
	private Contador contador;

	 public HiloResta(String nombre, Contador contador) {
	     this.contador = contador;
	 }

	 public HiloResta(Contador recurso) {
		// TODO Auto-generated constructor stub
	}

	 @Override
	 public void run() {
	     for (int i = 0; i < 100; i++) {
	         contador.restar();
	     }
	 }
}
