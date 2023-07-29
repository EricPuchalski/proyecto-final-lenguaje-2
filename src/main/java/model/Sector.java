package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Sector {

    private String codigo;
    private String descripcion;


    public Sector(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;

    }

    public Sector() {
    }

    @Override
    public String toString() {
        return "Sector{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
