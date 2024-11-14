package Ejercicio3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Cliente, que representa a un vegano hambriento. Tiene que implementar la
 * interfaz Runnable. Cada cliente tiene un nombre y un bocata favorito. Los
 * clientes intentan coger un bocata del mostrador de forma ordenada, revisarán si
 * existe un bocata de su preferencia, y lo cogerán. Si no, se queda esperando a
 * que las cocineras avisen. Si encuentran un bocata favorito, se lo comen y avisan
 * a las cocineras para que lo preparen.
 */

public class Cliente implements Runnable{
    // Atributos
    private static Mostrador mostrador; // Mismo mostrador para todos los clientes
    private String nombre; // Nombre del cliente.
    private String tipoFavorito; // Tipo de bocadillo favorito del cliente.

    // Constructor
    public Cliente(String nombre, String tipoFavorito, Mostrador mostrador) {
        this.nombre = nombre;
        this.tipoFavorito = tipoFavorito;
        this.mostrador = mostrador;
    }

    // Getters

    /**
     * Método getter para establecer el mostrador donde quiera pedir el cliente.
     * @return Objeto de tipo 'Mostrador'.
     */
    public static Mostrador getMostrador() {
        return mostrador;
    }

    /**
     * Método getter para obtener el nombre del cliente.
     * @return Devuelve una cadena de texto con el nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método getter para obtener el tipo de bocadillo favorito del cliente.
     * @return Devuelve una cadena de texto con el tipo de bocadillo favorito del cliente.
     */
    public String getTipoFavorito() {
        return tipoFavorito;
    }

    // Setters

    /**
     * Método setter para establecer el mostrador del cliente
     * @param mostrador Objeto de tipo 'Mostrador'.
     */
    public static void setMostrador(Mostrador mostrador) {
        Cliente.mostrador = mostrador;
    }

    /**
     * Método setter para establecer nombre al cliente.
     * @param nombre Cadena de texto que se quiera establecer como nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método setter para establecer el tipo de bocadillo favorito del cliente.
     * @param tipoFavorito Cadena de texto que se quiera establecer como tipo favorito del cliente.
     */
    public void setTipoFavorito(String tipoFavorito) {
        this.tipoFavorito = tipoFavorito;
    }

    /**
     * Método implementado de 'Runnable' para la ejecución de un hilo.
     */
    @Override
    public void run() {
        mostrador.cogerBocata(this);
    }
}
