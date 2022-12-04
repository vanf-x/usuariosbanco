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
            bancoServicios.menu(bancoSantander);
    }

    public static ArrayList<Cliente> autogenerarArrayListDeClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        String[] nombres = {"Ignacio", "Nicolas", "Mariana", "Romina",
                "Alejandra", "Juan", "Nahuel", "Santiago", "Gonzalo"};
        for (int i = 0; i < nombres.length; i++) {
            Cliente cliente = new Cliente(nombres[i], 1000);
            clientes.add(cliente);
        }
        return clientes;
    }
}