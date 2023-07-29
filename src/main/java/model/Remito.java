package model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class Remito {
    private String codigoDeEnvio;
    private LocalDate emision;
    private Transportista transportista;
    private Empleado empleadoEmisor;
    private Empleado empleadoReceptor;
    private int calificacionTransportista;
    private Pedido pedido;

    public Remito(LocalDate emision, Transportista transportista, Empleado empleadoEmisor, Empleado empleadoReceptor) {

        this.emision = emision;
        this.transportista = transportista;
        this.empleadoEmisor = empleadoEmisor;
        this.empleadoReceptor = empleadoReceptor;
    }
}
