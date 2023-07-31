package LDEsystem.com.service;

import LDEsystem.com.model.Producto;
import LDEsystem.com.util.CRUD;
import LDEsystem.com.repository.ProductoRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductoService implements CRUD<Producto> {

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
        return productoRepository.findAll();
    }



    public Producto findOne(String codigo) {
        Producto producto = null;
        if (productoRepository.findOne(codigo) != null) {
             producto = productoRepository.findOne(codigo);

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
