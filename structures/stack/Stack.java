import structures.list.LinkedList;

public class Stack {
	StackNode primero; 
	StackNode ultimo;
	int tamano;

	Stack() {
		primero = ultimo = null;
		tamano = 0;
	}


    void push(StackNode nodo){
        if (tamano == 0){
            primero = ultimo = nodo;
        } else {
            ultimo.sig = nodo;
            ultimo = nodo;
        }
        tamano++;
    }


    LinkedList peek() {
        if(tamano == 0){
            /* System.out.println("No hay elementos"); */
            return null;
        } else {
            return ultimo.lista;
        }
    }


    StackNode pop() {
        if (tamano == 0){
            System.out.println("No hay elementos");
            return null;
        } else if(tamano == 1){
            StackNode temp = ultimo;
            ultimo = primero = null;
            tamano--;
            return temp;
        } else{
            StackNode temp = primero;
            while(temp != null){
                if(temp.sig == ultimo){
                    StackNode temp2 = ultimo;
                    temp.sig = null;
                    tamano--;
                    ultimo = temp;
                    return temp2;
                }
                temp = temp.sig;
            }
        }
        return null;
    }


    void borrar() {
        primero = ultimo = null;
        tamano = 0;
    }


}
