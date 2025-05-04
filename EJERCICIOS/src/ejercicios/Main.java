package ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // para buscar un elemento en una lista
        List<String> lista = new ArrayList<>();
        lista.add("Maria");
        lista.add("Fernanda");
        boolean encontrado = MetodosGenericos.buscarElemento(lista, "Fernanda");
        System.out.println("¿Tiene el elemento 'Fernanda'? " + encontrado); // verdadero

        // para invertir una lista
        List<String> invertida = MetodosGenericos.invertirLista(lista);
        System.out.println("Lista invertida: " + invertida);

        // para insertar al final de una lista enlazada
        Nodo<Double> listaDoubles = new Nodo<>(1.5);
        listaDoubles = MetodosGenericos.insertarAlFinal(listaDoubles, 2.5);
        listaDoubles = MetodosGenericos.insertarAlFinal(listaDoubles, 3.5);
        System.out.print("Lista enlazada de doubles: ");
        imprimirLista(listaDoubles);

        // para contar los nodos de la lista enlazada
        int cantidad = MetodosGenericos.contarNodos(listaDoubles);
        System.out.println("Cantidad de nodos: " + cantidad);

        // para comparar dos listas enlazadas
        Nodo<Integer> listaEnteros1 = new Nodo<>(1);
        listaEnteros1 = MetodosGenericos.insertarAlFinal(listaEnteros1, 2);
        listaEnteros1 = MetodosGenericos.insertarAlFinal(listaEnteros1, 3);

        Nodo<Integer> listaEnteros2 = new Nodo<>(1);
        listaEnteros2 = MetodosGenericos.insertarAlFinal(listaEnteros2, 2);
        listaEnteros2 = MetodosGenericos.insertarAlFinal(listaEnteros2, 4);

        boolean iguales = MetodosGenericos.sonIguales(listaEnteros1, listaEnteros2);
        System.out.println("¿Las listas son iguales? " + iguales); // falso

        // para concatenar dos listas enlazadas
        Nodo<Integer> listaExtra = new Nodo<>(4);
        listaExtra = MetodosGenericos.insertarAlFinal(listaExtra, 5);
        Nodo<Integer> concatenada = MetodosGenericos.concatenarListas(listaEnteros1, listaExtra);
        System.out.print("Lista concatenada: ");
        imprimirLista(concatenada);
    }

    // metodo auxiliar para imprimir listas enlazadas
    public static <T> void imprimirLista(Nodo<T> head) {
        Nodo<T> actual = head;
        while (actual != null) {
            System.out.print(actual.dato + " - ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }
}
