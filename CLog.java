import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CLog {
    String fecha, operacion;
    int objeto;

    public CLog(String operacion, int objeto) {
        
        this.operacion = operacion;
        this.objeto = objeto;

        DateTimeFormatter formato = DateTimeFormatter.ofPattern(
            "d MMMM yyyy, HH:mm:ss",
            new Locale("es", "ES")
        );

        this.fecha = LocalDateTime.now().format(formato);
    }    

    public void imprimir() {
        System.out.println("[ " + fecha + "     " + operacion + "     " + objeto + " ]");
    }
}
