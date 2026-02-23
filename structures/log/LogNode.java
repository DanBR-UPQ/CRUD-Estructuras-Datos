package structures.log;
import model.LogEntry;

public class LogNode {
    private final LogEntry log;
    private LogNode sig;

    public LogNode(LogEntry log) {
        this.log = log;
        sig = null;
    }

    public LogEntry getLog(){
        return log;
    }
    public LogNode getSig(){
        return sig;
    }

    public void setSig(LogNode sig){
        this.sig = sig;
    }
}
