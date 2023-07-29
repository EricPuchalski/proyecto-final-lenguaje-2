package repository;

import lombok.Getter;
import lombok.Setter;
import model.Deposito;
import model.Posicion;
import model.Sector;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
public class DepositoRepository {
    private List<Deposito> depositos;
    private SectorRepository sectorRepository;
    public DepositoRepository() {
        this.depositos = new ArrayList<>();
        this.sectorRepository = new SectorRepository();
        cargarDeposito();
    }

    public void cargarDeposito(){


        Deposito deposito1 = new Deposito("1","Deposito China","Calle 1","34543534","depositoCH@gmail.com", "Asia",new Posicion(39.900853,116.399813));
        Deposito deposito2 = new Deposito("2","Deposito Australia","San martin 2324","1232312","depositoAU@gmail.com", "Oceania", new Posicion(-22.593680,144.544854));
        Deposito deposito3 = new Deposito("3","Deposito Argentina","San juan 2324","4132","depositoAR@gmail.com", "America",  new Posicion(-34.537211,-58.547629));

        Deposito deposito4 = new Deposito("4", "Deposito Sudafrica", "Av. Colón 1234", "3512345678", "depositoSA@gmail.com", "Africa", new Posicion(-30.849319,24.201486));
        Deposito deposito5 = new Deposito("5", "Deposito España", "Av. San Martín 4321", "2612345678", "depositoES@gmail.com", "Europa",new Posicion(39.514578,-2.490630));


        deposito1.getSectores().addAll(sectorRepository.findAll());
        deposito2.getSectores().addAll(sectorRepository.findAll());
        deposito3.getSectores().addAll(sectorRepository.findAll());
        deposito4.getSectores().addAll(sectorRepository.findAll());
        deposito5.getSectores().addAll(sectorRepository.findAll());

        depositos.add(deposito1);
        depositos.add(deposito2);
        depositos.add(deposito3);
        depositos.add(deposito4);
        depositos.add(deposito5);
    }


    public void guardarDeposito(Deposito deposito){
       depositos.add(deposito);
    }

    public Deposito buscarDepositoPorCodigo(String codigo){
        for (Deposito deposito: depositos
             ) {
            if (deposito.getCodigo().equals(codigo)){
                return deposito;
            }
        }
        return null;
    }
    public List<Sector> buscarSectoresDeUnDepositoPorCodigo(String codigo){
        List<Sector> sectoresDelDeposito = new ArrayList<>();
        Deposito deposito = buscarDepositoPorCodigo(codigo);
        for (Sector sector: deposito.getSectores()
             ) {
            sectoresDelDeposito.add(sector);
        }
        return sectoresDelDeposito;
    }


    public List<Deposito> buscarTodosLosDepositos(){
        return depositos;
    }

    public void eliminarDepositoPorCodigo(Deposito deposito){
        depositos.remove(deposito);
    }

    public void editarDepositoPorCodigo(Deposito deposito){
        Deposito depositoEditado = buscarDepositoPorCodigo(deposito.getCodigo());
        if (depositoEditado!=null){
            depositoEditado.setNombre(deposito.getNombre());
            depositoEditado.setDireccion(deposito.getDireccion());
            depositoEditado.setTelefono(deposito.getTelefono());
            depositoEditado.setEmail(deposito.getEmail());
            depositoEditado.setSectores(deposito.getSectores());
        }
    }
}
