package org.example.view;

import org.example.controller.ProductoController;
import org.example.controller.ProveedorController;
import org.example.model.CategoriaProducto;
import org.example.model.Producto;
import org.example.model.Proveedor;
import org.example.repository.ProveedorRepository;
import org.example.service.ProveedorService;

import java.util.Scanner;

public class MenuProducto {
    private String opcion;
    private ProductoController productoController;
    ProveedorController proveedorController;

    public MenuProducto(ProductoController productoController) {
        this.productoController = productoController;
        this.proveedorController = new ProveedorController(new ProveedorService(new ProveedorRepository()));
    }


    public void mostrarMenuProducto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor ingrese la opción que desee: ");
        System.out.println("1. Crear Producto");
        System.out.println("2. Ver Productos");
        System.out.println("3. Ver Productos eliminados");
        System.out.println("4. Buscar producto por código");
        System.out.println("5. Editar producto");
        System.out.println("6. Eliminar producto");
        System.out.println("7. Salir del Menu de producto");
        System.out.println("----------------------------");
        this.opcion = scanner.nextLine();


            switch (opcion) {
                case "1":
                    String nombre = null;
                    Double peso = 0.0;
                    Double alturaProducto = 0.0;
                    Double anchoProducto = 0.0;
                    Double largoProducto = 0.0;

                    System.out.println("Por favor ingrese el codigo");
                    String codigo = scanner.nextLine();
                    if (productoController.findOne(codigo) == null) {
                        System.out.println("Por favor ingrese el nombre");
                        nombre = scanner.nextLine();
                        System.out.println("Por favor ingrese el peso");
                        peso = scanner.nextDouble();
                        System.out.println("Por favor ingrese la altura");
                        alturaProducto = scanner.nextDouble();
                        System.out.println("Por favor ingrese el ancho del producto");
                        anchoProducto = scanner.nextDouble();
                        System.out.println("Por favor ingrese el largo del producto");
                        largoProducto = scanner.nextDouble();
                    } else {
                        System.out.println("El producto ingresado ya existe");
                    }
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
                    proveedorController.findAll();
                    System.out.println("----------------------------");
                    System.out.println("Por favor ingrese el cuit del proveedor");
                    String nombreProveedor = scanner.nextLine();

                    Proveedor proveedorDelProducto = proveedorController.findOne(nombreProveedor);
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

                    productoController.create(new Producto(codigo, nombre, anchoProducto, alturaProducto, largoProducto, peso, categoriaProducto, proveedorDelProducto));
                    break;
                case "2":
                    System.out.println("============== La lista de Productos actuales es: ===============");
                    productoController.findAll();
                    break;
                case "3":
                    System.out.println("============== La lista de Productos eliminados es: ===============");
                    productoController.findAllOff();
                    break;
                case "4":
                    System.out.println("Por favor ingrese el codigo del producto");
                    String codigoProducto = scanner.nextLine();
                    if (productoController.findOne(codigoProducto) != null)
                        System.out.println("El producto es: " + productoController.findOne(codigoProducto));
                    break;
                case "5":
                    System.out.println("Por favor ingrese el coodigo del producto a editar: ");
                    String codigoProductoEditado = scanner.nextLine();
                    if (productoController.findOne(codigoProductoEditado) != null) {
                        System.out.println("Por favor ingrese el nuevo nombre");
                        String nuevoNombre = scanner.nextLine();
                        System.out.println("Por favor ingrese el nuevo peso");
                        Double nuevoPeso = scanner.nextDouble();
                        System.out.println("Por favor ingrese la nueva altura");
                        Double nuevaAltura = scanner.nextDouble();
                        System.out.println("Por favor ingrese el nuevo ancho del producto");
                        Double nuevoAncho = scanner.nextDouble();
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
                        proveedorController.findAll();
                        System.out.println("Por favor ingrese el cuit del nuevo proveedor");
                        String cuitNuevoProveedor = scanner.nextLine();
                        Proveedor proveedorNuevo = proveedorController.findOne(cuitNuevoProveedor);

                        productoController.upDate(new Producto(codigoProductoEditado, nuevoNombre, nuevoAncho, nuevaAltura, nuevoLargo, nuevoPeso, nuevaCategoria, proveedorNuevo));


                    } else {
                        System.out.println("El codigo ingresado es incorrecto");
                    }
                    break;
                case "6":
                    System.out.println("Por favor ingrese el codigo del producto a eliminar");
                    String codigoProductoEliminado = scanner.nextLine();
                    if (productoController.findOne(codigoProductoEliminado) != null) {
                        productoController.delete(codigoProductoEliminado);
                    } else {
                        System.out.println("El codigo ingresado es incorrecto");
                    }

                    break;
                case "7":
                    System.out.println("Ha salido exitosamente");
                    MenuPrincipal menuPrincipal = new MenuPrincipal();
                    menuPrincipal.mostrarMenuPrincipal();
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }


        }

}
