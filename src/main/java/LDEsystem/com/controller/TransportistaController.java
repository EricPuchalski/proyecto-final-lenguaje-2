package LDEsystem.com.controller;

import LDEsystem.com.model.Transportista;
import LDEsystem.com.service.TransportistaService;
import LDEsystem.com.util.CRUD;

import java.util.List;

public class TransportistaController implements CRUD<Transportista> {
    private TransportistaService transportistaService;

    public TransportistaController(TransportistaService transportistaService) {
        this.transportistaService = transportistaService;
    }

    public void save(Transportista transportista){
        transportistaService.save(transportista);
    }


    public Transportista findOne(String cuit){
        return transportistaService.findOne(cuit);
    }

    public void delete(String cuit){
        transportistaService.delete(cuit);
    }

    public List<Transportista> findAll(){
        return transportistaService.findAll();
    }
    public List<Transportista> findAllOff(){
        return transportistaService.findAllOff();
    }


    public void upDate(Transportista transportista) {
        transportistaService.upDate(transportista);
    }

}
