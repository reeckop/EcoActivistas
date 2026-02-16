package models;

/**
 *
 * @author Ricardo
 */
public class Activista {
    private int id;
    private String nombre;
    private String correo;
    private String telefono;

    public Activista() {}

    public Activista(String nombre, String correo, String telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    // Constructor completo para la Base de Datoss
    public Activista(int id, String nombre, String correo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    public int getId() {
        return id; 
    }
    
    public void setId(int id) {
        this.id = id; 
    }
    
    public String getNombre() {
        return nombre; 
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCorreo() {
        return correo; 
    }
    
    public void setCorreo(String correo) {
      
        this.correo = correo; 
    }
    
    public String getTelefono() {
        return telefono; 
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono; 
    }

    @Override
    public String toString() {
        return "Activista{" + "id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono + '}';
    }
}
