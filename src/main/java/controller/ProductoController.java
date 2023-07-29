package controller;

import model.Producto;
import model.Proveedor;
import service.ProductoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }



    public void crearProducto(Producto producto){
        productoService.crearProducto(producto);
    }

    public Producto buscarProductoPorCodigo(String codigo){
        return productoService.buscarProductoPorCodigo(codigo);
    }

    public List<Producto> buscarTodosLosProductos(){
        return productoService.buscarTodosLosProductos();
    }
    public void eliminarProducto(String codigo){
        productoService.eliminarProducto(codigo);
    }

    public void editarProducto(Producto producto){
        productoService.editarProducto(producto);
    }

    public List<Proveedor> mostrarProveedores(){
        return productoService.mostrarProveedores();
    }

    public Proveedor buscarProveedorPorCuit(String cuit){
        return productoService.buscarProveedorPorCuit(cuit);
    }
}
