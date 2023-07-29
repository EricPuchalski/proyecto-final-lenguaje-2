package service;

import model.Transportista;
import repository.TransportistaRepository;

import java.util.Scanner;

public class TransportistaService {

    private TransportistaRepository transportistaRepository;
    private Transportista transportista;
    private Scanner scanner;

    public TransportistaService(TransportistaRepository transportistaRepository) {
        this.transportistaRepository = transportistaRepository;
    }

    public void buscarTodosLosTransportistas() {
        for (Transportista t : transportistaRepository.buscarTodosLosTransportistas()
        ) {
            System.out.println(t.toString());
        }
    }


    public Transportista buscarTransportistaPorCuit(String cuit) {
        Transportista transportistaBuscado = transportistaRepository.buscarTransportistaPorCuit(cuit);
        if (transportistaBuscado != null) {
            System.out.println(transportistaBuscado.toString());
            return transportistaBuscado;
        } else {
            return null;
        }
    }

    public void crearTransportista(Transportista transportista) {
        if (transportistaRepository.buscarTransportistaPorCuit(transportista.getCuit()) == null) {
            transportistaRepository.guardarTransportista(transportista);
        } else {
            System.out.println("Ya existe un transportista con el cuit ingresado");
        }
    }

    public void eliminarTransportistaPorCuit(String cuit) {
//        Transportista transportistaEliminado = ;
        if (transportistaRepository.buscarTransportistaPorCuit(cuit) != null) {
            System.out.println("Se eliminó el : " + transportistaRepository.buscarTransportistaPorCuit(cuit).toString());
            transportistaRepository.eliminarTransportistaPorCuit(cuit);
        } else {
            System.out.println("El cuit ingresado no corresponde con ningun transportista");
        }
    }

    public void editarTransportistaPorCuit(Transportista transportista) {
        transportistaRepository.editarTransportista(transportista);
    }
}