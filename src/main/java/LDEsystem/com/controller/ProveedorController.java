package LDEsystem.com.controller;

import LDEsystem.com.model.Proveedor;
import LDEsystem.com.service.ProveedorService;
import LDEsystem.com.util.CRUD;

import java.util.List;

public class ProveedorController implements CRUD<Proveedor> {
    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    public Proveedor findOne(String cuit) {
        return proveedorService.findOne(cuit);
    }

    public List<Proveedor> findAll() {
        return proveedorService.findAll();
    }


    public void delete(String cuit) {
        proveedorService.delete(cuit);
    }

    public void save(Proveedor proveedor) {
        proveedorService.save(proveedor);
    }

    public void upDate(Proveedor proveedor) {
        proveedorService.upDate(proveedor);
    }

}
