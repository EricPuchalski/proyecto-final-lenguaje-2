package service;

import model.Cliente;
import model.LineaPedido;
import model.Pedido;
import repository.*;

import java.util.ArrayList;
import java.util.List;

public class PedidoService {
    private SectorRepository sectorRepository;
    private TransportistaRepository transportistaRepository;
    private PedidoRepository pedidoRepository;

    private EmpleadoRepository empleadoRepository;

    private Pedido pedido;

    public PedidoService(SectorRepository sectorRepository, TransportistaRepository transportistaRepository , PedidoRepository pedidoRepository, EmpleadoRepository empleadoRepository) {
        this.sectorRepository = sectorRepository;
        this.transportistaRepository = transportistaRepository;
        this.pedidoRepository=pedidoRepository;
        this.empleadoRepository = empleadoRepository;
    }

    public void crearPedido(Pedido pedido) {
        if (pedidoRepository.buscarPedidoPorNumero(pedido.getNumeroPedido()) != null) {
            System.out.println("El Pedido con el número ingresado ya existe");
        } else if (pedido.getCliente() == null) {
            System.out.println("El cliente no está asignado al pedido. Asigne un cliente válido.");
        } else {
            System.out.println("El pedido se creó correctamente");
            pedidoRepository.crearPedido(pedido);
        }
    }

    public List<Pedido> obtenerTodosLosPedidos() {
        List<Pedido> pedidosEncontrados = new ArrayList<>();
        for (Pedido pedido: pedidoRepository.obtenerTodosLosPedidos()
             ) {
            pedidosEncontrados.add(pedido);
            System.out.println(pedido.toString());
        }
        return pedidosEncontrados;
    }

    public void agregarLineaDePedido(Pedido pedido, LineaPedido lineaPedido) {
        pedidoRepository.crearLineaPedido(pedido,lineaPedido);
    }


    public Pedido buscarPedidoPorNumero(String numero) {
        Pedido pedido = pedidoRepository.buscarPedidoPorNumero(numero);
        if (pedido == null) {
            return null;
        } else {
            return pedido;
        }
    }

    public void procesarPedido(String numero, String cuitEmpleado){
            pedidoRepository.procesarPedido(numero, cuitEmpleado);
    }

    public void completarPedido(String numero){
        pedidoRepository.completarPedido(numero);
    }

    public void enviarADespacho(String numero) {
        Pedido pedidoEncontrado = pedidoRepository.buscarPedidoPorNumero(numero);
        if (pedidoEncontrado != null) {
            pedidoRepository.enviarADespacho(numero);
        }
    }

    public void despacharPedido(String numero) {
        Pedido pedidoEncontrado = pedidoRepository.buscarPedidoPorNumero(numero);
        if (pedidoEncontrado != null) {
            pedidoRepository.despacharPedido(numero);

        }
    }

    public void enviarAEntrega(String numero, String cuitEmpleadoReceptor) {
        Pedido pedidoEncontrado = pedidoRepository.buscarPedidoPorNumero(numero);
        if (pedidoEncontrado != null) {
            pedidoRepository.enviarAEntrega(numero, cuitEmpleadoReceptor);
        }
    }

    public void entregarPedido(String numero, List<Integer> calificacionesProveedor) {
        Pedido pedidoEncontrado = pedidoRepository.buscarPedidoPorNumero(numero);
        if (pedidoEncontrado != null) {
            pedidoRepository.entregarPedido(numero, calificacionesProveedor);
        }
    }


    public void transitarPedido(String numero){
        pedidoRepository.transitarPedido(numero);
    }

    public int obtenerCantidadPedidosPorSucursal(String codigoSucursal) {
        return pedidoRepository.obtenerCantidadPedidosPorSucursal(codigoSucursal);
    }
    public int contarPedidosEnEstadoPendiente(){
        return pedidoRepository.contarPedidosEnEstadoPendiente();
    }


}


