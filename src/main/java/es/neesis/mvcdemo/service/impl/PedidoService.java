package es.neesis.mvcdemo.service.impl;

import es.neesis.mvcdemo.model.*;
import es.neesis.mvcdemo.repository.IEmpleadoRepository;
import es.neesis.mvcdemo.repository.IPedidoRepository;
import es.neesis.mvcdemo.repository.IProductoRepository;
import es.neesis.mvcdemo.service.BusinessException;
import es.neesis.mvcdemo.service.IPedidoService;
import es.neesis.mvcdemo.utils.BusinessChecks;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PedidoService implements IPedidoService {
    @Autowired
    private IPedidoRepository pedidoRepository;
    @Autowired
    private IEmpleadoRepository empleadoRepository;
    @Autowired
    private IProductoRepository productoRepository;
    @Override
    public List<Pedido> getPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido getPedido(Long pedidoId) throws BusinessException {
        Optional<Pedido> pedido = pedidoRepository.findById(pedidoId);
        BusinessChecks.exists(pedido,"El pedido no existe");
        return pedido.get();
    }

    @Override
    public void crearPedido(Pedido pedido) {
        actualizarUnidadesProductos(pedido.getProductos());
        pedidoRepository.save(pedido);
    }

    private void actualizarUnidadesProductos(List<ProductoPedido> productosPedido) {
        for (ProductoPedido productoPedido : productosPedido) {
            ProductoCarta productoCarta = productoPedido.getProductoCarta();
            actualizarUnidadesProducto(productoCarta.getProducto(), -productoPedido.getProductAmount());
        }
    }

    private void actualizarUnidadesProducto(Producto producto, Integer unidades) {
        producto.setStockDisponible(producto.getStockDisponible() + unidades);
        // TODO
    }

    @Override
    public void cancelarPedido(Long pedidoId) throws BusinessException{
        // TODO que vuelva a sumar las unidades
        Optional<Pedido> pedido = pedidoRepository.findById(pedidoId);
        BusinessChecks.exists(pedido,"El pedido no existe");
        pedidoRepository.delete(pedido.get());
    }

    @Override
    public void modificarPedido(String identificador) throws BusinessException{
        // TODO
    }

    @Override
    public void asignarEmpleadoAPedido(Long empleadoId, Long pedidoId) throws BusinessException {
        Optional<Empleado> empleado = empleadoRepository.findById(empleadoId);
        BusinessChecks.exists(empleado,"El empleado no existe");

        Optional<Pedido> pedido = pedidoRepository.findById(pedidoId);
        BusinessChecks.exists(pedido,"El pedido no existe");

        pedido.get().setEmpleado(empleado.get());
        empleado.get().getPedidosAsignados().add(pedido.get());
    }
}
