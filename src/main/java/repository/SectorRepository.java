package repository;


import lombok.Getter;
import lombok.Setter;
import model.Deposito;
import model.Sector;
import repository.DepositoRepository;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter

public class SectorRepository {
    private List<Sector> sectores;

    public SectorRepository() {
        sectores = new ArrayList<>();
        upload();
    }


    public void upload() {

            sectores.add(new Sector("1", "Pendiente"));
            sectores.add(new Sector("2", "En Proceso "));
            sectores.add(new Sector("3", "Completo "));
            sectores.add(new Sector("4", "Esperando Despacho "));
            sectores.add(new Sector("5", "Despacho "));
            sectores.add(new Sector("6", "Esperando Entrega "));
            sectores.add(new Sector("7", "Entrega "));

    }




    public void update(Sector sector) {
        for (Sector sr : sectores) {
            if (sr.getCodigo().equals(sector.getCodigo())) {
                sr.setDescripcion(sector.getDescripcion());
            }
        }
    }


    public List<Sector> findAll() {
        return sectores;
    }



    public Sector findOneB(String codigoSector) {
        for (Sector sr : sectores) {
            if (sr.getCodigo().equals(codigoSector)) {
                return sr;
            }
        }
        return null;
    }


}
