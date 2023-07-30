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
        if (findOne(transportista.getCuit())!=null) {
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
        List<Transportista>transportistaList = new ArrayList<>();
        for(Transportista tr : transportistaRepository.findAll()){
            System.out.println(tr.toString());
        }

        return transportistaList;
    }

    @Override
    public List<Transportista> findAllOff() {
        List<Transportista>transportistaList = new ArrayList<>();
        for(Transportista tr : transportistaRepository.findAllOff()){
            System.out.println(tr.toString());
        }

        return transportistaList;
    }

    @Override
    public void delete(String cuit) {
        if (findOne(cuit)!= null){
            transportistaRepository.delete(cuit);
        }
    }
}