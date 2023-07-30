package org.example.repository;


import org.example.model.Cliente;
import org.example.model.Pedido;


import java.util.List;

public class InformeRepository {
    private PedidoRepository pedidoRepository;
    private ClienteRepository clienteRepository;
    private ProductoRepository productoRepository;


    public InformeRepository(PedidoRepository pedidoRepository, ClienteRepository clienteRepository, ProductoRepository productoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.productoRepository = productoRepository;
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
       Cliente clienteBuscado = clienteRepository.findOne(cuit);
       int contador = 0;
       for (Pedido pedido: pedidoRepository.obtenerTodosLosPedidos()
       ) {
           if (pedido.getCliente().getCuit().equals(clienteBuscado.getCuit()) && pedido.getEstadoPedido().equals("Entrega")){
               contador++;
           }
       }
       return contador;
   }

    public void mostrarEstadoDePedidos(){
        for (Pedido pedido: pedidoRepository.obtenerTodosLosPedidos()
             ) {

        }
    }
}