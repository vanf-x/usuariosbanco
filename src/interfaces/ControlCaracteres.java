package interfaces;

import java.util.Scanner;

public interface ControlCaracteres {
    default String controlCaracteres(){
        Scanner sn = new Scanner(System.in);
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
    }
}
