package ar.edu.unju.fi.pcyp.pto8;

public class HiloTabla implements Runnable{
	 private int numeroTabla;
	 private CalculadorTablas calculador;

	    // Constructor que recibe el número de la tabla a multiplicar y el objeto sincronizado
	    public HiloTabla(int numeroTabla, CalculadorTablas calculador) {
	        this.numeroTabla = numeroTabla;
	        this.calculador = calculador;
	    }

	    @Override
	    public void run() {
	        // Llama a la función compartida pasando el parámetro correspondiente
	        calculador.imprimirTabla(numeroTabla);
	    }
}
