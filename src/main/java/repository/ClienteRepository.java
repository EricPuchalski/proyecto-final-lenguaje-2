package repository;

import lombok.Getter;
import lombok.Setter;
import model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter

public class ClienteRepository {

    private List<Cliente> clientes;
    private boolean clienteExistente;
    public ClienteRepository() {
        this.clientes = new ArrayList<>();
        crearClientes();
    }

    public void crearClientes(){
        Cliente c1 = new Cliente("123","Eric", "Puch", "Josesito 232","3243242");
        Cliente c2 = new Cliente("32323","Juan", "Mendez", "San jose 34354","23435");
        Cliente c3 = new Cliente("234324","Elric", "Jalil", "Calle 150","34543543");
        Cliente c4 = new Cliente("3453","Carlos", "Perez", "Calle 32","653634");
        Cliente c5 = new Cliente("54634","Gustavo", "Lopez", "calle 09","6435345");
        Cliente c6 = new Cliente("534534","Pablo", "Gonzalez", "Bolivar 232","43543");
        Cliente c7 = new Cliente("543534","Martin", "Khea", "Calle 90","65454");
//        Cliente c8 = new Cliente(8,"Leo", "Messi", "Ayacucho 23453");
//        Cliente c9 = new Cliente(9,"German", "Rodriguez", "Costanera 2344");
//        Cliente c10 = new Cliente(10,"Eduardo", "Piriz", "Jose Sanchez 3445");
//        Cliente c11 = new Cliente(11,"Marc", "Maco", "Heinz 23534");
//        Cliente c12 = new Cliente(12,"Lionel", "Luck", "Sancor 6734");
//        Cliente c13 = new Cliente(13,"Adam", "Bareiro", "Mertens 2345");
//        Cliente c14 = new Cliente(14,"Elias", "Kya", "Marquez 2344");
//        Cliente c15 = new Cliente(15,"Eric", "Honda", "Cocomarola 234");
//        Cliente c16 = new Cliente(16,"Juan", "Renault", "Felix de azara 3544");
//        Cliente c17 = new Cliente(16,"Camila", "Arias", "Libertador 3456");


        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);
        clientes.add(c4);
        clientes.add(c5);
        clientes.add(c6);
        clientes.add(c7);
//        clientes.add(c8);
//        clientes.add(c9);
//        clientes.add(c10);
//        clientes.add(c11);
//        clientes.add(c12);
//        clientes.add(c13);
//        clientes.add(c14);
//        clientes.add(c15);
//        clientes.add(c16);
//        clientes.add(c17);

    }

    public void crearCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void deshabilitarClientePorCuit(String cuit) {
        Cliente clienteExistente = buscarClientePorCuit(cuit);
        if (clienteExistente != null) {
            clienteExistente.setEstado(Cliente.Estado.DESHABILITADO);
        }
    }
    public List<Cliente> buscarTodosLosClientes() {
        return clientes;
    }

    public Cliente buscarClientePorCuit(String cuit) {
        for (Cliente cliente : clientes) {
            if (cliente.getCuit().equals(cuit)) {
                return cliente;
            }
        }
        return null;
    }
    public void editarCliente(Cliente cliente) {
        Cliente clienteExistente = buscarClientePorCuit(cliente.getCuit());
        if (clienteExistente != null) {
            clienteExistente.setNombre(cliente.getNombre());
            clienteExistente.setApellido(cliente.getApellido());
            clienteExistente.setDireccion(cliente.getDireccion());
            clienteExistente.setTelefono(cliente.getTelefono());
    }
}

}
