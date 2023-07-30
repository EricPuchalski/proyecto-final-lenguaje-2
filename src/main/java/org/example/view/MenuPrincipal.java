package org.example.view;

import org.example.controller.*;
import org.example.repository.*;
import org.example.service.*;

import java.util.Scanner;

public class MenuPrincipal {

     MenuCliente menuCliente;

     MenuTransportista menuTransportista;
     MenuProducto menuProducto;
     MenuPedido menuPedido;
     MenuInforme menuInforme;
     MenuProveedor menuProveedor;
    private String opcion;

    public MenuPrincipal() {
        this.menuCliente = new MenuCliente(new ClienteController(new ClienteService(new ClienteRepository())));
        this.menuTransportista = new MenuTransportista(new TransportistaController(new TransportistaService(new TransportistaRepository())),new PedidoController(new PedidoService(new PedidoRepository())));
        this.menuProducto = new MenuProducto(new ProductoController(new ProductoService(new ProductoRepository())));
        this.menuPedido = new MenuPedido(new PedidoController(new PedidoService(new PedidoRepository())));
        this.menuInforme = new MenuInforme(new InformeController(new InformeService(new InformeRepository(new PedidoRepository(), new ClienteRepository(), new ProductoRepository()))), new ClienteController(new ClienteService(new ClienteRepository())), new PedidoController(new PedidoService(new PedidoRepository())));
        this.menuProveedor = new MenuProveedor(new ProveedorController(new ProveedorService(new ProveedorRepository())));
    }

    public void mostrarMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------");
        System.out.println("Por favor ingrese la opción que desea gestionar: ");
        System.out.println("----------------------------");
        System.out.println("1. Clientes");
        System.out.println("2. Proveedores");
        System.out.println("3. Transportistas");
        System.out.println("4. Productos");
        System.out.println("5. Pedidos");
        System.out.println("6. Informes");
        System.out.println("7. Salir");
        System.out.println("----------------------------");
        opcion = scanner.nextLine();
        boolean salir = false;
        while (!salir) {

            switch (opcion) {
                case "1":
                    menuCliente.mostrarMenuCliente();
                    break;
                case "2":
                    menuProveedor.mostrarMenuProveedor();
                    break;
                case "3":
                    menuTransportista.mostrarMenuTransportista();
                    break;
                case "4":
                    menuProducto.mostrarMenuProducto();
                    break;
                case "5":
                    menuPedido.mostrarMenuPedido();
                    break;
                case "6":
                    menuInforme.mostrarMenuInforme();
                    break;
                case "7":
                    System.out.println("Ha salido exitosamente");
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }

        }
    }
}


