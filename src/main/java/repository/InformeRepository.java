package repository;

import model.Cliente;
import model.Pedido;

import java.util.List;

public class InformeRepository {
    private PedidoRepository pedidoRepository;
    private ClienteRepository clienteRepository;

    public InformeRepository(PedidoRepository pedidoRepository, ClienteRepository clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
    }

    public int obtenerCantidadPedidosPorSucursal(String codigoSucursal) {
        int cantidadPedidos = 0;
        List<Pedido> pedidos = pedidoRepository.obtenerTodosLosPedidos();
        for (Pedido pedido : pedidos) {
            if (pedido.getDepositoOrigen().getCodigo().equals(codigoSucursal)) {
                cantidadPedidos++;
            }
        }
        return cantidadPedidos;
    }

    public int contarPedidosEnEstadoPendiente() {
        int contador = 0;
        List<Pedido> pedidos = pedidoRepository.obtenerTodosLosPedidos();
        for (Pedido pedido : pedidos) {
            if (pedido.getEstadoPedido().equals("Pendiente")) {
                contador++;
            }
        }
        return contador;
    }
   /* public void obtenerHistorialDeUnCliente(String cuit){
        Cliente clienteBuscado = clienteRepository.buscarClientePorCuit(cuit);
        if(clienteBuscado!=null){
            for (Pedido pedido: pedidoRepository.obtenerTodosLosPedidos()
            ) {
                for (LineaPedido lineaPedido: pedido.getLineasPedidos()
                ) {
                    if (pedido.getCliente().getCuit().equals(clienteBuscado.getCuit())){
                        System.out.println(linea

    */
   public int obtenerHistorialDeUnCliente(String cuit){
       Cliente clienteBuscado = clienteRepository.buscarClientePorCuit(cuit);
       int contador = 0;
       for (Pedido pedido: pedidoRepository.obtenerTodosLosPedidos()
       ) {
           if (pedido.getCliente().getCuit().equals(clienteBuscado.getCuit()) && pedido.getEstadoPedido().equals("Entrega")){
               contador++;
           }
       }
       return contador;


   }
}