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
            ult.sig = nodo;
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
                test.jugador.imprimir();
                test = test.sig;
            }
        }
    }

    public ListNode buscarID(int ID){
            ListNode test = prim;

            while(test != null){
                if(test.jugador.getId() == ID){
                    return test; 
                }
                test = test.sig;
            }
            return null;
    }

    public void eliminar(ListNode nodo){
        ListNode test = prim;

        if(tamano == 1){
            prim = ult = null;
        } else if (nodo == prim){
            prim = prim.sig;
        } else{
            while(test != null){
                if(test.sig == nodo){
                    test.sig = test.sig.sig;
                    if (nodo == ult){
                        ult = test;
                    }
                    break;
                }
                test = test.sig;
            }
        }
        tamano--;
    }
    
}
