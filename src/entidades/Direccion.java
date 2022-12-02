package entidades;

public class Direccion {
    public String calle;
    public String numero;
    public String localidad;

    public Direccion() {
    }

    public Direccion(String calle, String numero, String localidad) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return "Direccion{" + "calle='" + calle + '\'' + ", numero=" + numero + ", localidad='" + localidad + '\'' + '}';
    }
}


