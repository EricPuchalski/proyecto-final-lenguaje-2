package view;

import controller.*;
import model.*;
import repository.EmpleadoRepository;
import repository.SectorRepository;
import service.EmpleadoService;
import util.CalcularDistancia;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPedido {
    private EmpleadoService empleadoService;
    private PedidoController pedidoController;
    private DepositoController depositoController;
    private SectorRepository sectorRepository;
    private TransportistaController transportistaController;
    private ProductoController productoController;

    private EmpleadoRepository empleadoRepository;
    private String opcion;
    private int seguirAgregandoProductos;

    private ClienteController clienteController;

    public MenuPedido(PedidoController pedidoController, DepositoController depositoController, SectorRepository sectorRepository, TransportistaController transportistaController, ProductoController productoController, ClienteController clienteController, EmpleadoRepository empleadoRepository, EmpleadoService empleadoService) {
        this.pedidoController = pedidoController;
        this.depositoController = depositoController;
        this.sectorRepository = sectorRepository;
        this.transportistaController = transportistaController;
        this.productoController = productoController;
        this.clienteController = clienteController;
        this.empleadoRepository = empleadoRepository;
        this.empleadoService = new EmpleadoService(empleadoRepository);

    }

    public void mostrarMenuPedido(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor ingrese la opción que desee: ");
        System.out.println("1. Crear Pedido");
        System.out.println("2. Procesar pedido");
        System.out.println("3. Completar pedido");
        System.out.println("4. Enviar a despacho");
        System.out.println("5. Despachar pedido");
        System.out.println("6. Transitar pedido");
        System.out.println("7. Enviar a sucursal destino");
        System.out.println("8. Entregar pedido");
        System.out.println("9. Calcular distancia del pedido");
        System.out.println("10. INFORME ver la cantidad de pedidos de una Sucursal");
        System.out.println("11. INFORME ver la cantidad de pedidos en estado Pendiente");
        System.out.println("12. Salir del menu pedido");

        System.out.println("----------------------------");
        this.opcion = scanner.nextLine();
        switch(opcion) {
            case"1":
                System.out.println("Por favor ingrese el numero del pedido");
                String numeroPedido = scanner.nextLine();
                System.out.println("Por favor seleccione el cliente del pedido");
                clienteController.buscarTodosLosClientes();
                String cuitCliente = scanner.next();
                Cliente cliente = clienteController.buscarClientePorCuit(cuitCliente);

                System.out.println("Por favor seleccione el deposito de origen");
                System.out.println("----------------------------");
                depositoController.buscarTodosLosDepositos();
                System.out.println("----------------------------");
                scanner.nextLine();
                String codigoDeposito = scanner.nextLine();
                Deposito depositoOrigen = depositoController.buscarDepositoPorCodigo(codigoDeposito);

                System.out.println("Por favor seleccione el deposito de destino");
                System.out.println("----------------------------");
                depositoController.buscarTodosLosDepositos();
                System.out.println("----------------------------");
                String codigoDepositoDestino = scanner.nextLine();
                Deposito depositoDestino = depositoController.buscarDepositoPorCodigo(codigoDepositoDestino);


                System.out.println("Por favor seleccione el transportista");
                transportistaController.buscarTodosLosTransportistas();
                String cuitTransportista = scanner.nextLine();
                Transportista transportista = transportistaController.buscarTransportistaPorCuit(cuitTransportista);


                if ((transportista != null && cliente != null && depositoDestino != null && depositoDestino != null)) {
                    String estadoPedido = depositoOrigen.getSectores().get(0).getDescripcion();
                    Seguimiento seguimiento = new Seguimiento(LocalDate.of(2023, 10, 20), depositoOrigen.getPosicion().getLatitud(), depositoOrigen.getPosicion().getLongitud());
                    Pedido pedido = new Pedido(numeroPedido,cliente,depositoOrigen,depositoDestino,transportista,estadoPedido, seguimiento);
                    pedido.setInicioPedido(LocalDate.now());


                    do {
                        System.out.println("Por favor ingrese el producto");
                        productoController.buscarTodosLosProductos();
                        String codigoProducto = scanner.nextLine();
                        System.out.println("Por favor ingrese la cantidad");
                        int cantidadProducto = scanner.nextInt();
                        scanner.nextLine();
                        LineaPedido lineaPedido = new LineaPedido(productoController.buscarProductoPorCodigo(codigoProducto), cantidadProducto);
                        if (lineaPedido.getProducto()!=null){
                            pedido.getLineasPedidos().add(lineaPedido);
                        }
                        System.out.println("----------------------------");
                        System.out.println("Desea seguir agregando productos?");
                        System.out.println("1.SI");
                        System.out.println("2.NO");
                        System.out.println("----------------------------");
                        seguirAgregandoProductos = scanner.nextInt();
                        scanner.nextLine();
                    } while (seguirAgregandoProductos == 1);
                    if (pedido.getLineasPedidos().isEmpty()){
                        System.out.println("Error, vuelva a intentarlo nuevamente");
                        break;
                    }
                    pedidoController.crearPedido(pedido);
                } else {
                    System.out.println("Error, vuelva a intentarlo nuevamente");
                    break;
                }

                break;

            case "2":
                System.out.println("Por favor ingrese el numero del pedido para procesarlo");
                String nroPedido = scanner.nextLine();
                System.out.println("Por favor asigne el empleado a cargo");
                empleadoService.mostrarEmpleados();
                String cuitEmpleado = scanner.nextLine();

                Pedido pedidoEncontrado = pedidoController.buscarPedidoPorNumero(nroPedido);
                Empleado empleado = empleadoRepository.buscarEmpleadoPorCuit(cuitEmpleado);

                if ((pedidoEncontrado!=null && empleado!=null) && pedidoEncontrado.getEstadoPedido().equals("Pendiente")){
                    pedidoController.procesarPedido(nroPedido, cuitEmpleado);
                    System.out.println("El pedido fue procesado");
                } else {
                    System.out.println("El pedido no se pudo procesar, intentelo nuevamente");
                }
                break;

            case "3":
                System.out.println("Por favor ingrese el numero del pedido para completarlo");
                String nroPedidoCompletar = scanner.nextLine();
                Pedido pedidoCompletarPedido = pedidoController.buscarPedidoPorNumero(nroPedidoCompletar);
                if ((pedidoCompletarPedido!=null) && pedidoCompletarPedido.getEstadoPedido().equals("En Proceso")){
                    pedidoController.completarPedido(nroPedidoCompletar);
                    System.out.println("El pedido fue completado");
                } else {
                    System.out.println("El pedido no se pudo completar, intentelo nuevamente");
                }
                break;
            case"4":
                System.out.println("Por favor ingrese el numero del pedido para enviarlo a despacho");
                String nroPedidoEnviarADespacho = scanner.nextLine();
                Pedido pedidoEnviarADespacho = pedidoController.buscarPedidoPorNumero(nroPedidoEnviarADespacho);
                if ((pedidoEnviarADespacho!=null) && pedidoEnviarADespacho.getEstadoPedido().equals("Completo")){
                    pedidoController.enviarADespacho(nroPedidoEnviarADespacho);
                    System.out.println("El pedido fue enviado a despacho");
                } else {
                    System.out.println("El pedido no se pudo enviar a despacho, intentelo nuevamente");
                }
                break;
            case "5":
                System.out.println("Por favor ingrese el número del pedido para despacharlo");
                String nroPedidoDespacho = scanner.nextLine();
                Pedido pedidoDespacho = pedidoController.buscarPedidoPorNumero(nroPedidoDespacho);
                if ((pedidoDespacho != null )&& pedidoDespacho.getEstadoPedido().equals("Esperando Despacho")) {
                    pedidoController.despacharPedido(nroPedidoDespacho);
                    System.out.println("El pedido fue despachado");
                } else {
                    System.out.println("El pedido no se encontró, intentelo nuevamente");
                }
                break;
            case "6":
                System.out.println("Por favor ingrese el número del pedido para enviarlo a transito");
                String nroPedidoTransito = scanner.nextLine();
                Pedido pedidoTransito = pedidoController.buscarPedidoPorNumero(nroPedidoTransito);
                if ((pedidoTransito != null) && pedidoTransito.getEstadoPedido().equals("Despacho")){
                    pedidoController.transitarPedido(nroPedidoTransito);
                    System.out.println("Pedido enviado a transito");
                } else {
                    System.out.println("El pedido no se encontró, intentelo nuevamente");
                }

                break;
            case "7":
                    System.out.println(" Por favor ingrese el numero del pedido para enviarlo a entrega ");
                    String numeroPedidoEnviarAEntrega = scanner.nextLine();
                System.out.println("Por favor ingrese el CUIT del empleado receptor:");
                String cuitEmpleadoReceptor = scanner.nextLine();
                    Pedido pedidoEnviarAEntrega = pedidoController.buscarPedidoPorNumero(numeroPedidoEnviarAEntrega);
                    if ((pedidoEnviarAEntrega != null && empleadoRepository.buscarEmpleadoPorCuit(cuitEmpleadoReceptor)!=null) && pedidoEnviarAEntrega.getEstadoPedido().equals("En transito")){
                        pedidoController.enviarAEntrega(numeroPedidoEnviarAEntrega, cuitEmpleadoReceptor);
                        System.out.println("El pedido fue enviado a entrega");
                    } else {
                        System.out.println("El pedido no se encontró, intentelo nuevamente");
                    }
                    break;

            case "8":
                System.out.println("Por favor ingrese el número del pedido para entregarlo");
                String nroPedidoEntregar = scanner.nextLine();
                Pedido pedidoEntregar = pedidoController.buscarPedidoPorNumero(nroPedidoEntregar);
                if ((pedidoEntregar != null) && pedidoEntregar.getEstadoPedido().equals("Esperando Entrega")){
                    List<LineaPedido> lineasPedido = pedidoEntregar.getLineasPedidos();
                    List<Integer> calificacionesProveedor = new ArrayList<>();

                    for (LineaPedido lineaPedido : lineasPedido) {
                        System.out.println("Por favor ingrese la calificación del proveedor del producto " + lineaPedido.getProducto().getNombre() + " :");
                        int calificacion = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea
                        calificacionesProveedor.add(calificacion);
                    }

                    pedidoController.entregarPedido(nroPedidoEntregar, calificacionesProveedor);
                    System.out.println("El pedido fue entregado");
                    System.out.println(pedidoEntregar.toString());
                } else {
                    System.out.println("El pedido no se encontró, intentelo nuevamente");
                }
                break;
            case"9":
                CalcularDistancia calcularDistancia = new CalcularDistancia();
                System.out.println("Por favor ingrese el número del pedido para calcular la distancia");
                String nroPedidoDistancia = scanner.nextLine();
                Pedido pedidoDistancia = pedidoController.buscarPedidoPorNumero(nroPedidoDistancia);
                if (pedidoDistancia!=null){

                    System.out.println("El pedido se encuentra a "
                            +Math.round(calcularDistancia.calcularDistancia(pedidoDistancia.getSeguimiento().getLatitud()
                            ,pedidoDistancia.getSeguimiento().getLongitud()
                            ,pedidoDistancia.getDepositoDestino().getPosicion().getLatitud()
                            ,pedidoDistancia.getDepositoDestino().getPosicion().getLongitud())) + " kms de la sucursal destino");
                } else {
                    System.out.println("El pedido no se encontró, intentelo nuevamente");
                }
            case "10":
                System.out.println("Por favor ingrese el código de la sucursal para obtener la cantidad de pedidos realizados:");
                String codigoSucursal = scanner.nextLine();
                int cantidadPedidos = pedidoController.obtenerCantidadPedidoPorSucursal(codigoSucursal);
                System.out.println("La cantidad de pedidos realizados por la sucursal con código " + codigoSucursal + " es: " + cantidadPedidos);
                break;
            case "11":
                int cantidadPedidosPendientes = pedidoController.contarPedidosEnEstadoPendiente();
                System.out.println("La cantidad de pedidos en estado Pendiente es: " + cantidadPedidosPendientes);
                break;

            default:
                System.out.println("Opción inválida. Por favor, ingrese una opción válida del menú.");
                break;



    }
}

        }





