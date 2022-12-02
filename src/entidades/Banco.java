package entidades;

import java.util.ArrayList;

public class Banco {

    private String nombre;
    private ArrayList<Cliente> clientes;
    private Direccion direccion;

    public Banco() {
    }

    public Banco(String nombre, Direccion direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Banco{" +
                "nombre='" + nombre + '\'' +
                ", clientes=" + clientes +
                ", direccion=" + direccion +
                '}';
    }
}
