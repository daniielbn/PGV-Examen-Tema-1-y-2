package Ejercicio3;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static String comprobarTipo(int numero) {
        if (numero == 0) {
            return "hummus";
        } else if (numero == 1) {
            return "tofu";
        } else {
            return "seitan";
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Cocinera> cocineras = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        Mostrador mostrador = new Mostrador();
        ArrayList<Thread> hiloCocineras = new ArrayList<>();
        ArrayList<Thread> hiloClientes = new ArrayList<>();

        for (int i = 0; i <= 5; i++) {
            cocineras.add(new Cocinera(i + "", mostrador));
        }

        for (int i = 0; i <= 10; i++) {
            Random random = new Random();
            clientes.add(new Cliente(i + "", comprobarTipo(random.nextInt(3)), mostrador));
        }

        for (Cocinera cocinera : cocineras) {
            hiloCocineras.add(new Thread(cocinera));
        }

        for (Cliente cliente : clientes) {
            hiloClientes.add(new Thread(cliente));
        }

        for (Thread hilo : hiloClientes) {
            hilo.start();
        }

        for (Thread hilo : hiloCocineras) {
            hilo.start();
        }

        for (Thread hilo : hiloClientes) {
            hilo.join();
        }

        for (Thread hilo : hiloCocineras) {
            hilo.join();
        }

    }
}
