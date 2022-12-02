package servicios;

import entidades.Banco;
import entidades.Cliente;
import entidades.Direccion;

import java.util.Iterator;
import java.util.Scanner;

public class BancoServicios {
    private static Scanner sn = new Scanner(System.in);
    private static final int MAX_CLIENTES = 10;

    public Banco crearBanco() {
        return new Banco("Banco Santander",
                new Direccion("Av. Corrientes", "2572", "CABA"));
    }

    public void transferenciaDeFondos(Banco banco) {
        Cliente emisor = new Cliente();
        Cliente receptor = new Cliente();
        boolean controladorEmisor = false;
        boolean controladorReceptor = false;
        int monto = 0;
        //
        System.out.println("Ingresar el nombre de la persona que va a ENVIAR la transferencia:");
        String nombre = sn.next();
        //
        for (Cliente aux : banco.getClientes()) {
            if (aux.getNombre().equalsIgnoreCase(nombre)) {
                emisor = aux;
                controladorEmisor = true;
            }
        }
        //
        System.out.println("Ingresar el nombre de la persona que va a RECIBIR la transferencia:");
        nombre = sn.next();
        for (Cliente aux : banco.getClientes()) {
            if (aux.getNombre().equalsIgnoreCase(nombre)) {
                receptor = aux;
                controladorReceptor = true;
            }
        }
        if (controladorEmisor && controladorReceptor) {
            System.out.println("Ingresar el monto a transferir: ");
            monto = sn.nextInt();
            if (emisor.getSaldo() >= monto) {
                emisor.setSaldo(emisor.getSaldo() - monto);
                receptor.setSaldo(receptor.getSaldo() + monto);
                System.out.println("Monto transferido: $" + monto);
                System.out.println("Saldo EMISOR: $" + emisor.getSaldo());
                System.out.println("Saldo RECEPTOR: $" + receptor.getSaldo());
            } else {
                System.out.println("El monto ingresado es incorrecto. Inténtelo nuevamente.");
            }
        } else {
            System.out.println("Hubo un error con los nombres de los clientes. Inténtelo nuevamente.");
        }
    }

    private void altaCliente(Banco banco) {
        if (banco.getClientes().size() < MAX_CLIENTES) {
            ClienteServicios clienteServicios = new ClienteServicios();
            Cliente cliente = clienteServicios.crearCliente();
            if(cliente.getEdad()>=18){
                banco.getClientes().add(cliente);
                System.out.println("Alta cliente realizada con éxito.");
            }else{
                System.out.println("El cliente no cumple con el requisito mínimo de edad.");
            }
        } else {
            System.out.println("Se ha alcanzado el límite de registros posibles.");
        }
    }

    public void bajaCliente(Banco banco) {
        int controlador = 0;
        String nombre;
        Iterator<Cliente> it = banco.getClientes().iterator();
        System.out.println("Ingrese el NOMBRE del cliente a dar de baja:");
        nombre = sn.next();
        //
        while (it.hasNext()) {
            if (it.next().getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Está seguro de que quiere remover el registro " + nombre + " ? [S/N]");
                System.out.println(it.toString());
                String respuesta = String.valueOf(sn.next().toLowerCase().charAt(0));
                if (respuesta.equals("s")) {
                    controlador++;
                    it.remove();
                    System.out.println("Baja realizada con éxito.");
                } else {
                    System.out.println("La baja no ha sido realizada. Inténtelo nuevamente.");
                }
            }
        }
        if (controlador == 0) System.out.println("No se ha encontrado ningún cliente con ese nombre.");
    }

    public void menu(Banco banco) {
        System.out.println("Sistema del banco Santander");
        System.out.println("Elegir opción deseada a continuación: ");
        System.out.println("1) Alta cliente\n2) Baja cliente\n3) Transferencia entre clientes\n4) Imprimir listado de clientes\n5) Salir");
        int respuesta = sn.nextInt();
        switch (respuesta) {
            case 1:
                System.out.println("===ALTA CLIENTE===");
                altaCliente(banco);
                System.out.println("======================================================");
                menu(banco);
                break;
            case 2:
                System.out.println("===BAJA CLIENTE===");
                bajaCliente(banco);
                System.out.println("======================================================");
                menu(banco);
                break;
            case 3:
                System.out.println("===TRANSFERENCIA DE FONDOS===");
                transferenciaDeFondos(banco);
                System.out.println("======================================================");
                menu(banco);
                break;
            case 4:
                System.out.println("===LISTADO DE CLIENTES===");
                System.out.println(banco.getClientes());
                System.out.println("======================================================");
                menu(banco);
                break;
            default:
                System.out.println("********Saliendo del programa********");
        }
    }
}
