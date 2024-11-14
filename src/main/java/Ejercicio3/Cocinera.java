package Ejercicio3;

import java.util.Random;

/**
 * Cocinera, que representa a las cocineras de la cafetería. También implementa la
 * interfaz Runnable. Cada cocinera tiene un nombre, y se encarga de hacer
 * bocatas y ponerlos en el mostrador. Cuando lo hacen, avisan al resto de clientes.
 */

public class Cocinera implements Runnable {
    // Atributos
    private String nombre; // Nombre de cocinera.
    private static Mostrador mostrador; // Mostrador

    // Constructor
    public Cocinera(String nombre, Mostrador mostrador) {
        this.nombre = nombre;
        this.mostrador = mostrador;
    }

    // Getters

    /**
     * Método getter para obtener el nombre de la cocinera.
     * @return Devuelve una cadena de texto con el nombre de la cocinera.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método getter para obtener el mostrador con el que trabaja la cocinera.
     * @return Devuelve un objeto de tipo 'Mostrador'.
     */
    public static Mostrador getMostrador() {
        return mostrador;
    }

    // Setters

    /**
     * Método setter para establecer el nombre de la cocinera.
     * @param nombre Cadena de texto con el valor del nombre de la cocinera.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método setter para establecer el mostrador con el que trabaja la cocinera.
     * @param mostrador Objeto de tipo 'Mostrador'.
     */
    public static void setMostrador(Mostrador mostrador) {
        Cocinera.mostrador = mostrador;
    }

    /**
     * Método que sirve para crear un nuevo objeto de la clase 'Bocadillo'. Se genera de manera aleatorio.
     * @return Devuevle el bocadillo creado.
     */
    private Bocadillo hacerBocata() {
        Random random = new Random();
        return new Bocadillo(establecerTipo(random.nextInt(3)), random.nextBoolean());
    }

    /**
     * Método que establecer el tipo de bocadillo según el número aleatorio generado.
     * @param numero Número aleatorio generado anteriomente.
     * @return Devuelve la cadena de texto con el tipo de bocadillos.
     */
    private String establecerTipo(int numero) {
        if (numero == 0) {
            return "hummus";
        } else if (numero == 1) {
            return "tofu";
        } else {
            return "seitan";
        }
    }

    /**
     * Método implementado de 'Runnable' para la ejecución de un hilo.
     */
    @Override
    public void run() {
        while (true) {
            mostrador.ponerBocata(hacerBocata(), this);
        }
    }
}
