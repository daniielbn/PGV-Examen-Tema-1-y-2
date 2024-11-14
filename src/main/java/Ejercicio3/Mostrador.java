package Ejercicio3;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Mostrador, que representa el mostrador donde se ponen los bocatas y los
 * clientes lo recogen. Sólo caben 5 bocatas. Hay que implementar estos métodos:
 *      i. boolean cogerBocata(Cliente c), que permite que un cliente coja un
 *      bocata del mostrador.Si hay bocatas, el cliente buscará que haya en el
 *      mostrador de su gusto, y lo cogerá, devolviendo true. Si no hay de su
 *      gusto, devolverá falso.
 *      ii. Public void ponerBocata(Bocadillo nuevoBocata, Cocinera c), que
 *      permite que la cocinera pueda añadir un bocata al mostrador siempre que
 *      haya espacio y haya veganos hambrientos.
 */

public class Mostrador {
    // Atributos
    private static final int NUMERO_BOCADILLOS_MAXIMOS = 5; // Número máximo de bocadillos en el mostrador.
    private int contadorBocadillos = 0; // Número de bocadillos actuales.
    ArrayList<Bocadillo> bocadillos = new ArrayList<>(); // ArrayList que contiene todos los bocadillos.

    ReentrantLock monitor = new ReentrantLock(); // Monitor que controla las entradas y salidas a nuestras zonas críticas.
    Condition colaClientes = monitor.newCondition(); // Crea una cola para los clientes.
    Condition colaCocineras = monitor.newCondition(); // Crea una cola para las cocineras.

    /**
     * Método getter para obtener el ArrayList de todos los bocadillos que hay en el mostrador.
     * @return Devuelve un ArrayList que contiene todos los bocadillos.
     */
    public ArrayList<Bocadillo> getBocadillos() {
        return bocadillos;
    }

    /**
     * Método que utilizan los clientes para coger un bocadillo del mostrador. Este comprueba si hay bocadillos suficientes, y si hay bocadillos del tipo favorito
     * del cliente. En caso de que se cumpla, elimina el bocadillo de la lista, y llama a las cocineras y clientes siguientes.
     * @param cliente Cliente que quiere coger el bocadillo.
     * @return Devuelve verdadero si se coge un bocadillo, falso si no se hace.
     */
    public boolean cogerBocata(Cliente cliente) {
        monitor.lock();
        try {
            while (contadorBocadillos <= 0) {
                colaClientes.await();
            }
            for (Bocadillo bocadillo : bocadillos) {
                if (bocadillo.getTipo().equals(cliente.getTipoFavorito())) {
                    System.out.println("El cliente " + cliente.getNombre() + " ha cogido un bocadillo de " + bocadillo.getTipo());
                    bocadillos.remove(bocadillo);
                    bocadillo.comer();
                    contadorBocadillos--;
                    colaClientes.signalAll();
                    colaCocineras.signalAll();
                    return true;
                } else {
                    System.out.println("No hay bocadillos de " + cliente.getTipoFavorito());
                    colaClientes.await();
                }
            }
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            monitor.unlock();
        }
    }

    /**
     * Método que usan las Cocineras para poner un bocadillo en el mostrador. Primero, se comprueba que no haya más bocadillos que los que puede haber. Luego,
     * crea el bocadillo y lo añade al ArrayList.
     * @param nuevoBocata Nuevo bocadillo que se quiere poner en el mostrador.
     * @param cocinera Cocinera que ha hecho el bocadillo.
     */
    public void ponerBocata(Bocadillo nuevoBocata, Cocinera cocinera) {
        monitor.lock();
        try {
            while (contadorBocadillos >= NUMERO_BOCADILLOS_MAXIMOS) {
                colaCocineras.await();
            }
            System.out.println("La cocinera " + cocinera.getNombre() + " ha hecho un bocadillo de " + nuevoBocata.getTipo());
            nuevoBocata.hacer();
            bocadillos.add(nuevoBocata);
            contadorBocadillos++;
            colaClientes.signalAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            monitor.unlock();
        }
    }
}
