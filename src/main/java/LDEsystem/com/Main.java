package LDEsystem.com;

import LDEsystem.com.controller.*;
import LDEsystem.com.repository.*;
import LDEsystem.com.service.*;
import LDEsystem.com.view.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("================Bienvenido a LDE System ==========================");
        ClienteRepository clienteRepository = new ClienteRepository();
        ClienteService clienteService = new ClienteService(clienteRepository);
        ClienteController clienteController = new ClienteController(clienteService);
        TransportistaRepository transportistaRepository = new TransportistaRepository();
        TransportistaService transportistaService = new TransportistaService(transportistaRepository);
        TransportistaController transportistaController = new TransportistaController(transportistaService);
        ProductoRepository productoRepository = new ProductoRepository();
        ProductoService productoService = new ProductoService(productoRepository);
        ProductoController productoController = new ProductoController(productoService);
        SectorRepository sectorRepository = new SectorRepository();
        DepositoRepository depositoRepository = new DepositoRepository();
        DepositoService depositoService= new DepositoService(depositoRepository);
        DepositoController depositoController = new DepositoController(depositoService);
        PedidoRepository pediddoRepository = new PedidoRepository();
        PedidoService pedidoService = new PedidoService( pediddoRepository);
        PedidoController pedidoController = new PedidoController(pedidoService);
        MenuCliente menuCliente = new MenuCliente(clienteController);
        MenuTransportista menuTransportista = new MenuTransportista(transportistaController, pedidoController);
        MenuProducto menuProducto = new MenuProducto(productoController);
        EmpleadoRepository empleadoRepository=new EmpleadoRepository();
        EmpleadoService empleadoService=new EmpleadoService(empleadoRepository);
        EmpleadoController empleadoController=new EmpleadoController(empleadoService);
        MenuPedido menuPedido=  new MenuPedido(pedidoController, depositoController, sectorRepository, transportistaController, productoController, clienteController,empleadoRepository,empleadoService,empleadoController);
        InformeRepository informeRepository=new InformeRepository(pediddoRepository, clienteRepository, productoRepository);
        InformeService informeService=new InformeService(informeRepository);
        InformeController informeController=new InformeController(informeService);
        MenuInforme menuInforme=new MenuInforme(informeController, clienteController, pedidoController);

        MenuPrincipal menuPrincipal = new MenuPrincipal(menuCliente, menuTransportista, menuProducto, menuPedido,menuInforme,new MenuProveedor(new ProveedorController(new ProveedorService(new ProveedorRepository()))));


        menuPrincipal.mostrarMenuPrincipal();

    }
}
