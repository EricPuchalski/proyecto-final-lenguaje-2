package view;

import controller.ProductoController;
import model.CategoriaProducto;
import model.Producto;
import model.Proveedor;

import java.util.Scanner;

public class MenuProducto {
    private String opcion;
    private ProductoController productoController;

    public MenuProducto(ProductoController productoController) {
        this.productoController = productoController;
    }


    public void mostrarMenuProducto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor ingrese la opción que desee: ");
        System.out.println("1. Crear Producto");
        System.out.println("2. Ver Productos");
        System.out.println("3. Buscar producto por código");
        System.out.println("4. Editar producto");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Salir del Menu de producto");
        System.out.println("----------------------------");
        this.opcion = scanner.nextLine();
        switch (opcion) {
            case "1":
                System.out.println("Por favor ingrese el codigo");
                String codigo = scanner.nextLine();
                System.out.println("Por favor ingrese el nombre");
                String nombre = scanner.nextLine();
                System.out.println("Por favor ingrese el peso");
                Double peso = scanner.nextDouble();
                System.out.println("Por favor ingrese la altura");
                Double alturaProducto = scanner.nextDouble();
                System.out.println("Por favor ingrese el ancho del producto");
                Double  anchoProducto = scanner.nextDouble();
                System.out.println("Por favor ingrese el largo del producto");
                Double largoProducto = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Por favor ingrese la Categoria del producto");
                System.out.println("-----------------------------");
                System.out.println("1.Informatica");
                System.out.println("2.Hogar");
                System.out.println("3.Limpieza");
                System.out.println("4.Jardin");
                System.out.println("5.Electronica");
                System.out.println("6.Juguete");
                System.out.println("----------------------------");


                String tipoProducto = scanner.nextLine();
                productoController.mostrarProveedores();
                System.out.println("----------------------------");
                System.out.println("Por favor ingrese el cuit del proveedor");
                String nombreProveedor = scanner.nextLine();

                Proveedor proveedorDelProducto = productoController.buscarProveedorPorCuit(nombreProveedor);
                CategoriaProducto categoriaProducto = new CategoriaProducto();
                switch (tipoProducto) {
                    case "1":
                        categoriaProducto.setNombre("Informatica");
                        break;
                    case "2":
                        categoriaProducto.setNombre("Hogar");
                        break;
                    case "3":
                        categoriaProducto.setNombre("Limpieza");
                        break;
                    case "4":
                        categoriaProducto.setNombre("Jardin");
                        break;
                    case "5":
                        categoriaProducto.setNombre("Electronica");
                        break;
                    case "6":
                        categoriaProducto.setNombre("Juguete");
                        break;
                    default:
                        System.out.println("No existe esa categoria de producto");
                        break;
                }

                productoController.crearProducto(new Producto(codigo,nombre,anchoProducto,alturaProducto,largoProducto,peso,categoriaProducto,proveedorDelProducto));
                break;
            case "2":
                productoController.buscarTodosLosProductos();
                break;
            case "3":
                System.out.println("Por favor ingrese el codigo del producto");
                String codigoProducto = scanner.nextLine();
                Producto productoEncontrado = productoController.buscarProductoPorCodigo(codigoProducto);
                break;
            case "4":
                System.out.println("Por favor ingrese el coodigo del producto a editar: ");
                String codigoProductoEditado = scanner.nextLine();
                Producto producto = productoController.buscarProductoPorCodigo(codigoProductoEditado);
                if (producto != null) {
                    System.out.println("Por favor ingrese el nuevo nombre");
                    String nuevoNombre = scanner.nextLine();
                    System.out.println("Por favor ingrese el nuevo peso");
                    Double nuevoPeso = scanner.nextDouble();
                    System.out.println("Por favor ingrese la nueva altura");
                    Double nuevaAltura = scanner.nextDouble();
                    System.out.println("Por favor ingrese el nuevo ancho del producto");
                    Double  nuevoAncho = scanner.nextDouble();
                    System.out.println("Por favor ingrese el nuevo largo del producto");
                    Double nuevoLargo = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Ingrese la nueva categoria del producto: ");
                    System.out.println("-----------------------------");
                    System.out.println("1.Informatica");
                    System.out.println("2.Hogar");
                    System.out.println("3.Limpieza");
                    System.out.println("4.Jardin");
                    System.out.println("5.Electronica");
                    System.out.println("6.Juguete");

                    String opcionProducto = scanner.nextLine();
                    CategoriaProducto nuevaCategoria = new CategoriaProducto();
                    switch (opcionProducto) {
                        case "1":
                            nuevaCategoria.setNombre("Informatica");
                            break;
                        case "2":
                            nuevaCategoria.setNombre("Hogar");
                            break;
                        case "3":
                            nuevaCategoria.setNombre("Limpieza");
                            break;
                        case "4":
                            nuevaCategoria.setNombre("Jardin");
                            break;
                        case "5":
                            nuevaCategoria.setNombre("Electronica");
                            break;
                        case "6":
                            nuevaCategoria.setNombre("Juguete");
                            break;
                        default:
                            System.out.println("No existe esa categoria de producto");
                            break;
                    }
                    productoController.mostrarProveedores();
                    System.out.println("Por favor ingrese el cuit del nuevo proveedor");
                    String cuitNuevoProveedor = scanner.nextLine();
                    Proveedor proveedorNuevo = productoController.buscarProveedorPorCuit(cuitNuevoProveedor);

                    productoController.editarProducto(new Producto(codigoProductoEditado,nuevoNombre,nuevoAncho,nuevaAltura,nuevoLargo,nuevoPeso,nuevaCategoria,proveedorNuevo));


                }
                break;
            case "5":
                System.out.println("Por favor ingrese el codigo del producto a eliminar");
                String codigoProductoEliminado = scanner.nextLine();
                Producto productoEliminado = productoController.buscarProductoPorCodigo(codigoProductoEliminado);
                if (productoEliminado != null) {
                    productoController.eliminarProducto(codigoProductoEliminado);
                }

                break;
            case "6":
                break;
            default:
                System.out.println("Opción inválida");
                break;


        }


    }

}
