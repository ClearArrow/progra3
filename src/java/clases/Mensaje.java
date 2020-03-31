package clases;

import java.util.Date;

public class Mensaje {
    public String mensaje;
    public java.util.Date fecha;
    public int autor; // Chatbot = 0; usuario = 1;

    public Mensaje() {
    }
    
    public Mensaje(String mensaje, Date fecha, int autor) {
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.autor = autor;
    }   

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setAutor(int autor) {
        this.autor = autor;
    }
    
}
