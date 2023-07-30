package org.example.service;

import org.example.model.Cliente;
import org.example.model.Deposito;
import org.example.model.Sector;
import org.example.repository.DepositoRepository;

import java.util.ArrayList;
import java.util.List;

public class DepositoService implements CRUD<Deposito>{
    private DepositoRepository depositoRepository;

    public DepositoService(DepositoRepository depositoRepository) {
        this.depositoRepository = depositoRepository;
    }

    public void save(Deposito deposito) {
        if (findOne(deposito.getCodigo()) == null) {
            depositoRepository.save(deposito);
        }
    }

    public List<Deposito> findAll() {
        List<Deposito> depositoList = new ArrayList<>();
        for (Deposito dp : depositoRepository.findAll()) {
            System.out.println(dp.toString());
        }
        return depositoList;
    }


    public Deposito findOne(String codigo) {
        Deposito deposito = null;
        if (depositoRepository.findOne(codigo) != null) {
            deposito = depositoRepository.findOne(codigo);
        }
        return deposito;
    }


    public void upDate(Deposito deposito) {
        if (findOne(deposito.getCodigo()) != null) {
            depositoRepository.upDate(deposito);
        }
    }

    public void delete(String codigo) {
        if (findOne(codigo) != null) {
            depositoRepository.delete(codigo);
        }
    }
    public List<Sector> buscarSectoresDeUnDepositoPorCodigo(String codigo){
        List<Sector> sectoresDelDeposito = depositoRepository.buscarSectoresDeUnDepositoPorCodigo(codigo);
        if (!sectoresDelDeposito.isEmpty()){
            for (Sector sector: sectoresDelDeposito
            ) {
                System.out.println("Sectores del deposito: "+ sector.getDescripcion());
            }
        } else{
            System.out.println("EL deposito no tiene sectores");
        }
        return sectoresDelDeposito;
    }


}
