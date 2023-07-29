package view;

import java.util.Scanner;

public class MenuPrincipal {

    private MenuCliente menuCliente;

    private MenuTransportista menuTransportista;
    private MenuProducto menuProducto;
    private MenuPedido menuPedido;
    private MenuInforme menuInforme;
    private String opcion;

    public MenuPrincipal(MenuCliente menuCliente, MenuTransportista menuTransportista, MenuProducto menuProducto, MenuPedido menuPedido,MenuInforme menuInforme) {
        this.menuCliente = menuCliente;
        this.menuTransportista = menuTransportista;
        this.menuProducto = menuProducto;
        this.menuPedido = menuPedido;
        this.menuInforme=menuInforme;
    }

    public void mostrarMenuPrincipal(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------");
        System.out.println("Por favor ingrese la opción que desea gestionar: ");
        System.out.println("----------------------------");
        System.out.println("1. Clientes");
        System.out.println("2. Proveedores");
        System.out.println("3. Transportistas");
        System.out.println("4. Productos");
        System.out.println("5. Pedidos");
        System.out.println("6. Productos");
        System.out.println("7. Informes");
        System.out.println("8. Salir");
        System.out.println("----------------------------");
        opcion = scanner.nextLine();

        switch (opcion){
            case"1":
                menuCliente.mostrarMenuCliente();
                mostrarMenuPrincipal();
            case"2":
                break;
            case"3":
                menuTransportista.mostrarMenuTransportista();
                mostrarMenuPrincipal();
            case"4":
                menuProducto.mostrarMenuProducto();
                mostrarMenuPrincipal();
            case"5":
                menuPedido.mostrarMenuPedido();
                mostrarMenuPrincipal();
            case"6":
                menuProducto.mostrarMenuProducto();
                mostrarMenuPrincipal();
            case"7":
                menuInforme.mostrarMenuInforme();
                mostrarMenuPrincipal();
        }

    }
}


