package servicios;

import entidades.Direccion;

import java.util.Locale;
import java.util.Scanner;

public class DireccionServicios {
    public Direccion crearDireccion() {
        //public Direccion(String calle, int numero, String localidad)
        Direccion d = new Direccion();
        Scanner sn = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
        System.out.println("Ingresar calle");
        d.setCalle(sn.next());
        System.out.println("Ingresar número");
        d.setNumero(sn.next());
        System.out.println("Ingresar localidad");
        d.setLocalidad(sn.next());
        return d;
    }
}
