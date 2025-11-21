public class CLista {
    CNodo prim;
    CNodo ult;
    int tamano;

    public CLista() {
        prim = ult = null;
        tamano = 0;
    }

    public void addULT(CNodo nodo){
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
            CNodo test = prim;

            while(test != null){
                test.jugador.imprimir();
                test = test.sig;
            }
        }
    }

    public CNodo buscarID(int ID){
            CNodo test = prim;

            while(test != null){
                if(test.jugador.id == ID){
                    return test; 
                }
                test = test.sig;
            }
            return null;
    }

    public void eliminar(CNodo nodo){
        CNodo test = prim;

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
