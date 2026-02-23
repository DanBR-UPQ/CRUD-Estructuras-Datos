package model;
public class Player {
    private int id;
    private int chips;

    private String nombre;
    private String juego;

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

    public int getId(){
        return id;
    }
    public int getChips(){
        return chips;
    }
    public String getNombre(){
        return nombre;
    }
    public String getJuego(){
        return juego;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setChips(int chips){
        this.chips = chips;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setJuego(String juego){
        this.juego = juego;
    }
}
