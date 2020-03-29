package clases;
import java.util.ArrayList;


public class Chat {
    public ArrayList<Mensaje> mensajes;
    public int cantidad;

    public Chat() {
    }

    public Chat(ArrayList<Mensaje> mensajes, int cantidad) {
        this.mensajes = mensajes;
        this.cantidad = cantidad;
    }
}
