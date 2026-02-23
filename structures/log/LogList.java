package structures.log;
public class LogList {
    LogNode prim;
    LogNode ult;
    int tamano;

    public LogList() {
        prim = ult = null;
        tamano = 0;
    }

    public void addULT(LogNode nodo){
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
            LogNode test = prim;

            while(test != null){
                test.log.imprimir();
                test = test.sig;
            }
        }
    }

    public int getSize(){
        return tamano;
    }
}
