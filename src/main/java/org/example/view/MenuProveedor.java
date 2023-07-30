package org.example.view;

import org.example.controller.ProveedorController;
import org.example.model.Proveedor;
import org.example.repository.ProveedorRepository;
import org.example.service.ProveedorService;

import java.util.Scanner;

public class MenuProveedor {
    ProveedorController proveedorController;
    public MenuProveedor(ProveedorController proveedorController) {
        this.proveedorController = proveedorController;
    }

    public void mostrarMenuProveedor(){
        Scanner leer = new Scanner(System.in);
        Boolean salir = false;


            System.out.println("=============== Menu ====================");
            System.out.println("1.Crear proveedor");
            System.out.println("2.Ver todos los proveedores");
            System.out.println("3.Ver todos los proveedores Inhabilitados");
            System.out.println("4.Editar proveedor");
            System.out.println("5.Buscar proveedor por C.U.I.T.");
            System.out.println("6.Eliminar proveedor");
            System.out.println("7.Salir");
            System.out.println("=========================================");
            System.out.println("Ingrese una opcion: ");
            int opcion = leer.nextInt();
            leer.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el C.U.I.T: ");
                    String cuit = leer.nextLine();
                    if (proveedorController.findOne(cuit) == null) {
                        System.out.println("Ingrese el nombre del proveedor: ");
                        String nombre = leer.nextLine();
                        System.out.println("Ingrese la direccion del proveedor: ");
                        String direc = leer.nextLine();
                        System.out.println("Inrese el numero de telefono del proveedor: ");
                        String tel = leer.nextLine();
                        System.out.println("Inrese el numero de email del proveedor: ");
                        String email = leer.nextLine();
                        proveedorController.create(new Proveedor(cuit, nombre, direc, tel, email));
                    }else{
                        System.out.println("El proveedor ya existe");
                    }
                    break;

                case 2:
                    System.out.println("============== La lista de Proveedores actuales es: ===============");
                    proveedorController.findAll();
                    break;

                case 3:
                    System.out.println("=============== La lista de Proveedores Invalidos es: ============");
                    proveedorController.findAllOff();
                    break;

                case 4: System.out.println("Ingrese el C.U.I.T del proveedor a editar: ");
                    String cuitPr = leer.nextLine();
                    if (proveedorController.findOne(cuitPr)!=null) {
                        System.out.println("Ingrese el nombre del proveedor: ");
                        String nombr = leer.nextLine();
                        System.out.println("Ingrese la direccion del proveedor: ");
                        String dire = leer.nextLine();
                        System.out.println("Inrese el numero de telefono del proveedor: ");
                        String telP = leer.nextLine();
                        System.out.println("Inrese el numero de email del proveedor: ");
                        String emailP = leer.nextLine();
                        proveedorController.upDate(new Proveedor(cuitPr, nombr, dire, telP, emailP));
                    }else {
                        System.out.println("El proveedor ingresado no existe");
                    }
                    break;

                case 5:
                    System.out.println("Ingrese el C.U.I.T. del proveedor a Buscar: ");
                    String cuitP = leer.nextLine();
                    proveedorController.findOne(cuitP);
                    break;

                case 6:
                    System.out.println("Ingrese el C.U.I.T. del proveedor a eliminar: ");
                    String cuitd = leer.nextLine();
                    proveedorController.delete(cuitd);
                    break;

                case 7:
                    System.out.println("Ha salido exitosamente");
                    MenuPrincipal menuPrincipal = new MenuPrincipal();
                    menuPrincipal.mostrarMenuPrincipal();
                    break;

                default:
                    System.out.println("La opcion ingresada no existe, intente nuevamente..");
            }



    }
}
