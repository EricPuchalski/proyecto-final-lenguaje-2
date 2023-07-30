package LDEsystem.com.controller;

import LDEsystem.com.model.Transportista;
import LDEsystem.com.service.TransportistaService;

public class TransportistaController {
    private TransportistaService transportistaService;

    public TransportistaController(TransportistaService transportistaService) {
        this.transportistaService = transportistaService;
    }

    public void create(Transportista transportista){
        transportistaService.save(transportista);
    }

    public Transportista findOne(String cuit){
        return transportistaService.findOne(cuit);
    }

    public void delete(String cuit){
        transportistaService.delete(cuit);
    }

    public void findAll(){
        transportistaService.findAll();
    }
    public void findAllOff(){
        transportistaService.findAllOff();
    }

    public void upDate(Transportista transportista) {
        transportistaService.upDate(transportista);
    }

}
