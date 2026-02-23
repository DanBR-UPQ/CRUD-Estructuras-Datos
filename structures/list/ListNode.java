package structures.list;
import model.Player;

public class ListNode {
    private final Player jugador;
    private ListNode sig;

    public ListNode(Player jugador) {
        this.jugador = jugador;
        sig = null;
    }

    public Player getJugador(){
        return jugador;
    }
    public ListNode getSig(){
        return sig;
    }

    public void setSig(ListNode sig){
        this.sig = sig;
    }
}