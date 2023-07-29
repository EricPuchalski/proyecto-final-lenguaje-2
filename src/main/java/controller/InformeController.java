package controller;

import service.InformeService;

public class InformeController {
    private InformeService informeService;

    public InformeController(InformeService informeService) {
        this.informeService = informeService;
    }

    public int obtenerCantidadPedidosPorSucursal(String codigoSucursal) {
        return informeService.obtenerCantidadPedidosPorSucursal(codigoSucursal);
    }

    public int contarPedidosEnEstadoPendiente() {
        return informeService.contarPedidosEnEstadoPendiente();
    }
}