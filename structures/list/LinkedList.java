package structures.list;
public class LinkedList {
    ListNode prim;
    ListNode ult;
    int tamano;

    public LinkedList() {
        prim = ult = null;
        tamano = 0;
    }

    public int getSize(){
        return tamano;
    }
    public ListNode getPrim(){
        return prim;
    }
    public ListNode getUlt(){
        return ult;
    }

    public void addULT(ListNode nodo){
        if(tamano == 0){
            prim = ult = nodo;
        } else {
            ult.setSig(nodo);
            ult = nodo; 
        }
        tamano++;
    }

    public void imprimir(){
        if (tamano == 0){
            System.out.println("No hay ningun registro..");
        } else {
            ListNode test = prim;

            while(test != null){
                test.getJugador().imprimir();
                test = test.getSig();
            }
        }
    }

    public ListNode buscarID(int ID){
            ListNode test = prim;

            while(test != null){
                if(test.getJugador().getId() == ID){
                    return test; 
                }
                test = test.getSig();
            }
            return null;
    }

    public void eliminar(ListNode nodo){
        ListNode test = prim;

        if(tamano == 1){
            prim = ult = null;
        } else if (nodo == prim){
            prim = prim.getSig();
        } else{
            while(test != null){
                if(test.getSig() == nodo){
                    test.setSig(test.getSig().getSig());
                    if (nodo == ult){
                        ult = test;
                    }
                    break;
                }
                test = test.getSig();
            }
        }
        tamano--;
    }
    
}
