package ar.edu.unju.fi.pcyp.pto1;

import java.math.BigInteger;

public class HiloFactorial extends Thread{
	private int numero;
	private BigInteger resultado;
	
	//constructor
	public HiloFactorial(int numero) {
		this.numero = numero;
		this.resultado = BigInteger.ONE;
	}

	//el codigo dentro de un run() se ejecuta el paralelismo
	
	public void run() {
		//calculo de factorial utilizando Biginteger para evitar desbordamiento
		for (int i = 1; i <= numero; i++) {
			resultado = resultado.multiply(BigInteger.valueOf(i));
		}
		
	}
	
	//metodo para obtener el resultado para una vez que el hilo termine
	public BigInteger getResultado() {
		return resultado;
	}
	
	public int getNumero() {
		return numero;
	}
}
