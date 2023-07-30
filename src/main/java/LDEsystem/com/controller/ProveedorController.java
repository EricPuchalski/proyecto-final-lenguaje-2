package LDEsystem.com.controller;

import LDEsystem.com.model.Proveedor;
import LDEsystem.com.service.ProveedorService;

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

    @Override
    public List<Proveedor> findAllOff() {
        return proveedorService.findAllOff();
    }

    public void delete(String cuit) {
        proveedorService.delete(cuit);
    }

    public void create(Proveedor proveedor) {
        proveedorService.save(proveedor);
    }

    public void upDate(Proveedor proveedor) {
        proveedorService.upDate(proveedor);
    }

}
