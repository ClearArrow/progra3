package clases;
import java.util.ArrayList;


public class Chat {
    public ArrayList<Mensaje> mensajes;
    public int cantidad;

    public Chat() {
        this.mensajes = new ArrayList<Mensaje>();
    }

    public Chat(ArrayList<Mensaje> mensajes, int cantidad) {
        this.mensajes = mensajes;
        this.cantidad = cantidad;
    }

    public ArrayList<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(ArrayList<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
