package controller;

import model.Deposito;
import model.Sector;
import service.DepositoService;

import java.util.List;

public class DepositoController {
    private DepositoService depositoService;

    public DepositoController(DepositoService depositoService) {
        this.depositoService = depositoService;
    }

    public void crearDeposito(Deposito deposito){
        depositoService.crearDeposito(deposito);
    }

    public Deposito buscarDepositoPorCodigo(String codigo){
        return depositoService.buscarDepositoPorCodigo(codigo);
    }

    public List<Sector> buscarSectoresDeUnDepositoPorCodigo(String codigo){
        return depositoService.buscarSectoresDeUnDepositoPorCodigo(codigo);
    }

    public void eliminarDepositoPorCodigo(String codigo){
        depositoService.eliminarDepositoPorCodigo(codigo);
    }

    public void editarDepositoPorCodigo(Deposito deposito){
        depositoService.editarDepositoPorCodigo(deposito);
    }

    public List<Deposito> buscarTodosLosDepositos(){
        return depositoService.buscarTodosLosDepositos();
    }
}
