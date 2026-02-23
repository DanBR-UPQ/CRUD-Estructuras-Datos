package structures.list;
import model.Player;

public class ListNode {
    Player jugador;
    ListNode sig;

    public ListNode(Player jugador) {
        this.jugador = jugador;
        sig = null;
    }
}