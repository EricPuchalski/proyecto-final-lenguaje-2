package controller;

import model.Cliente;
import service.ClienteService;

import java.util.List;

public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public Cliente buscarClientePorCuit(String cuit){
        return clienteService.buscarClientePorCuit(cuit);
    }

    public List<Cliente> buscarTodosLosClientes() {
        return clienteService.buscarTodosLosClientes();
    }

    public void deshabilitarClientePorCuit(String cuit) {
        clienteService.deshabilitarClientePorCuit(cuit);
    }

    public  void crearCliente(Cliente cliente){
        clienteService.crearCliente(cliente);
    }
    public void editarCliente(Cliente cliente) {
        clienteService.editarCliente(cliente);
    }

//    public Cliente editarClientePorCuit(String cuit){
//        return clienteService.editarClientePorCuit(cuit);
//    }
}
