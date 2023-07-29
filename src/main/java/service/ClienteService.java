package service;

import model.Cliente;
import repository.ClienteRepository;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class  ClienteService {
    private ClienteRepository clienteRepository;


    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository =clienteRepository;
    }



    public List<Cliente> buscarTodosLosClientes(){
        for (Cliente cliente: clienteRepository.buscarTodosLosClientes()
             ) {
            System.out.println(cliente);
        }
        return clienteRepository.buscarTodosLosClientes();
    }

    public Cliente buscarClientePorCuit(String cuit) {
        Cliente cliente = clienteRepository.buscarClientePorCuit(cuit);
        if (cliente == null) {
            System.out.println("No se encontró ningún cliente con el CUIT: " + cuit);
            return null;
        } else {
            return cliente;
        }

    }


    public void crearCliente(Cliente cliente) {
        if (clienteRepository.buscarClientePorCuit(cliente.getCuit())!=null){
            System.out.println("El cliente con el cuit ingresado ya existe");

        } else{
            System.out.println("El cliente se creó correctamente");
            clienteRepository.crearCliente(cliente);
        }
    }


    public void editarCliente(Cliente cliente) {
        clienteRepository.editarCliente(cliente);
    }

    public void deshabilitarClientePorCuit(String cuit) {
        clienteRepository.deshabilitarClientePorCuit(cuit);
    }


}

