package actividades;

import java.util.ArrayList;
import java.util.List;

public class GestorDeTareas<T> {
    private Nodo<T> inicio = null;
    private List<T> tareasTerminadas = new ArrayList<>();

    // agrega una nueva tarea al final de la lista
    public void agregarTarea(T tarea) {
        Nodo<T> nuevo = new Nodo<>(tarea);
        if (inicio == null) {
            inicio = nuevo; // si esta vacio se vuelve el primero
        } else {
            Nodo<T> actual = inicio;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo; // se enlaza al final
        }
    }

    // elimina una tarea de la lista
    public boolean eliminarTarea(T tarea) {
        if (inicio == null) return false; // lista vacia
        
        if (inicio.dato.equals(tarea)) {
            inicio = inicio.siguiente; // borra el primer nodo
            return true;
        }
        
        Nodo<T> actual = inicio;
        while (actual.siguiente != null && !actual.siguiente.dato.equals(tarea)) {
            actual = actual.siguiente;
        }
        
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente; // pasa el nodo a eliminar
            return true;
        }
        
        return false; // no hay nada
    }

    // verifica si existe la tarea
    public boolean contieneTarea(T tarea) {
        Nodo<T> actual = inicio;
        while (actual != null) {
            if (actual.dato.equals(tarea)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    // imprime las tareas pendientes
    public void imprimirTareas() {
        Nodo<T> actual = inicio;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }

    // cuenta las tareas que hay en la lista
    public int contarTareas() {
        int contador = 0;
        Nodo<T> actual = inicio;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }

    // da la tarea de mayor prioridad
    public T obtenerTareaMasPrioritaria() {
        if (inicio == null) return null;
        
        Nodo<T> actual = inicio;
        T tareaMasPrioritaria = actual.dato;
        
        while (actual != null) {
            if (actual.dato instanceof Tarea) {
                Tarea actualTarea = (Tarea) actual.dato;
                Tarea mejorTarea = (Tarea) tareaMasPrioritaria;
                
                if (actualTarea.getPrioridad() > mejorTarea.getPrioridad()) {
                    tareaMasPrioritaria = actual.dato; // pone la de mayor prioridad
                }
            }
            actual = actual.siguiente;
        }
        
        return tareaMasPrioritaria;
    }

    // invierte el orden de la lista de tareas
    public void invertirTareas() {
        Nodo<T> anterior = null;
        Nodo<T> actual = inicio;
        while (actual != null) {
            Nodo<T> siguiente = actual.siguiente;
            actual.siguiente = anterior; // invierte 
            anterior = actual;
            actual = siguiente;
        }
        inicio = anterior; // nuevo inicio es el ultimo
    }

    // marca una tarea como completada  y la guarda en otra lista
    public void completarTarea(T tarea) {
        if (eliminarTarea(tarea)) {
            tareasTerminadas.add(tarea);
        }
    }

    // muestra todas las tareas que estan completas
    public void mostrarTareasCompletadas() {
        for (T tarea : tareasTerminadas) {
            System.out.println(tarea);
        }
    }

    // nos da el nodo inicial de la lista
    public Nodo<T> getInicio() {
        return inicio;
    }
}
