package repository;

import model.Cliente;
import model.Deposito;
import model.Empleado;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoRepository {
    private List<Empleado> empleados;
    private DepositoRepository depositoRepository;

    public EmpleadoRepository() {
        this.empleados = new ArrayList<>();
        this.depositoRepository = new DepositoRepository();
        cargarEmpleados();
    }

    public void cargarEmpleados(){

        Empleado empleado1 = new Empleado("123", "Juan", "Perez", "Calle 23", "232323", depositoRepository.buscarDepositoPorCodigo("1"));
        Empleado empleado2 = new Empleado("456", "María", "López", "Avenida 45", "454545", depositoRepository.buscarDepositoPorCodigo("2"));
        Empleado empleado3 = new Empleado("789", "Pedro", "Gómez", "Calle 67", "676767", depositoRepository.buscarDepositoPorCodigo("3"));
        Empleado empleado4 = new Empleado("101", "Laura", "Rodríguez", "Avenida 89", "898989", depositoRepository.buscarDepositoPorCodigo("4"));
        Empleado empleado5 = new Empleado("121", "Carlos", "Sánchez", "Calle 10", "101010", depositoRepository.buscarDepositoPorCodigo("5"));


        empleados.add(empleado1);
        empleados.add(empleado2);
        empleados.add(empleado3);
        empleados.add(empleado4);
        empleados.add(empleado5);

    }

    public void crearEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void deshabilitarEmpleado(String cuit) {
        Empleado empleado = buscarEmpleadoPorCuit(cuit);
        if (empleado != null) {
            empleado.setEstado(Empleado.Estado.DESHABILITADO);
        }
    }
    public List<Empleado> buscarTodosLosEmpleados() {
        return empleados;
    }

    public Empleado buscarEmpleadoPorCuit(String cuit) {
        for (Empleado empleado : empleados) {
            if (empleado.getCUIT().equals(cuit)) {
                return empleado;
            }
        }
        return null;
    }
    public void editarCliente(Empleado empleado) {
        Empleado empleadoExistente = buscarEmpleadoPorCuit(empleado.getCUIT());
        if (empleadoExistente != null) {
            empleadoExistente.setNombre(empleado.getNombre());
            empleadoExistente.setApellido(empleado.getApellido());
            empleadoExistente.setDireccion(empleado.getDireccion());
            empleadoExistente.setTelefono(empleado.getTelefono());
        }
    }


}
