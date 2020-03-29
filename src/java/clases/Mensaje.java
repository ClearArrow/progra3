package clases;

import java.util.Date;

public class Mensaje {
    public String mensaje;
    public java.util.Date fecha;
    public int autor;

    public Mensaje() {
    }
    
    public Mensaje(String mensaje, Date fecha, int autor) {
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.autor = autor;
    }    
}
