package app;
import java.util.Scanner;
import model.LogEntry;
import model.Player;
import structures.list.LinkedList;
import structures.list.ListNode;
import structures.log.LogList;
import structures.log.LogNode;
import structures.stack.Stack;

public class CRUDService {
    Scanner teclado = new Scanner(System.in);
    
    public void agregar(LinkedList lista, LogList listaLog){
        
        Player jugador = new Player();
        int id;

        System.out.println("Ingrese el id: ");
        id = teclado.nextInt();
        teclado.nextLine();

        if (lista.buscarID(id) != null){
            System.out.println("El id ya está ocupado");
        } else{
            System.out.println("El id ingresado es válido");
            jugador.setId(id);
            System.out.println("Ingrese el nombre: ");
            jugador.setNombre(teclado.nextLine());
            System.out.println("Ingrese el juego: ");
            jugador.setJuego(teclado.nextLine());
            System.out.println("Ingrese la cantidad de chips: ");
            jugador.setChips(teclado.nextInt());
            teclado.nextLine();

            ListNode nodo = new ListNode(jugador);
            lista.addULT(nodo);

            LogEntry log = new LogEntry("agregar", id);
            LogNode nodoLog = new LogNode(log);
            listaLog.addULT(nodoLog);
        }
    }


    public void eliminar(LinkedList lista, LogList listaLog){

        if (lista.getSize() == 0){
            System.out.println("No hay ningún registro..");
            return;
        }

        System.out.println("Ingrese el Id del usuario a eliminar:");
        int idEliminar = teclado.nextInt();
        teclado.nextLine();

        ListNode nodo = lista.buscarID(idEliminar);

        if(nodo == null){
            System.out.println("No hay jugador con ese id");
        } else {
            lista.eliminar(nodo);
            System.out.println("El registro fue eliminado exitosamente");

            LogEntry log = new LogEntry("Eliminar", idEliminar);
            LogNode nodoLog = new LogNode(log);
            listaLog.addULT(nodoLog);
        }

    }


    public void actualizar(LinkedList lista, LogList listaLog){

        if (lista.getSize() == 0){
            System.out.println("No hay ningún registro..");
            return;
        }

        System.out.println("Ingrese el Id del usuario a actualizar: ");
        int idActualizar = teclado.nextInt();
        teclado.nextLine();

        ListNode nodo = lista.buscarID(idActualizar);
        
        if(nodo == null){
            System.out.println("No hay jugador con ese id");
        } else {
           
            System.out.println("Ingrese el dato que desea cambiar");
            System.out.println("1. Cambiar ID \n2. Cambiar Nombre \n3. Cambiar Juego \n4. Cambiar la cantidad de Chips");
            int opc = teclado.nextInt();
            teclado.nextLine();

            switch (opc) {      
                case 1 :
                    System.out.println("Ingrese el nuevo id: ");
                    opc = teclado.nextInt();
                    teclado.nextLine();

                    if(lista.buscarID(opc) != null){
                        System.out.println("El ID ya existe");
                    } else{
                        nodo.getJugador().setId(opc);
                        System.out.println("id cambiado exitosamente");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el nuevo nombre");
                    nodo.getJugador().setNombre(teclado.nextLine());
                    System.out.println("nombre cambiado exitosamente");
                    break;
                case 3:
                    System.out.println("Ingrese el nuevo juego");
                    nodo.getJugador().setJuego(teclado.nextLine());
                    System.out.println("juego cambiado exitosamente");
                    break;
                case 4:
                    System.out.println("Ingrese los nuevos chips");
                    nodo.getJugador().setChips(teclado.nextInt());
                    teclado.nextLine();
                    System.out.println("chips cambiados exitosamente");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

            LogEntry log = new LogEntry("Actualizar", idActualizar);
            LogNode nodoLog = new LogNode(log);
            listaLog.addULT(nodoLog);
        }

        
    }


    public void imprimir(Stack pila){
        if (pila.getSize() == 0) {
            System.out.println("No hay elementos");
        } else {
            pila.peek().imprimir();
            /* lista.imprimir() */
            /* System.out.println("tamano de la lista: " + pila.peek().tamano); */
        }
    }


    public LinkedList duplicar(LinkedList lista){
        LinkedList nueva = new LinkedList();
        ListNode temp = lista.getPrim();


        while (temp != null) {
            Player jug = new Player(temp.getJugador().getId(), 
                                    temp.getJugador().getNombre(), 
                                    temp.getJugador().getChips(), 
                                    temp.getJugador().getJuego());
            ListNode nodo = new ListNode(jug);
            nueva.addULT(nodo);
            temp = temp.getSig();
        }

        return nueva;
    }





    public void undo(Stack UndoPila, Stack RedoPila){
        if (UndoPila.getSize() == 0){
            System.out.println("No hay opciones que deshacer");
        } else {
            RedoPila.push(UndoPila.pop());
            System.out.println("Undo realizado exitosamente");
        }  
    }
    public void redo(Stack UndoPila, Stack RedoPila){
        if (RedoPila.getSize() == 0){
            System.out.println("No hay opciones que rehacer");
        } else {
            UndoPila.push(RedoPila.pop());
            System.out.println("Redo realizado exitosamente");
        }  
    }


}
