package repository;

import lombok.Getter;
import lombok.Setter;
import model.CategoriaProducto;
import model.Producto;
import model.Proveedor;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class ProductoRepository {
    private List<Producto> productos;
    private List<Proveedor> proveedores;

    public ProductoRepository() {
        this.productos = new ArrayList<>();
        this.proveedores = new ArrayList<>();
        cargarProductos();
    }


    public void cargarProductos() {
        CategoriaProducto informatica = new CategoriaProducto("Informatica");
        CategoriaProducto limpieza = new CategoriaProducto("Limpieza");
        CategoriaProducto hogar = new CategoriaProducto("Hogar");
        CategoriaProducto jardin = new CategoriaProducto("Jardin");
        CategoriaProducto electronica = new CategoriaProducto("Electronica");
        CategoriaProducto juguete = new CategoriaProducto("Juguete");

        Proveedor proveedor1 = new Proveedor("1", "Proveedor ComputerInc", "Rusia", "Rusia 2325");
        Proveedor proveedor2 = new Proveedor("2", "Proveedor TodoJardin", "EEUU", "New york 3453");
        Proveedor proveedor3 = new Proveedor("3", "Proveedor ElectroMisiones", "Argentina", "San martin 2325");
        Proveedor proveedor4 = new Proveedor("4", "Proveedor ToysLand", "Inglaterra", "Manchester 3413");
        Proveedor proveedor5 = new Proveedor("5", "Proveedor LimpiaMax", "Paraguay", "Calle 42");
        Proveedor proveedor6 = new Proveedor("6", "Proveedor HogarSA", "Bolivia", "San carlos 2325");

        proveedores.add(proveedor1);
        proveedores.add(proveedor2);
        proveedores.add(proveedor3);
        proveedores.add(proveedor4);
        proveedores.add(proveedor5);
        proveedores.add(proveedor6);

        Producto p1 = new Producto("1", "Monitor", 0.5, 0.6, 2, 3, informatica, proveedor1);
        Producto p2 = new Producto("2", "Mouse", 0.01, 0.005, 2, 0.198, informatica, proveedor1);
        Producto p3 = new Producto("3", "Pava eléctrica", 0.5, 0.04, 2, 2, electronica, proveedor3);
        Producto p4 = new Producto("4", "Peluche oso", 0.9, 1, 2, 0.6, juguete, proveedor4);
        Producto p5 = new Producto("5", "Escoba", 0.03, 2, 2, 0.5, hogar, proveedor6);
        Producto p6 = new Producto("6", "Silla", 1, 1.4, 2, 6.4, hogar, proveedor6);
        Producto p7 = new Producto("7", "Toalla", 1, 2, 2, 0.1, hogar, proveedor5);
        Producto p8 = new Producto("8", "Sábana", 2, 2.4, 2, 0.7, hogar, proveedor6);
        Producto p9 = new Producto("9", "Teclado", 0.05, 0.005, 2, 1, informatica, proveedor1);
        Producto p10 = new Producto("10", "Estante", 2, 1.1, 2, 10, hogar, proveedor6);
        Producto p11 = new Producto("11", "Detergente", 0.4, 0.05, 2, 0.2, limpieza, proveedor5);
        Producto p12 = new Producto("12", "Peluche Barney", 0.7, 1.7, 2, 0.4, juguete, proveedor4);
        Producto p13 = new Producto("13", "Mousepad", 0.4, 2, 2, 0.01, informatica, proveedor1);
        Producto p14 = new Producto("14", "Bombilla", 0.0001, 3, 2, 0.01, hogar, proveedor6);
        Producto p15 = new Producto("15", "Maceta", 0.5, 3, 2, 1.3, jardin, proveedor2);
        Producto p16 = new Producto("16", "Gnomo de jardín", 1, 3, 2, 3, jardin, proveedor2);
        Producto p17 = new Producto("17", "Licuadora", 0.3, 3, 2, 2.5, electronica, proveedor3);
        Producto p18 = new Producto("18", "Cafetera", 0.2, 3, 2, 2, electronica, proveedor3);
        Producto p19 = new Producto("19", "Muñeco Goku", 1.2, 3, 2, 1, juguete, proveedor4);
        Producto p20 = new Producto("20", "Muñeco Pikachu", 0.09, 3, 2, 0.6, juguete, proveedor4);


        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);
        productos.add(p5);
        productos.add(p6);
        productos.add(p7);
        productos.add(p8);
        productos.add(p9);
        productos.add(p10);
        productos.add(p11);
        productos.add(p12);
        productos.add(p13);
        productos.add(p14);
        productos.add(p15);
        productos.add(p16);
        productos.add(p17);
        productos.add(p18);
        productos.add(p19);
        productos.add(p20);

    }

    public void guardarProducto(Producto producto) {
        productos.add(producto);
    }

    public Producto buscarProductoPorCodigo(String codigo) {
        for (Producto producto : productos
        ) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }


    public List<Producto> buscarTodosLosProductos() {
        return productos;
    }

    public void eliminarProducto(String codigo) {
        Producto productoEliminado = buscarProductoPorCodigo(codigo);
        productos.remove(productoEliminado);
    }

    public void editarProducto(Producto producto) {
        Producto productoExistente = buscarProductoPorCodigo(producto.getCodigo());
        if (productoExistente != null) {
            productoExistente.setNombre(producto.getNombre());
            productoExistente.setAncho(producto.getAncho());
            productoExistente.setAltura(producto.getAltura());
            productoExistente.setLargo(producto.getLargo());
            productoExistente.setPeso(producto.getPeso());
            productoExistente.setCategoria(producto.getCategoria());
            productoExistente.setProveedor(producto.getProveedor());
        }
    }

    public List<Proveedor> mostrarProveedores(){
        return proveedores;
    }

    public Proveedor buscarProveedorPorCuit(String cuit){
        for (Proveedor proveedor: proveedores
             ) {
            if (proveedor.getCuit().equals(cuit)){
                return proveedor;
            }
        }
        return null;
    }
}
