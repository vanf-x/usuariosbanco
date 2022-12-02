package servicios;

import entidades.Cliente;
import entidades.Direccion;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ClienteServicios {
    static Scanner sn = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

    public Cliente crearCliente() {
        //CREA CLIENTE
        Cliente c = new Cliente();
        System.out.println("Ingresar nombre");
        c.setNombre(generarNombreYApellido());
        System.out.println("Ingresar apellido");
        c.setApellido(generarNombreYApellido());
        System.out.println("Ingresar edad");
        c.setEdad(sn.nextInt());
        //CREA DIRECCION
        DireccionServicios ds = new DireccionServicios();
        Direccion d = ds.crearDireccion();
        c.setDireccion(d);
        //
        System.out.println("Ingresar número de teléfono");
        c.setTelefono(generarTelefono());
        System.out.println("Ingresar correo electrónico");
        c.setCorreo(generarCorreo());
        System.out.println("Ingresar un nombre de usuario de entre 4 y 10 caracteres");
        c.setUsuario(generarUsuario());
        System.out.println("Generando contraseña automáticamente...");
        c.setContrasena(generarContrasena());
        System.out.println("La contraseña se ha generado con éxito. La misma ha sido enviada a su correo electrónico " + c.getCorreo() + ".");
        c.setNumeroTarjeta(generarNumeroTarjeta());
        System.out.println("Su número de tarjeta es " + c.getNumeroTarjeta() + ". Podrá activarla llamando de 9 a 18 al 0800 666 666 666");
        return c;
    }

    private int generarAleatorio(int min, int max) {
        int aleatorio = (int) (Math.random() * (max - min + 1) + (min));
        return aleatorio;
    }

    private String generarNombreYApellido() {
        String nombreOApellido = sn.next();
        while (nombreOApellido.trim().equals("")) {
            System.out.println("El campo no puede quedar vacío");
            nombreOApellido = sn.next();
        }
        return nombreOApellido;
    }

    private int generarEdad() {
        int edad = 0;
        boolean validador = false;
        while (!validador) {
            try {
                edad = sn.nextInt();
                validador = true;
            } catch (InputMismatchException e) {
                System.out.println("Ha ingresado una edad incorrecta. Ingresar nuevamente.");
                sn.nextLine();
            }
        }
        return edad;
    }

    private String generarTelefono() {
        String telefono = sn.next();
        boolean comprobar = false;
        while (!comprobar) {
            if (telefono.startsWith("0054") && telefono.length() >= 10) {
                comprobar = true;
            } else {
                System.out.println("Teléfono incorrecto. Ingresar nuevamente.");
                telefono = sn.next();
            }
            ;
        }
        return telefono;
    }

    private String generarCorreo() {
        String correo = sn.next();
        boolean comprobar = false;
        while (!comprobar) {
            if (correo.contains("@") && correo.contains(".com") && correo.length() > 10) {
                comprobar = true;
            } else {
                System.out.println("Correo inválido. Por favor ingresar nuevamente.");
                correo = sn.next();
            }
        }
        return correo;
    }

    private String generarUsuario() {
        String usuario = sn.next();
        boolean comprobar = false;
        while (!comprobar) {
            if (usuario.length() >= 4 && usuario.length() <= 10) {
                comprobar = true;
            } else {
                System.out.println("Cantidad de caracteres incorrecta. Ingresar nuevamente un nombre de usuario que contenga de 4 a 10 caracteres.");
                usuario = sn.next();
            }
        }
        return usuario;
    }

    private String generarContrasena() {
        char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        char alfa = letras[generarAleatorio(0, 9)];
        int numerico = generarAleatorio(1111, 9999);
        String contrasena = String.valueOf(alfa + "" + numerico);
        return contrasena;
    }

    private String generarNumeroTarjeta() {
        String numeroTarjeta = "";
        for (int i = 0; i < 16; i++) {
            int numero = generarAleatorio(0, 9);
            numeroTarjeta += String.valueOf(numero);
        }
        return numeroTarjeta;
    }
}
