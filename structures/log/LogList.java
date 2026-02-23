package structures.log;

public class LogList {
    private LogNode prim;
    private LogNode ult;
    private int tamano;

    public LogList() {
        prim = ult = null;
        tamano = 0;
    }

    public int getSize(){
        return tamano;
    }
    public LogNode getPrim(){
        return prim;
    }
    public LogNode getUlt(){
        return ult;
    }

    public void addULT(LogNode nodo){
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
            LogNode test = prim;

            while(test != null){
                test.getLog().imprimir();
                test = test.getSig();
            }
        }
    }

}
