package Ejercicio1;

import java.io.File;

public class LauncherPalabras {
    public static void main(String[] args) {
        try {
            ProcessBuilder process = new ProcessBuilder("java", "-jar", "out\\artifacts\\PGVExamenDBNEj1_jar\\PGVExamenDBN.jar");

            process.redirectInput(new File("ficheros\\ResultadosEj1\\palabrasEntrada.txt"));
            process.redirectOutput(new File("ficheros\\ResultadosEj1\\palabrasSalida.txt"));

            process.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
