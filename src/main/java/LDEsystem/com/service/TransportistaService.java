package LDEsystem.com.service;


import LDEsystem.com.model.Transportista;
import LDEsystem.com.repository.TransportistaRepository;
import LDEsystem.com.util.CRUD;

import java.util.ArrayList;
import java.util.List;

public class TransportistaService implements CRUD<Transportista> {

    private TransportistaRepository transportistaRepository;
    private Transportista transportista;


    public TransportistaService(TransportistaRepository transportistaRepository) {
        this.transportistaRepository = transportistaRepository;
    }

    @Override
    public void save(Transportista transportista) {
        if (transportistaRepository.findOne(transportista.getCuit())== null) {
            transportistaRepository.save(transportista);
        }
    }

    @Override
    public void upDate(Transportista transportista) {
        if(findOne(transportista.getCuit()) != null){
            transportistaRepository.upDate(transportista);
        }
    }

    @Override
    public Transportista findOne(String cuit) {
        Transportista transportista= null;
        if (transportistaRepository.findOne(cuit)!= null) {
            transportista= transportistaRepository.findOne(cuit);

        }
        return transportista;
    }


    @Override
    public List<Transportista> findAll() {
        return transportistaRepository.findAll();
    }


    @Override
    public void delete(String cuit) {
        if (findOne(cuit)!= null){
            transportistaRepository.delete(cuit);
        }
    }
}