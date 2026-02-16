package models;

/**
 *
 * @author Ricardo
 */
public class Cliente {
    private int id;
    private String nombre;
    private String direccion;
    private String telefonos;

    // Puse dos contstructores, este es para la base de datos y el de abajo sin ID es para insertar
    public Cliente(int id, String nombre, String direccion, String telefonos) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefonos = telefonos;
    }

    // Constructor para nuevas inserciones (sin ID)
    public Cliente(String nombre, String direccion, String telefonos) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefonos = telefonos;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefonos=" + telefonos + '}';
    }
}
