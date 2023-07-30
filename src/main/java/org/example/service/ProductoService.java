package org.example.service;

import org.example.model.Producto;
import org.example.model.Proveedor;
import org.example.repository.ProductoRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductoService implements CRUD<Producto>{

    private ProductoRepository productoRepository;
    private boolean productoExistente;
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public void save(Producto producto) {
        if (findOne(producto.getCodigo()) == null) {
            productoRepository.save(producto);
        }
    }

    public List<Producto> findAll() {
        List<Producto> productoList = new ArrayList<>();
        for (Producto pr : productoRepository.findAll()) {
            System.out.println(pr.toString());
        }
        return productoList;
    }

    public List<Producto> findAllOff() {
        List<Producto> productoList = new ArrayList<>();
        for (Producto pr : productoRepository.findAllOff()) {
            System.out.println(pr.toString());
        }
        return productoList;
    }

    public Producto findOne(String codigo) {
        Producto producto = null;
        if (findOne(codigo) != null) {
            Producto pr = productoRepository.findOne(codigo);
            producto = pr;
        }
        return producto;
    }

    public void upDate(Producto producto) {
        if (findOne(producto.getCodigo()) != null) {
            productoRepository.upDate(producto);
        }
    }

    public void delete(String codigo) {
        if (findOne(codigo) != null) {
            productoRepository.delete(codigo);
        }
    }

}
