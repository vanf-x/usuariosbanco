import entidades.Banco;
import entidades.Cliente;
import entidades.Direccion;
import servicios.BancoServicios;
import servicios.ClienteServicios;
import servicios.DireccionServicios;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sn = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) {
        ArrayList<Cliente> clientesBanco = new ArrayList<>();

        BancoServicios bancoServicios = new BancoServicios();
        Banco bancoSantander = bancoServicios.crearBanco();
        bancoSantander.setClientes(clientesBanco);

        clientesBanco.add(new Cliente("Ignacio", 1000));
        clientesBanco.add(new Cliente("Nicolas", 1000));
        clientesBanco.add(new Cliente("Mariana", 1000));
        clientesBanco.add(new Cliente("Romina", 1000));
        clientesBanco.add(new Cliente("Luz", 1000));
        clientesBanco.add(new Cliente("Juan", 1000));
        clientesBanco.add(new Cliente("Nahuel", 1000));
        clientesBanco.add(new Cliente("Santiago", 1000));
        clientesBanco.add(new Cliente("Gonzalo", 1000));
        //System.out.println(bancoSantander.getClientes());
        bancoServicios.menu(bancoSantander);


        // bancoServicios.transferenciaDeFondos(bancoSantander);

    }


}
/*
 *  * hasta 10 usuarios x
 * controlar q nada llegue vacio
 * nombre ap direc tel correo x
 * usuario x
 * contraseña x
 * u > 18 para abrir cuenta
 * menu para transaccion de usuario 1 a usuario 2 x
 * tarjeta con unico numero x
 * fecha
 * */