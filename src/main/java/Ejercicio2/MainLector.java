package Ejercicio2;

import java.util.ArrayList;

public class MainLector {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Lector> vocales = new ArrayList<>();
        ArrayList<Thread> hilosVocales = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            vocales.add(new Lector(i));
        }

        for (Lector vocal: vocales) {
            hilosVocales.add(new Thread(vocal));
        }

        for (Thread hilo : hilosVocales) {
            hilo.start();
        }

        for (Thread hilo : hilosVocales) {
            hilo.join();
        }

        System.out.println("Total de vocales: " + Lector.numeroVocales);
        System.out.println("Total de vocales en mayúsculas: " + Lector.numeroMayusculas);

    }
}
