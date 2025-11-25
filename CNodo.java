public class CNodo {
    CJugador jugador;
    CNodo sig;

    public CNodo(CJugador jugador) {
        this.jugador = jugador;
        sig = null;
    }
}