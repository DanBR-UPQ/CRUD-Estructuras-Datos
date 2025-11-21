import java.util.Scanner;

public class CRUDmain {
    

    public static void main(String[] args) {
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

            switch(seleccion){
                case 1:
                    opcion.agregar(lista);
                    break;
                case 2:
                    opcion.eliminar(lista);
                    break;
                case 3:
                    opcion.actualizar(lista);
                    break;
                case 4:
                    System.out.println("Proximamente..");
                    //opcion.deshacer(lista);
                    break;
                case 5:
                    System.out.println("Proximamente..");
                    //opcion.rehacer(lista);
                    break;
                case 6:
                    System.out.println("Proximamente..");
                    //opcion.log(lista);
                    break;
                case 7:
                    opcion.imprimir(lista);
                    break;
                case 8:
                    System.out.println("Gracias por usar el sistema CRUDJugadores");
                    continuar = false;
            }
        }
        teclado.close();
    }
}
