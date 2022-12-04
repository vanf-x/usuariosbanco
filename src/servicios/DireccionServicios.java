package servicios;

import entidades.Direccion;

import java.util.Locale;
import java.util.Scanner;

public class DireccionServicios {
    private static Scanner sn = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);

    public Direccion crearDireccion() {
        //public Direccion(String calle, int numero, String localidad)
        Direccion direccion = new Direccion();
        Scanner sn = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
        System.out.println("Ingresar calle");
        direccion.setCalle(validarCamposDireccion());
        System.out.println("Ingresar número");
        direccion.setNumero(validarCamposDireccion());
        System.out.println("Ingresar localidad");
        direccion.setLocalidad(validarCamposDireccion());
        return direccion;
    }

    public String validarCamposDireccion() {
        String valorCampo;
        do {
            valorCampo = sn.next();
            if (valorCampo.trim().equals("")) System.out.println("El campo no puede quedar vacío.");
        } while (valorCampo.trim().equals(""));
        return valorCampo;
    }
}
