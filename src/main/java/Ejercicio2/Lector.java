package Ejercicio2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.locks.ReentrantLock;

public class Lector implements Runnable {
    private File fichero = new File("ficheros\\lorca.txt");
    private int vocal;
    public static int numeroVocales = 0;
    public static int numeroMayusculas = 0;
    /**
     * vocales[0] = vocal A,
     * vocales[1] = vocal E,
     * vocales[2] = vocal I,
     * vocales[3] = vocal O,
     * vocales[4] = vocal U,
     */
    private int[] vocales = new int[5];

    // Necesario un monitor para manejar la zona crítica del programa.
    ReentrantLock monitor = new ReentrantLock();


    public Lector(int vocal) {
        this.vocal = vocal;
    }

    /**
     * Método que lee un fichero y cuenta las vocales que hay.
     */
    private void leerFichero() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fichero));
            String linea;
            while((linea = br.readLine()) != null) {
                String[] palabras = linea.split(" ");
                for (String palabra : palabras) {
                    contarVocales(palabra);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método que cuenta las vocales de una palabra.
     * @param palabra Palabra de la que se quiere contar sus vocales.
     */
    private void contarVocales(String palabra) {
        //  ZONA CRÍTICA DEL PROGRAMA.
        monitor.lock(); // Bloqueamos el monitor cuando un hilo entra al método para que ningún otro hilo pueda acceder a él.
        try {
            char[] letras = palabra.toCharArray();
            for (char letra : letras) {
                if (letra == comprobarVocalMinus()) {
                    vocales[vocal]++;
                    numeroVocales++;
                } else if (letra == comprobarVocalMayus()) {
                    vocales[vocal]++;
                    numeroVocales++;
                    numeroMayusculas++;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            monitor.unlock(); // Para finalizar, desbloqueamos el monitor.
        }

    }

    /**
     * Método que devuelve la letra minúscula con la que estamos trabajando, según el parámetro 'vocal' del constructor.
     * @return Devuelve la letra minúscula con la que estamos trabajando.
     */
    private char comprobarVocalMinus() {
        if (vocal == 0) {
            return 'a';
        } else if (vocal == 1) {
            return 'e';
        } else if (vocal == 2) {
            return 'i';
        } else if (vocal == 3) {
            return 'o';
        } else {
            return 'u';
        }
    }

    /**
     * Método que devuelve la letra mayúscula con la que estamos trabajando, según el parámetro 'vocal' del constructor.
     * @return Devuelve la letra mayúscula con la que estamos trabajando.
     */
    private char comprobarVocalMayus() {
        if (vocal == 0) {
            return 'A';
        } else if (vocal == 1) {
            return 'E';
        } else if (vocal == 2) {
            return 'I';
        } else if (vocal == 3) {
            return 'O';
        } else {
            return 'U';
        }
    }

    /**
     * Método implementado de 'Runnable', que será lo que ejecute nuestro hilo cuando comience.
     */
    @Override
    public void run() {
        leerFichero();
        System.out.println("La " + comprobarVocalMinus() + " aparece: " + vocales[vocal]);
    }
}
