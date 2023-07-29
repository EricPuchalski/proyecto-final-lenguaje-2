package view;

import controller.ClienteController;
import model.Cliente;

import java.util.Scanner;

public class MenuCliente {


    private ClienteController clienteController;
    private String opcion;
    public MenuCliente(ClienteController clienteController) {
        this.clienteController = clienteController;
    }

    public void mostrarMenuCliente(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor ingrese la opción que desee: ");
        System.out.println("1. Crear cliente");
        System.out.println("2. Ver clientes");
        System.out.println("3. Buscar cliente por CUIT");
        System.out.println("4. Editar cliente");
        System.out.println("5. Eliminar cliente");
        System.out.println("6. Salir del Menu de cliente");
        System.out.println("----------------------------");
        this.opcion = scanner.nextLine();
        switch (opcion) {
            case "1":
                System.out.println("Por favor ingrese el CUIT");
                String cuit = scanner.nextLine();
                System.out.println("Por favor ingrese el nombre");
                String nombre = scanner.nextLine();
                System.out.println("Por favor ingrese el apellido");
                String apellido = scanner.nextLine();
                System.out.println("Por favor ingrese la dirección");
                String direccion = scanner.nextLine();
                System.out.println("Por favor ingrese el telefono");
                String telefono = scanner.nextLine();

                clienteController.crearCliente(new Cliente(cuit, nombre, apellido, direccion,telefono));


                break;
            case "2":
                clienteController.buscarTodosLosClientes();
                break;
            case "3":
                System.out.println("Por favor ingrese el CUIT del cliente");
                String cuitCliente = scanner.nextLine();
                Cliente clienteEncontrado = clienteController.buscarClientePorCuit(cuitCliente);
                if (clienteEncontrado!=null){
                System.out.println(clienteEncontrado.toString());
            } else {
                    System.out.println("No existe un cliente con ese cuit");
                }

                break;
            case "4":
                System.out.println("Por favor ingrese el CUIT del cliente a editar");
                String cuitClienteEditar = scanner.nextLine();
                Cliente cliente = clienteController.buscarClientePorCuit(cuitClienteEditar);
                if (cliente != null) {
                    System.out.println("Por favor ingrese el nuevo nombre");
                    String nuevoNombre = scanner.nextLine();
                    System.out.println("Por favor ingrese el nuevo apellido");
                    String nuevoApellido = scanner.nextLine();
                    System.out.println("Por favor ingrese la nueva dirección");
                    String nuevaDireccion = scanner.nextLine();
                    System.out.println("Por favor ingrese el telefono nuevo");
                    String nuevoTelefono = scanner.nextLine();
                    clienteController.editarCliente(new Cliente(cuitClienteEditar,nuevoNombre,nuevoApellido,nuevaDireccion,nuevoTelefono));
                }

                break;
            case "5":
                System.out.println("Por favor ingrese el cuit del cliente a eliminar");
                String cuitClienteEliminado = scanner.nextLine();
                Cliente clienteEliminado = clienteController.buscarClientePorCuit(cuitClienteEliminado);
                clienteController.deshabilitarClientePorCuit(clienteEliminado.getCuit());


                break;
            case "6":
                break;
            default:
                System.out.println("Opción inválida");
                break;
    }


    }
}
