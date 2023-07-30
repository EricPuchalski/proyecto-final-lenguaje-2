package LDEsystem.com.controller;

import LDEsystem.com.model.Producto;
import LDEsystem.com.service.ProductoService;
import LDEsystem.com.util.CRUD;

import java.util.List;

public class ProductoController implements CRUD<Producto> {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }



    public void save(Producto producto){
        productoService.save(producto);
    }

    public Producto findOne(String codigo){
        return productoService.findOne(codigo);
    }

    public List<Producto> findAll(){
        return productoService.findAll();
    }
    public List<Producto> findAllOff(){
        return productoService.findAllOff();
    }

    public void delete(String codigo){
        productoService.delete(codigo);
    }

    public void upDate(Producto producto){
        productoService.upDate(producto);
    }


}
