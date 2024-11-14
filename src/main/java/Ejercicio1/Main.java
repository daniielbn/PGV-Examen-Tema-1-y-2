package Ejercicio1;

import java.util.Scanner;

public class Main {
    private static boolean FINALIZAR = false;
    private static int palabrasCortas = 0;
    /**
     * Escribe un programa Java que lea palabras (sólo palabras, no frases) desde la entrada
     * estándar y determine si cada palabra es "corta" (es decir, tiene 5 caracteres o menos).
     * El programa debe imprimir cada palabra seguida de la indicación de si es corta o no. El
     * programa leerá de la entrada estándar hasta leer “fin”. Al final, debe mostrar el número
     * total de palabras cortas encontradas. Luego, escribe un programa que ejecute este
     * programa (tras empaquetarlo en un .jar) usando ProcessBuilder , redirigiendo la entrada
     * desde un archivo y la salida a otro archivo. (2p)
     */

    /**
     * Función que determina si una palabra es corta o no.
     * @param palabra Palabra que se quiere comprobar.
     * @return Verdadero si la palabra contiene 5 letras o menos, falso si es mayor a 5.
     */
    public static boolean contarLetras(String palabra) {
        return palabra.length() <= 5;
    }

    private static boolean comprobarPalabra(String palabra) {
        if (palabra.contains(" ")) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Introduce una palabra para comenzar (Escribir 'fin' para finalizar): ");
        while (!FINALIZAR) {
            String palabra = in.nextLine();
            if (comprobarPalabra(palabra)) {
                if (palabra.toLowerCase().equals("fin")) {
                    FINALIZAR = true;
                    break;
                } else {
                    if (contarLetras(palabra)) {
                        palabrasCortas++;
                        System.out.println("La palabra " + palabra + " es corta.");
                    } else {
                        System.out.println("La palabra " + palabra + " no es corta.");
                    }
                }
            } else {
                System.out.println("Debes introducir una única palabra. Por favor, vuelva a intentarlo: ");
            }
        }
        System.out.println("Se han encontrado un total de " + palabrasCortas + " palabras cortas.");
    }
}
