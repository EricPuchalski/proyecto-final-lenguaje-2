package view;

import controller.InformeController;

import java.util.Scanner;

public class MenuInforme {
    private InformeController informeController;

    public MenuInforme(InformeController informeController) {
        this.informeController = informeController;
    }

    public void mostrarMenuInforme() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor ingrese la opción que desee: ");
        System.out.println("1. Mostrar cantidad de pedidos realizados por una sucursal");
        System.out.println("2. Mostrar cantidad de pedidos en estado Pendiente");
        System.out.println("3. Volver al menú principal");

        System.out.println("----------------------------");
        String opcion = scanner.nextLine();

        switch (opcion) {
            case "1":
                System.out.println("Por favor ingrese el código de la sucursal para obtener la cantidad de pedidos realizados:");
                String codigoSucursal = scanner.nextLine();
                int cantidadPedidos = informeController.obtenerCantidadPedidosPorSucursal(codigoSucursal);
                System.out.println("La cantidad de pedidos realizados por la sucursal con código " + codigoSucursal + " es: " + cantidadPedidos);
                break;

            case "2":
                int cantidadPedidosPendientes = informeController.contarPedidosEnEstadoPendiente();
                System.out.println("La cantidad de pedidos en estado Pendiente es: " + cantidadPedidosPendientes);
                break;

            case "3":
                // Volver al menú principal
                break;

            default:
                System.out.println("Opción inválida. Por favor, ingrese una opción válida del menú.");
                break;
        }
    }
}
