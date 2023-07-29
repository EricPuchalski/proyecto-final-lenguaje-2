package org.example;

import controller.*;
import model.*;
import repository.*;
import service.*;
import util.CalcularDistancia;
import view.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    //COMENTARIO RANDOM
    //NUEVO COMENTARIO
    public static void main(String[] args) {

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
        PedidoService pedidoService = new PedidoService(sectorRepository, transportistaRepository,pediddoRepository, new EmpleadoRepository());
        PedidoController pedidoController = new PedidoController(pedidoService);
        MenuCliente menuCliente = new MenuCliente(clienteController);
        MenuTransportista menuTransportista = new MenuTransportista(transportistaController, pedidoController);
        MenuProducto menuProducto = new MenuProducto(productoController);
        MenuPedido menuPedido=  new MenuPedido(pedidoController, depositoController, sectorRepository, transportistaController, productoController, clienteController, new EmpleadoRepository(),new EmpleadoService(new EmpleadoRepository()));
        InformeRepository informeRepository=new InformeRepository(pediddoRepository);
        InformeService informeService=new InformeService(informeRepository);
        InformeController informeController=new InformeController(informeService);
        MenuInforme menuInforme=new MenuInforme(informeController);
        MenuPrincipal menuPrincipal = new MenuPrincipal(menuCliente, menuTransportista, menuProducto, menuPedido,menuInforme);





//package com.company.repository;
//
//import java.util.List;
//
//        public interface CRUD <T>{
//            T findOne(String id);
//            List<T> findAll();
//            T save(T t);
//            T delete(String id);
//            T update(T t);
//            void upload();
//        }
        menuPrincipal.mostrarMenuPrincipal();
        informeRepository.obtenerHistorialDeUnCliente();


    }


    }
}
