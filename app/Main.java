package app;
import java.util.Scanner;
import structures.list.LinkedList;
import structures.log.LogList;
import structures.stack.Stack;
import structures.stack.StackNode;

public class Main {

    

    public static void main(String[] args) {
        Stack UndoPila = new Stack();
        Stack RedoPila = new Stack();
        LogList listaLog = new LogList();

        LinkedList lista = new LinkedList();
        CRUDService opcion = new CRUDService();


        Scanner teclado = new Scanner(System.in);
        boolean continuar = true, esOpcion;
        int seleccion = 0;



        TestDataLoader.agregarDatos(lista, listaLog, UndoPila);



        System.out.println("Bienvenido al sistema de manejo de activos");

        while(continuar){

            System.out.println("\nMenu Principal \n--------  ACTIVOS  --------");
            System.out.println("1. Agregar          \t5. Rehacer");
            System.out.println("2. Eliminar         \t6. Log");
            System.out.println("3. Actualizar       \t7. Imprimir");
            System.out.println("4. Deshacer         \t8. Salir");
            esOpcion = false;
            
            while (!esOpcion) { 
                System.out.print("Ingrese una opción: ");
                seleccion = teclado.nextInt();
                if(seleccion > 8 || seleccion < 1){
                    System.out.println("Opcion invalida. Intente de nuevo..\n");
                } else{
                    esOpcion = true;
                }
            }

            System.out.println("\n----------------------------");
            switch(seleccion){
                case 1: {
                    LinkedList nueva = opcion.duplicar(lista);
                    opcion.agregar(nueva, listaLog);
                    StackNode nodo = new StackNode(nueva);
                    UndoPila.push(nodo);
                    RedoPila.borrar();
                    break;
                }
                case 2: {
                    LinkedList nueva = opcion.duplicar(lista);
                    opcion.eliminar(nueva, listaLog);
                    StackNode nodo = new StackNode(nueva);
                    UndoPila.push(nodo);
                    RedoPila.borrar();
                    break;
                }
                case 3: {
                    LinkedList nueva = opcion.duplicar(lista);
                    opcion.actualizar(nueva, listaLog);
                    StackNode nodo = new StackNode(nueva);
                    UndoPila.push(nodo);
                    RedoPila.borrar();
                    break;
                }
                case 4:
                    opcion.undo(UndoPila, RedoPila);
                    break;
                case 5:
                    opcion.redo(UndoPila, RedoPila);
                    break;
                case 6:
                    listaLog.imprimir();
                    break;
                case 7:
                    opcion.imprimir(UndoPila);
                    break;
                case 8:
                    System.out.println("Gracias por usar el sistema de manejo de activos");
                    continuar = false;
            }
            System.out.println("----------------------------\n");

            
            if(UndoPila.peek() == null) {
                lista = new LinkedList();
            } else {
                lista = UndoPila.peek();
            }
            
        }
        teclado.close();
    }
}
