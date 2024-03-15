package es.neesis.mvcdemo.service;

import es.neesis.mvcdemo.model.Pedido;
import es.neesis.mvcdemo.model.Producto;

import java.util.List;

public interface IPedidoService {
    List<Pedido> getPedidos();
    Pedido getPedido(Long pedidoId) throws BusinessException;
    void crearPedido(Pedido pedido);
    void cancelarPedido(Long pedidoId) throws BusinessException;
    void modificarPedido(Pedido pedido) throws BusinessException;
    void asignarEmpleadoAPedido(Long empleadoId, Long pedidoId) throws BusinessException;

}
