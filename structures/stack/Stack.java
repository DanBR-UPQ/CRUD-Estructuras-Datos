package structures.stack;
import structures.list.LinkedList;

public class Stack {
	private StackNode primero; 
	private StackNode ultimo;
	private int tamano;

	public Stack() {
		primero = ultimo = null;
		tamano = 0;
	}

    public int getSize(){
        return tamano;
    }
    public StackNode getPrim(){
        return primero;
    }
    public StackNode getUlt(){
        return ultimo;
    }


    public void push(StackNode nodo){
        if (tamano == 0){
            primero = ultimo = nodo;
        } else {
            ultimo.setSig(nodo);;
            ultimo = nodo;
        }
        tamano++;
    }


    public LinkedList peek() {
        if(tamano == 0){
            /* System.out.println("No hay elementos"); */
            return null;
        } else {
            return ultimo.getList();
        }
    }


    public StackNode pop() {
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
                if(temp.getSig() == ultimo){
                    StackNode temp2 = ultimo;
                    temp.setSig(null);
                    tamano--;
                    ultimo = temp;
                    return temp2;
                }
                temp = temp.getSig();
            }
        }
        return null;
    }


    public void borrar() {
        primero = ultimo = null;
        tamano = 0;
    }
}
