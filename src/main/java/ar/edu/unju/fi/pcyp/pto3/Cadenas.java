package ar.edu.unju.fi.pcyp.pto3;

import java.util.Scanner;

public class Cadenas {

    static class HiloCadena extends Thread {

        private String cadena;
        private String nombre;

        public HiloCadena(String cadena, String nombre) {
            this.cadena = cadena;
            this.nombre = nombre;
        }

        @Override
        public void run() {
            System.out.println("\n" + nombre + ":");

            for (int i = 0; i < cadena.length(); i++) {
                System.out.println(cadena.charAt(i));
            }
        }
    }

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese la primera cadena: ");
        String cadena1 = teclado.nextLine();

        System.out.print("Ingrese la segunda cadena: ");
        String cadena2 = teclado.nextLine();

        HiloCadena hilo1 = new HiloCadena(cadena1, "Primera cadena");
        HiloCadena hilo2 = new HiloCadena(cadena2, "Segunda cadena");

        hilo1.start();
        hilo2.start();

        teclado.close();
    }
}