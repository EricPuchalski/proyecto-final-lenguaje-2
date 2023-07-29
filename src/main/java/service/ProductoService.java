package service;

import model.Producto;
import model.Proveedor;
import repository.ProductoRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductoService {

    private ProductoRepository productoRepository;
    private boolean productoExistente;
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Producto buscarProductoPorCodigo(String codigo){
        Producto productoBuscado = productoRepository.buscarProductoPorCodigo(codigo);
        if (productoBuscado != null){
            return productoBuscado;
        } else {
            System.out.println("Error, no existe un producto con el codigo ingresado");
            return null;
        }
    }


    public void crearProducto(Producto producto){
        if (productoRepository.buscarProductoPorCodigo(producto.getCodigo())==null){
            productoRepository.guardarProducto(producto);
            System.out.println("Se añadió "+producto.getNombre());
        } else {
            System.out.println("El producto ya existe");
        }
    }


    public List<Producto> buscarTodosLosProductos(){
        List<Producto> listaProductos = new ArrayList<>();
        for (Producto producto: productoRepository.buscarTodosLosProductos()
             ) {
            System.out.println(producto.toString());
            listaProductos.add(producto);
        }
        return listaProductos;
    }

    public void eliminarProducto(String codigo){
        productoRepository.eliminarProducto(codigo);
    }

    public void editarProducto(Producto producto){
       productoRepository.editarProducto(producto);
    }

    public List<Proveedor> mostrarProveedores(){
        List<Proveedor> listaProveedores = new ArrayList<>();
        for (Proveedor proveedor: productoRepository.mostrarProveedores()
             ) {
            System.out.println(proveedor.toString());
            listaProveedores.add(proveedor);
        }
        return listaProveedores;
    }

    public Proveedor buscarProveedorPorCuit(String cuit){
        Proveedor proveedorBuscado = productoRepository.buscarProveedorPorCuit(cuit);
        if (proveedorBuscado!=null){
            System.out.println(proveedorBuscado.toString());
        } else {
            System.out.println("Error, no existe un proveedor con el cuit ingresado");
        }
        return proveedorBuscado;
    }


}
