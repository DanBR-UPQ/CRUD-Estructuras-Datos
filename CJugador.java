public class CJugador {
    int id, chips;
    String nombre, juego;

    public CJugador(int id, String nombre, int chips, String juego) {
        this.id = id;
        this.chips = chips;
        this.nombre = nombre;
        this.juego = juego;
    }

    public CJugador(){
        id = chips = 0;
        nombre = juego = "";
    }

    public void imprimir(){
        System.out.println("[ " + id + ", " + nombre + ", " + chips + ", " + juego + " ]");
    }
}
