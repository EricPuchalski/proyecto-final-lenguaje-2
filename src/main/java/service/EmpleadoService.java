package service;

import model.Empleado;
import repository.EmpleadoRepository;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoService {
    private EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = new EmpleadoRepository();
    }

    public List<Empleado> mostrarEmpleados(){
        List listaEmpleados = new ArrayList<>();
        for (Empleado empleado: empleadoRepository.buscarTodosLosEmpleados()
             ) {
            System.out.println(empleado.toString());
            listaEmpleados.add(empleado);
        }
        return listaEmpleados;
    }
}
