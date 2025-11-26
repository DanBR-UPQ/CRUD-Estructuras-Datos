import java.util.Scanner;

public class CRUDopciones {
    Scanner teclado = new Scanner(System.in);
    
    public void agregar(CLista lista, CListaLog listaLog){
        
        CJugador jugador = new CJugador();
        int id;

        System.out.println("Ingrese el id: ");
        id = teclado.nextInt();
        teclado.nextLine();

        if (lista.buscarID(id) != null){
            System.out.println("El id ya está ocupado");
        } else{
            System.out.println("El id ingresado es válido");
            jugador.id = id;
            System.out.println("Ingrese el nombre: ");
            jugador.nombre = teclado.nextLine();
            System.out.println("Ingrese el juego: ");
            jugador.juego = teclado.nextLine();
            System.out.println("Ingrese la cantidad de chips: ");
            jugador.chips = teclado.nextInt();
            teclado.nextLine();

            CNodo nodo = new CNodo(jugador);
            lista.addULT(nodo);

            CLog log = new CLog("agregar", id);
            CNodo3 nodoLog = new CNodo3(log);
            listaLog.addULT(nodoLog);
        }
    }


    public void eliminar(CLista lista, CListaLog listaLog){

        if (lista.tamano == 0){
            System.out.println("No hay ningún registro..");
            return;
        }

        System.out.println("Ingrese el Id del usuario a eliminar:");
        int idEliminar = teclado.nextInt();
        teclado.nextLine();

        CNodo nodo = lista.buscarID(idEliminar);

        if(nodo == null){
            System.out.println("No hay jugador con ese id");
        } else {
            lista.eliminar(nodo);
            System.out.println("El registro fue eliminado exitosamente");
            CLog log = new CLog("Eliminar", idEliminar);
            CNodo3 nodoLog = new CNodo3(log);
            listaLog.addULT(nodoLog);
        }

    }


    public void actualizar(CLista lista, CListaLog listaLog){

        if (lista.tamano == 0){
            System.out.println("No hay ningún registro..");
            return;
        }

        System.out.println("Ingrese el Id del usuario a actualizar: ");
        int idActualizar = teclado.nextInt();
        teclado.nextLine();

        CNodo nodo = lista.buscarID(idActualizar);
        
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
                        nodo.jugador.id = opc;
                        System.out.println("id cambiado exitosamente");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el nuevo nombre");
                    nodo.jugador.nombre = teclado.nextLine();
                    System.out.println("nombre cambiado exitosamente");
                    break;
                case 3:
                    System.out.println("Ingrese el nuevo juego");
                    nodo.jugador.juego = teclado.nextLine();
                    System.out.println("juego cambiado exitosamente");
                    break;
                case 4:
                    System.out.println("Ingrese los nuevos chips");
                    nodo.jugador.chips = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("chips cambiados exitosamente");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
            CLog log = new CLog("Actualizar", idActualizar);
            CNodo3 nodoLog = new CNodo3(log);
            listaLog.addULT(nodoLog);
        }

        
    }


    public void imprimir(CPila pila){
        if (pila.tamano == 0) {
            System.out.println("No hay elementos");
        } else {
            pila.peek().imprimir();
            /* System.out.println("tamano de la lista: " + pila.peek().tamano); */
        }
    }


    public CLista duplicar(CLista lista){
        CLista nueva = new CLista();
        CNodo temp = lista.prim;


        while (temp != null) {
            CJugador jug = new CJugador(temp.jugador.id, temp.jugador.nombre, temp.jugador.chips, temp.jugador.juego);
            CNodo nodo = new CNodo(jug);
            nueva.addULT(nodo);
            temp = temp.sig;
        }

        return nueva;
    }





    public void undo(CPila UndoPila, CPila RedoPila){
        if (UndoPila.tamano == 0){
            System.out.println("No hay opciones que deshacer");
        } else {
            RedoPila.push(UndoPila.pop());
            System.out.println("Undo realizado exitosamente");
        }  
    }
    /* TODO: Limpiar el redo después de cada cambio */
    public void redo(CPila UndoPila, CPila RedoPila){
        if (RedoPila.tamano == 0){
            System.out.println("No hay opciones que rehacer");
        } else {
            UndoPila.push(RedoPila.pop());
            System.out.println("Redo realizado exitosamente");
        }  
    }


}
