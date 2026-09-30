package ar.edu.unju.fi.pcyp.pto7;

public class HiloSuma implements Runnable {
	private Contador contador;

	 public HiloSuma(Contador contador) {
	     this.contador = contador;
	 }

	 @Override
	 public void run() {
	     for (int i = 0; i < 100; i++) {
	         contador.sumar();
	     }
	 }
}
