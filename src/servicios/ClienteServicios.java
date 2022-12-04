package servicios;

import entidades.Cliente;
import entidades.Direccion;
import interfaces.ControlCaracteres;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ClienteServicios implements ControlCaracteres {
    static Scanner sn = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

    public Cliente crearCliente() {
        //CREA CLIENTE
        Cliente cliente = new Cliente();
        System.out.println("Ingresar nombre");
        cliente.setNombre(validarCamposString());
        System.out.println("Ingresar apellido");
        cliente.setApellido(validarCamposString());
        System.out.println("Ingresar edad");
        cliente.setEdad(generarEdad());
        if (cliente.getEdad() >= 18) {
            //CREA DIRECCION
            DireccionServicios direccionServicios = new DireccionServicios();
            Direccion direccion = direccionServicios.crearDireccion();
            cliente.setDireccion(direccion);
            //
            System.out.println("Ingresar número de teléfono");
            cliente.setTelefono(generarTelefono());
            System.out.println("Ingresar correo electrónico");
            cliente.setCorreo(generarCorreo());
            System.out.println("Ingresar un nombre de usuario de entre 4 y 10 caracteres");
            cliente.setUsuario(generarUsuario());
            System.out.println("Generando contraseña automáticamente...");
            cliente.setContrasena(generarContrasena());
            System.out.println("La contraseña se ha generado con éxito. " +
                    "La misma ha sido enviada al correo electrónico brindado por el cliente: "
                    + cliente.getCorreo() + ".");
            cliente.setNumeroTarjeta(generarNumeroTarjeta());
            System.out.println("Número de tarjeta generado por el sistema: " + cliente.getNumeroTarjeta());
        }
        return cliente;
    }

    private int generarAleatorio(int min, int max) {
        int aleatorio = (int) (Math.random() * (max - min + 1) + (min));
        return aleatorio;
    }

    private String validarCamposString() {
        String valorCampo = controlCaracteres();
        while (valorCampo.trim().equals("")) {
            System.out.println("El campo no puede quedar vacío");
            valorCampo = sn.next();
        }
        return valorCampo;
    }

    private int generarEdad() throws InputMismatchException {
        int edad = 0;
        do {
            try {
                edad = sn.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Ha ingresado una edad incorrecta. Ingresar nuevamente.");
            }
            sn = new Scanner(System.in);
        } while (edad == 0);
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
            if (correo.contains("@") && correo.contains(".com") && correo.length() >= 10) {
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

/*    public String controlCaracteres() {
        String nombre;
        int cantidadCaracteresIncorrectos;
        boolean control = false;
        char caracter;
        do{
            cantidadCaracteresIncorrectos = 0;
            nombre = sn.next();
            for (int i = 0; i < nombre.length(); i++) {
                caracter = nombre.charAt(i);
                if (!(caracter >= 65 && caracter <= 90) && !(caracter >= 97 && caracter <= 122)) {
                    cantidadCaracteresIncorrectos++;
                }
            }
            if (cantidadCaracteresIncorrectos == 0) {
                control = true;
            } else {
                System.out.println("Nombre incorrecto. Inténtelo nuevamente.");
            }
        }while(!control);
        return nombre;
    }*/
}
