package Prog2tareas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Nodo {
    int valor;
    List<Nodo> conexiones;

    public Nodo(int valor) {
        this.valor = valor;
        this.conexiones = new ArrayList<>();
    }

    public void agregarConexion(Nodo nodo) {
        conexiones.add(nodo);
    }

    public int cantidadConexiones() {
        return conexiones.size();
    }

    @Override
    public String toString() {
        return "Nodo{" + "valor=" + valor + ", conexiones=" + conexiones.size() + '}';
    }
}

class Grafo {
    Map<Integer, Nodo> nodos;

    public Grafo() {
        this.nodos = new HashMap<>();
    }

    public Nodo agregarNodo(int valor) {
        Nodo nodo = new Nodo(valor);
        nodos.put(valor, nodo);
        return nodo;
    }

    public Nodo obtenerNodo(int valor) {
        return nodos.get(valor);
    }

    public void conectarNodos(int valorOrigen, int valorDestino) {
        Nodo nodoOrigen = obtenerNodo(valorOrigen);
        Nodo nodoDestino = obtenerNodo(valorDestino);
        if (nodoOrigen != null && nodoDestino != null) {
            nodoOrigen.agregarConexion(nodoDestino);
        }
    }

    public void mostrarGrafo() {
        for (Nodo nodo : nodos.values()) {
            System.out.println(nodo);
        }
    }
}

class CreacionDeGrafo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Grafo grafo = new Grafo();

        System.out.println("Crear nodos en el grafo. Ingrese -1 para terminar.");
        while (true) {
            System.out.print("Ingrese el valor para el nodo: ");
            int valor = sc.nextInt();
            if (valor == -1) break;

            grafo.agregarNodo(valor);
        }

        System.out.println("Conectar nodos en el grafo.");
        for (Nodo nodo : grafo.nodos.values()) {
            System.out.println("Nodo actual: " + nodo.valor);
            System.out.print("Cantidad de conexiones con otros nodos: ");
            int cantidad = sc.nextInt();

            for (int i = 0; i < cantidad; i++) {
                System.out.print("Ingrese el valor del nodo a conectar con " + nodo.valor + ": ");
                int valorConexion = sc.nextInt();
                Nodo conexion = grafo.obtenerNodo(valorConexion);

                if (conexion != null) {
                    nodo.agregarConexion(conexion);
                    System.out.println("Nodo " + nodo.valor + " conectado con Nodo " + conexion.valor);
                } else {
                    System.out.println("Nodo con valor " + valorConexion + " no existe.");
                }
            }
        }
        System.out.println("\nEstructura del grafo:");
        grafo.mostrarGrafo();
    }
}

