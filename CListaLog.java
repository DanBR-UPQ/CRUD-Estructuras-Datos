public class CListaLog {
    CNodo3 prim;
    CNodo3 ult;
    int tamano;

    public CListaLog() {
        prim = ult = null;
        tamano = 0;
    }

    public void addULT(CNodo3 nodo){
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
            CNodo3 test = prim;

            while(test != null){
                test.log.imprimir();
                test = test.sig;
            }
        }
    }

}
