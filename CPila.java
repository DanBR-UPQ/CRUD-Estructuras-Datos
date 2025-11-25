public class CPila {
	CNodo2 primero; 
	CNodo2 ultimo;
	int tamano;

	CPila() {
		primero = ultimo = null;
		tamano = 0;
	}


    void push(CNodo2 nodo){
        if (tamano == 0){
            primero = ultimo = nodo;
        } else {
            ultimo.sig = nodo;
            ultimo = nodo;
        }
        tamano++;
    }


    CLista peek() {
        if(tamano == 0){
            /* System.out.println("No hay elementos"); */
            return null;
        } else {
            return ultimo.lista;
        }
    }


    CNodo2 pop() {
        if (tamano == 0){
            System.out.println("No hay elementos");
            return null;
        } else if(tamano == 1){
            CNodo2 temp = ultimo;
            ultimo = primero = null;
            tamano--;
            return temp;
        } else{
            CNodo2 temp = primero;
            while(temp != null){
                if(temp.sig == ultimo){
                    CNodo2 temp2 = ultimo;
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





}
