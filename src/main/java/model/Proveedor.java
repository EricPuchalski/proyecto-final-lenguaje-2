package model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Proveedor {
    private String cuit;
    private String nombre;
    private String direccion;
    private String pais;

    public Proveedor(String cuit, String nombre,String pais, String direccion) {
        this.cuit = cuit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.pais = pais;
    }

    public Proveedor(){

    }

    @Override
    public String toString() {
        return  nombre +
                ". Cuit='" + cuit + '\'' +
                ", Direccion='" + direccion + '\'' +
                ", Pais='" + pais + '\'' +
                '}';
    }
}
