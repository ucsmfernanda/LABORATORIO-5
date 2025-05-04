package actividades;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nSeleccione una opcion:");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Eliminar tarea");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Mostrar tareas pendientes");
            System.out.println("5. Mostrar tareas completadas");
            System.out.println("6. Invertir orden de tareas");
            System.out.println("7. Contar tareas pendientes");
            System.out.println("8. Mostrar tarea de mayor prioridad");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Escribe el nombre de la tarea: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ponga la prioridad de la tarea (numero de prioridad 1 - 5): ");
                    int prioridad = sc.nextInt();
                    sc.nextLine();
                    gestor.agregarTarea(new Tarea(nombre, prioridad));
                    break;
                case 2:
                    System.out.print("Nombre de la tarea a eliminar: ");
                    String eliminarNombre = sc.nextLine();
                    Tarea tareaEliminar = buscarTareaPorNombre(gestor, eliminarNombre);
                    if (tareaEliminar != null && gestor.eliminarTarea(tareaEliminar)) {
                        System.out.println("Tarea eliminada.");
                    } else {
                        System.out.println("Tarea no encontrada.");
                    }
                    break;
                case 3:
                    System.out.print("Nombre de la tarea a completar: ");
                    String completarNombre = sc.nextLine();
                    Tarea tareaCompletar = buscarTareaPorNombre(gestor, completarNombre);
                    if (tareaCompletar != null) {
                        gestor.completarTarea(tareaCompletar);
                        System.out.println("Tarea completada.");
                    } else {
                        System.out.println("Tarea no encontrada.");
                    }
                    break;
                case 4:
                    System.out.println("Tareas pendientes:");
                    gestor.imprimirTareas();
                    break;
                case 5:
                    System.out.println("Tareas completadas:");
                    gestor.mostrarTareasCompletadas();
                    break;
                case 6:
                    gestor.invertirTareas();
                    System.out.println("Tareas invertidas.");
                    break;
                case 7:
                    System.out.println("Cantidad de tareas pendientes: " + gestor.contarTareas());
                    break;
                case 8:
                    Tarea prioritaria = (Tarea) gestor.obtenerTareaMasPrioritaria();
                    if (prioritaria != null) {
                        System.out.println("Tarea de mayor prioridad: " + prioritaria);
                    } else {
                        System.out.println("No hay tareas registradas.");
                    }
                    break;
                case 0:
                    System.out.println("Gestor cerrado.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);

        sc.close();
    }

    // metodo adicional para buscar tarea por nombre
    private static Tarea buscarTareaPorNombre(GestorDeTareas<Tarea> gestor, String nombreBuscado) {
        Nodo<Tarea> actual = gestor.getInicio();
        while (actual != null) {
            if (actual.dato.getNombre().equalsIgnoreCase(nombreBuscado)) {
                return actual.dato;
            }
            actual = actual.siguiente;
        }
        return null;
    }
}