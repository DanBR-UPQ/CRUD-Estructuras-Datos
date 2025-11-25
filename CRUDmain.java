import java.util.Scanner;

public class CRUDmain {

    

    public static void main(String[] args) {
        CPila UndoPila = new CPila();
        CPila RedoPila = new CPila();


        Scanner teclado = new Scanner(System.in);
        boolean continuar = true, esOpcion;
        int seleccion = 0;

        CLista lista = new CLista();
        CRUDopciones opcion = new CRUDopciones();

        System.out.println("Bienvenido al sistema CRUDJugadores");

        while(continuar){

            System.out.println("\nMenu Principal \n---- JUGADORES ----");
            System.out.println("1. Agregar                \t5. Rehacer (proximamente)");
            System.out.println("2. Eliminar               \t6. Log (proximamente)");
            System.out.println("3. Actualizar             \t7. Imprimir");
            System.out.println("4. Deshacer (proximamente)\t8. Salir");
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

            /* TODO: Limpiar el código */
            switch(seleccion){
                case 1: {
                    CLista nueva = opcion.duplicar(lista);
                    opcion.agregar(nueva);
                    CNodo2 nodo = new CNodo2(nueva);
                    UndoPila.push(nodo);
                    break;
                }
                case 2: {
                    CLista nueva = opcion.duplicar(lista);
                    opcion.eliminar(nueva);
                    CNodo2 nodo = new CNodo2(nueva);
                    UndoPila.push(nodo);
                    break;
                }
                case 3: {
                    CLista nueva = opcion.duplicar(lista);
                    opcion.actualizar(nueva);
                    CNodo2 nodo = new CNodo2(nueva);
                    UndoPila.push(nodo);
                    break;
                }
                case 4:
                    opcion.undo(UndoPila, RedoPila);
                    break;
                case 5:
                    opcion.redo(UndoPila, RedoPila);
                    break;
                case 6:
                    /* TODO: log */
                    System.out.println("Proximamente..");
                    break;
                case 7:
                    opcion.imprimir(UndoPila);
                    break;
                case 8:
                    System.out.println("Gracias por usar el sistema CRUDJugadores");
                    continuar = false;
            }

            lista = UndoPila.peek();
            
        }
        teclado.close();
    }
}
