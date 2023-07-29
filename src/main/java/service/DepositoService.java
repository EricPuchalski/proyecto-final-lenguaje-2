package service;

import model.Cliente;
import model.Deposito;
import model.Sector;
import repository.DepositoRepository;

import java.util.ArrayList;
import java.util.List;

public class DepositoService {
    private DepositoRepository depositoRepository;

    public DepositoService(DepositoRepository depositoRepository) {
        this.depositoRepository = depositoRepository;
    }

    public void crearDeposito(Deposito deposito){
        if(depositoRepository.buscarDepositoPorCodigo(deposito.getCodigo())!=null){
            System.out.println("El deposito con el codigo ingresado ya existe");
        } else {
            System.out.println("El deposito se creó correctmaente");
            depositoRepository.guardarDeposito(deposito);
        }
    }


    public Deposito buscarDepositoPorCodigo(String codigo){
        Deposito depositoEncontrado = depositoRepository.buscarDepositoPorCodigo(codigo);
        if (depositoEncontrado!= null){
//            System.out.println("El deposito buscado es: "+depositoEncontrado.toString() +depositoRepository.buscarSectoresDeUnDepositoPorCodigo(codigo));
            return depositoEncontrado;
        }
        return null;
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

    public List<Deposito> buscarTodosLosDepositos() {
        List<Deposito> depositos = depositoRepository.buscarTodosLosDepositos();
            for (Deposito deposito : depositos) {
                System.out.println(deposito.toString());
            }
        return depositos;
    }

    public void eliminarDepositoPorCodigo(String codigo){
        depositoRepository.eliminarDepositoPorCodigo(depositoRepository.buscarDepositoPorCodigo(codigo));
    }

    public void editarDepositoPorCodigo(Deposito deposito){
        depositoRepository.editarDepositoPorCodigo(deposito);
    }

}
