package ejercicios;

import java.util.ArrayList;
import java.util.List;

public class MetodosGenericos {

    // metodo que busca un elemento en una lista 
    public static <T> boolean buscarElemento(List<T> lista, T valor) {
        for (T elemento : lista) {
            if (elemento.equals(valor)) {
                return true; // si lo encuentra devuelve true
            }
        }
        return false; // si no lo encuentra devuelve false
    }

    // metodo que invierte una lista y devuelve una nueva
    public static <T> List<T> invertirLista(List<T> lista) {
        List<T> invertida = new ArrayList<>();
        // recorre la lista desde el final hacia el inicio
        for (int i = lista.size() - 1; i >= 0; i--) {
            invertida.add(lista.get(i));
        }
        return invertida;
    }

    // metodo que inserta un nuevo nodo al final de una lista enlazada
    public static <T> Nodo<T> insertarAlFinal(Nodo<T> head, T valor) {
        Nodo<T> nuevo = new Nodo<>(valor); // se crea un nuevo nodo
        if (head == null) return nuevo; // si la lista esta vacía el nuevo es la cabeza

        Nodo<T> actual = head;
        // recorre hasta el ultimo nodo
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = nuevo; // enlaza el nuevo nodo al final
        return head;
    }

    // metodo que cuenta la cantidad de nodos en una lista enlazada
    public static <T> int contarNodos(Nodo<T> head) {
        int contador = 0;
        Nodo<T> actual = head;
        // recorre toda la lista sumando 1 por cada nodo
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    // metodo que compara dos listas enlazadas para saber si son iguales
    public static <T> boolean sonIguales(Nodo<T> l1, Nodo<T> l2) {
        while (l1 != null && l2 != null) {
            if (!l1.dato.equals(l2.dato)) {
                return false; // si no coincide, devuelve false
            }
            l1 = l1.siguiente;
            l2 = l2.siguiente;
        }
        // las listas son iguales si ambas llegaron al final
        return l1 == null && l2 == null;
    }

    // metodo que concatena dos listas enlazadas
    public static <T> Nodo<T> concatenarListas(Nodo<T> l1, Nodo<T> l2) {
        if (l1 == null) return l2; // si la primera lista esta vacia, devuelve la segunda

        Nodo<T> actual = l1;
        // recorre hasta el final de la primera lista
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = l2; // enlaza la segunda lista al final de la primera
        return l1;
    }
}
