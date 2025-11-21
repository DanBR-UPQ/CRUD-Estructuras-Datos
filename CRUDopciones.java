import java.util.Scanner;

public class CRUDopciones {
    Scanner teclado = new Scanner(System.in);
    
    public void agregar(CLista lista){
        
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
        }
    }


    public void eliminar(CLista lista){

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
        }

    }


    public void actualizar(CLista lista){

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
        }

        
    }


    public void imprimir(CLista lista){
        lista.imprimir();
    }


}
