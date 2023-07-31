package LDEsystem.com.controller;

import LDEsystem.com.service.EmpleadoService;
import LDEsystem.com.model.Empleado;
import LDEsystem.com.util.CRUD;

import java.util.List;

public class EmpleadoController implements CRUD<Empleado> {
    EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @Override
    public void save(Empleado empleado) {
        empleadoService.save(empleado);
    }

    @Override
    public Empleado findOne(String id) {
        return empleadoService.findOne(id);
    }

    @Override
    public List<Empleado> findAll() {
        return empleadoService.findAll();
    }


    @Override
    public void upDate(Empleado empleado) {
        empleadoService.upDate(empleado);

    }

    @Override
    public void delete(String id) {
        empleadoService.delete(id);

    }
}
