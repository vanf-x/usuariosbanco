package entidades;

public final class Cliente extends Persona {
    private String telefono;
    private String correo;
    private String usuario;
    private String contrasena;
    private String numeroTarjeta;
    private int saldo;

    public Cliente() {
    }
    public Cliente(String nombre, int saldo){
        this.nombre = nombre;
        this.saldo = saldo;
    }
    public Cliente(String nombre, String apellido, int edad, Direccion direccion, String telefono, String correo, String usuario, String contrasena, String numeroTarjeta) {
        super(nombre, apellido, edad, direccion);
        this.telefono = telefono;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                " nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", direccion=" + direccion +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", numeroTarjeta='" + numeroTarjeta + '\'' +
                ", saldo=" + saldo +
                "}\n";
    }
}
