package org.example.service;

import org.example.model.Cliente;
import org.example.model.Empleado;
import org.example.repository.EmpleadoRepository;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoService implements CRUD<Empleado>{
    private EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = new EmpleadoRepository();
    }

    public List<Empleado> mostrarEmpleados(){
        List listaEmpleados = new ArrayList<>();
        for (Empleado empleado: empleadoRepository.findAll()
             ) {
            System.out.println(empleado.toString());
            listaEmpleados.add(empleado);
        }
        return listaEmpleados;
    }

    @Override
    public void save(Empleado empleado) {
        if (findOne(empleado.getCUIT())!=null) {
            empleadoRepository.save(empleado);
        }
    }

    @Override
    public void upDate(Empleado empleado) {
        if(findOne(empleado.getCUIT()) != null){
            empleadoRepository.upDate(empleado);
        }
    }

    @Override
    public Empleado findOne(String cuit) {
        Empleado empleado = null;
        if (findOne(cuit)!= null) {
            Empleado em = empleadoRepository.findOne(cuit);
            empleado = em;
        }
        return empleado;
    }

    @Override
    public List<Empleado> findAll() {
        List<Empleado>empleadoList = new ArrayList<>();
        for(Empleado er : empleadoRepository.findAll()){
            System.out.println(er.toString());
        }

        return empleadoList;
    }

    @Override
    public List<Empleado> findAllOff() {
        List<Empleado>empleadoList = new ArrayList<>();
        for(Empleado er : empleadoRepository.findAllOff()){
            System.out.println(er.toString());
        }

        return empleadoList;
    }

    @Override
    public void delete(String cuit) {
        if (findOne(cuit)!= null){
            empleadoRepository.delete(cuit);
        }
    }
}
