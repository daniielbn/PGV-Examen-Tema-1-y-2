package Ejercicio3;

/**
 * Bocadillo, que representa cada bocata vegano que se prepara. Cada bocata
 * tiene un tipo (hummus, tofu o seitán) y un tamaño (grande o pequeño). Un bocata
 * pequeño tarda 2 segundos en hacerse y en comerse, y uno grande son 5
 * segundos.
 */

public class Bocadillo {
    // Atributos
    private String tipo;
    private boolean tamano; // True cuando sea grande, false cuando sea pequeño.
    private static Mostrador mostrador; // Mismo mostrador para todos los bocatas.

    // Constructor
    public Bocadillo(String tipo, boolean tamano) {
        this.tipo = tipo;
        this.tamano = tamano;
    }

    // Getters

    /**
     * Método getter para obtener el tipo de bocadillo.
     * @return Devuelve una cadena de texto con el tipo del bocadillo.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Método getter para obtener el tamaño de nuestro bocadillo.
     * @return Verdadero si es grande, falso si no lo es
     */
    public boolean getTamano() {
        return tamano;
    }

    // Setters

    /**
     * Método setter para establecer el tipo del bocadillo.
     * @param tipo Cadena de texto que contiene el tipo del bocadillo.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Método setter para establecer el tamaño del bocadillo.
     * @param tamano Verdadero si es grande, falso si es pequeño.
     */
    public void setTamano(boolean tamano) {
        this.tamano = tamano;
    }

    /**
     * Método que imprime un mensaje según el tipo de bocadillo que sea. Además, tiene un tiempo de espera.
     */
    public void hacer() {
        try {
            if (tamano) {
                System.out.println("El bocadillo grande de " + tipo + " se está preparando");
                Thread.sleep(5000);
                System.out.println("El bocadillo grande de " + tipo + " ya se ha terminado de preparar.");
            } else {
                System.out.println("El bocadillo pequeño de " + tipo + " se está preparando");
                Thread.sleep(2000);
                System.out.println("El bocadillo pequeño de " + tipo + " ya se ha terminado de preparar.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Méotod que imprime un mensaje según el tamaño del bocadillo. Además, tiene un tiempo de espera.
     */
    public void comer() {
        try {
            if (tamano) {
                System.out.println("El bocadillo grande de " + tipo + " se está comiendo");
                Thread.sleep(5000);
                System.out.println("El bocadillo grande de " + tipo + " ya se ha terminado de comer.");
            } else {
                System.out.println("El bocadillo pequeño de " + tipo + " se está comiendo");
                Thread.sleep(5000);
                System.out.println("El bocadillo pequeño de " + tipo + " ya se ha terminado de comer.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
