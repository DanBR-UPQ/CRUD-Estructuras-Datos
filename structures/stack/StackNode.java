package structures.stack;
import structures.list.LinkedList;

public class StackNode {
    LinkedList lista;
    StackNode sig;

    public StackNode(LinkedList lista) {
        this.lista = lista;
        sig = null;
    }

    public LinkedList getList(){
        return lista;
    }
}