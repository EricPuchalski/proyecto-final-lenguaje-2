package org.example.view;

import org.example.controller.ClienteController;
import org.example.model.Cliente;

import java.util.Scanner;

public class MenuCliente {


    private ClienteController clienteController;
    private String opcion;

    public MenuCliente(ClienteController clienteController) {
        this.clienteController = clienteController;
    }

    public void mostrarMenuCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor ingrese la opción que desee: ");
        System.out.println("----------------------------");
        System.out.println("1. Crear cliente");
        System.out.println("2. Ver clientes");
        System.out.println("3. Ver clientes eliminados");
        System.out.println("4. Buscar cliente por CUIT");
        System.out.println("5. Editar cliente");
        System.out.println("6. Eliminar cliente");
        System.out.println("7. Salir del Menu de cliente");
        System.out.println("----------------------------");
        this.opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Por favor ingrese el CUIT");
                    String cuit = scanner.nextLine();
                    if (clienteController.findOne(cuit) == null) {
                        System.out.println("Por favor ingrese el nombre");
                        String nombre = scanner.nextLine();
                        System.out.println("Por favor ingrese el apellido");
                        String apellido = scanner.nextLine();
                        System.out.println("Por favor ingrese la dirección");
                        String direccion = scanner.nextLine();
                        System.out.println("Por favor ingrese el telefono");
                        String telefono = scanner.nextLine();

                        clienteController.create(new Cliente(cuit, nombre, apellido, direccion, telefono));
                    } else {
                        System.out.println("El cliente ingresado ya existe.");
                    }


                    break;
                case "2":
                    System.out.println("============== La lista de Clientes actuales es: ===============");
                    clienteController.findAll();
                    break;
                case "3":
                    System.out.println("============== La lista de Proveedores eliminados es: ===============");
                    clienteController.findAllOff();
                case "4":
                    System.out.println("Por favor ingrese el CUIT del cliente");
                    String cuitCliente = scanner.nextLine();
                    if (clienteController.findOne(cuitCliente) != null) {
                        System.out.println("----------------------------");
                        System.out.println(clienteController.findOne(cuitCliente).toString());
                        System.out.println("----------------------------");
                    } else {
                        System.out.println("----------------------------");
                        System.out.println("No existe un cliente con ese cuit");
                        System.out.println("----------------------------");
                    }

                    break;
                case "5":
                    System.out.println("Por favor ingrese el CUIT del cliente a editar");
                    String cuitClienteEditar = scanner.nextLine();
                    if (clienteController.findOne(cuitClienteEditar) != null) {
                        System.out.println("Por favor ingrese el nuevo nombre");
                        String nuevoNombre = scanner.nextLine();
                        System.out.println("Por favor ingrese el nuevo apellido");
                        String nuevoApellido = scanner.nextLine();
                        System.out.println("Por favor ingrese la nueva dirección");
                        String nuevaDireccion = scanner.nextLine();
                        System.out.println("Por favor ingrese el telefono nuevo");
                        String nuevoTelefono = scanner.nextLine();
                        clienteController.upDate(new Cliente(cuitClienteEditar, nuevoNombre, nuevoApellido, nuevaDireccion, nuevoTelefono));
                    } else {
                        System.out.println("El cuit ingresado es inexistente");
                    }

                    break;
                case "6":
                    System.out.println("Por favor ingrese el cuit del cliente a eliminar");
                    String cuitClienteEliminado = scanner.nextLine();
                    Cliente clienteEliminado = clienteController.findOne(cuitClienteEliminado);
                    clienteController.delete(clienteEliminado.getCuit());


                    break;
                case "7":
                    System.out.println("Ha salido exitosamente");
                    MenuPrincipal menuPrincipal = new MenuPrincipal();
                    menuPrincipal.mostrarMenuPrincipal();
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;

        }
    }
}
