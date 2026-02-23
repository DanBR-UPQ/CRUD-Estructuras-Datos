package model;
public class Player {
    int id, chips;
    String nombre, juego;

    public Player(int id, String nombre, int chips, String juego) {
        this.id = id;
        this.chips = chips;
        this.nombre = nombre;
        this.juego = juego;
    }

    public Player(){
        id = chips = 0;
        nombre = juego = "";
    }

    public void imprimir(){
        System.out.println("[ " + id + ", " + nombre + ", " + chips + ", " + juego + " ]");
    }
}
