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
        ArrayList<Cliente> clientesBanco = autogenerarArrayListDeClientes();
        BancoServicios bancoServicios = new BancoServicios();
        Banco bancoSantander = bancoServicios.crearBanco();
        bancoSantander.setClientes(clientesBanco);
        try{
            bancoServicios.menu(bancoSantander);
        }catch(InputMismatchException e){
            System.out.println("Error de caracter inesperado al ingresar datos");
        }
    }

    public static ArrayList<Cliente> autogenerarArrayListDeClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        String[] nombres = {"Ignacio", "Nicolas", "Mariana", "Romina",
                "Alejandra", "Juan", "Nahuel", "Santiago", "Gonzalo"};
        for (int i = 0; i < 9; i++) {
            Cliente cliente = new Cliente(nombres[i], 1000);
            clientes.add(cliente);
        }
        return clientes;
    }
}
/*
 * u > 18 para abrir cuenta
 * fecha
 * */