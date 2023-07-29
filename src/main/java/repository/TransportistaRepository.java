package repository;

import model.CategoriaProducto;
import model.TipoTransportista;
import model.Transportista;
import service.TransportistaService;

import java.util.ArrayList;
import java.util.List;

public class TransportistaRepository {
    private List<Transportista> transportistas;
    private List<TipoTransportista> tipoTransportistas;
    public TransportistaRepository() {
        this.transportistas = new ArrayList<>();
        this.tipoTransportistas= new ArrayList<>();
        cargarTransportistas();

    }



    public void cargarTransportistas(){
        TipoTransportista terrestre = new TipoTransportista("Terrestre");
        TipoTransportista aereo = new TipoTransportista("Aereo");
        TipoTransportista maritimo = new TipoTransportista("Maritimo");

        tipoTransportistas.add(aereo);
        tipoTransportistas.add(maritimo);
        tipoTransportistas.add(terrestre);

        Transportista t1 = new Transportista("12321","Correo Argentino","12342", "dsads@gmail.com", terrestre);
        Transportista t2 = new Transportista("3213","OCA","4352", "ds@gmail.com",aereo);
        Transportista t3 = new Transportista("232","OCASA","7653432", "asd@gmail.com",aereo);
        Transportista t4 = new Transportista("34","AMAZON","4235234", "34@gmail.com",maritimo);
        Transportista t5 = new Transportista("676","DHL","12321", "dsadds@gmail.com",terrestre);


//        Transportista t1 = new Transportista("12321","Juan","12342", "dsads@gmail.com", Transportista.tipoTransportista.AEREO);
//        Transportista t2 = new Transportista("3213","Julian","4352", "ds@gmail.com", Transportista.tipoTransportista.TERRESTRE);
//        Transportista t3 = new Transportista("232","Kenneth","7653432", "asd@gmail.com", Transportista.tipoTransportista.MARITIMO);
//        Transportista t4 = new Transportista("34","Jose","4235234", "34@gmail.com", Transportista.tipoTransportista.AEREO);
//        Transportista t5 = new Transportista("676","Pia","12321", "dsadds@gmail.com", Transportista.tipoTransportista.TERRESTRE);
//        Transportista t6 = new Transportista("988","Margarita","54532", "d54s@gmail.com", Transportista.tipoTransportista.MARITIMO);
//        Transportista t7 = new Transportista("57","Juana","123124", "ddwe@gmail.com", Transportista.tipoTransportista.AEREO);
//        Transportista t8 = new Transportista("1289","Luisa","765", "d34s@gmail.com", Transportista.tipoTransportista.TERRESTRE);
//        Transportista t9 = new Transportista("3478","Luisa","32423", "wwds@gmail.com", Transportista.tipoTransportista.TERRESTRE);

        transportistas.add(t1);
        transportistas.add(t2);
        transportistas.add(t3);
        transportistas.add(t4);
        transportistas.add(t5);



    }
    public void guardarTransportista(Transportista transportista){
        transportistas.add(transportista);
    }

    public List<Transportista> buscarTodosLosTransportistas(){
        return transportistas;
    }

    public Transportista buscarTransportistaPorCuit(String cuit){
        for (Transportista t: transportistas
             ) {
            if (t.getCuit().equals(cuit)){
                return t;
            }
        }
        return null;
    }

    public void eliminarTransportistaPorCuit(String cuit){
        transportistas.remove(buscarTransportistaPorCuit(cuit));
    }

    public void editarTransportista(Transportista transportista) {
        Transportista transportistaExistente = buscarTransportistaPorCuit(transportista.getCuit());
        if (transportistaExistente != null) {
            transportistaExistente.setNombre(transportista.getNombre());
            transportistaExistente.setTelefono(transportista.getTelefono());
            transportistaExistente.setEmail(transportista.getEmail());
            transportistaExistente.setTipo(transportista.getTipo());
        }
    }


}
