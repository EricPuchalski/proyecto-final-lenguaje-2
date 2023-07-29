package controller;

import model.Transportista;
import service.TransportistaService;

public class TransportistaController {
    private TransportistaService transportistaService;

    public TransportistaController(TransportistaService transportistaService) {
        this.transportistaService = transportistaService;
    }

    public void crearTransportista(Transportista transportista){
        transportistaService.crearTransportista(transportista);
    }

    public Transportista buscarTransportistaPorCuit(String cuit){
        return transportistaService.buscarTransportistaPorCuit(cuit);
    }

    public void eliminarTransportistaPorCuit(String cuit){
        transportistaService.eliminarTransportistaPorCuit(cuit);
    }

    public void buscarTodosLosTransportistas(){
        transportistaService.buscarTodosLosTransportistas();
    }
    public void editarTransportistaPorCuit(Transportista transportista) {
        transportistaService.editarTransportistaPorCuit(transportista);
    }

}
