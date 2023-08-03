package LDEsystem.com.view;

import LDEsystem.com.controller.*;
import LDEsystem.com.repository.*;
import LDEsystem.com.service.*;

import java.util.Scanner;

public class MenuPrincipal {

    MenuCliente menuCliente;
    MenuTransportista menuTransportista;
    MenuProducto menuProducto;
    MenuPedido menuPedido;
    MenuInforme menuInforme;
    MenuProveedor menuProveedor;
    private String opcion;

    public MenuPrincipal(MenuCliente menuCliente, MenuTransportista menuTransportista, MenuProducto menuProducto, MenuPedido menuPedido,MenuInforme menuInforme,MenuProveedor menuProveedor) {
        this.menuCliente = menuCliente;
        this.menuTransportista = menuTransportista;
        this.menuProducto = menuProducto;
        this.menuPedido = menuPedido;
        this.menuInforme=menuInforme;
        this.menuProveedor=menuProveedor;
    }

    public void mostrarMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("*** BIENVENIDO AL SISTEMA DE LyDE ***");
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
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }
        }
    }
}


