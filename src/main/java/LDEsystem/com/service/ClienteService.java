package LDEsystem.com.service;

import LDEsystem.com.model.Cliente;
import LDEsystem.com.repository.ClienteRepository;
import LDEsystem.com.util.CRUD;

import java.util.ArrayList;
import java.util.List;

public class  ClienteService implements CRUD<Cliente> {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }
    public void save(Cliente cliente){
        if (findOne(cliente.getCuit())!=null) {
            clienteRepository.save(cliente);
        }
    }


    public List<Cliente>findAll(){
        List<Cliente>clienteList = new ArrayList<>();
        for(Cliente cr : clienteRepository.findAll()){
            System.out.println(cr.toString());
        }

        return clienteList;
    }
    public List<Cliente>findAllOff(){
        List<Cliente>clienteList = new ArrayList<>();
        for(Cliente cr : clienteRepository.findAllOff()){
            System.out.println(cr.toString());
        }

        return clienteList;
    }
    public Cliente findOne(String cuit){
        Cliente cliente = null;
        if (clienteRepository.findOne(cuit)!=null) {
            cliente = clienteRepository.findOne(cuit);

        }
        return cliente;

    }


    public void upDate(Cliente cliente){
        if(findOne(cliente.getCuit()) != null){
            clienteRepository.upDate(cliente);
        }
    }
    public void delete(String cuit){
        if (findOne(cuit)!= null){
            clienteRepository.delete(cuit);
        }
    }
}

