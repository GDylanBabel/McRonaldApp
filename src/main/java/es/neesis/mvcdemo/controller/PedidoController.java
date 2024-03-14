package es.neesis.mvcdemo.controller;

import es.neesis.mvcdemo.DTO.EmpleadoPedido;
import es.neesis.mvcdemo.model.Pedido;
import es.neesis.mvcdemo.model.Producto;
import es.neesis.mvcdemo.model.ProductoPedido;
import es.neesis.mvcdemo.service.BusinessException;
import es.neesis.mvcdemo.service.IPedidoService;
import es.neesis.mvcdemo.service.impl.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {

    private final IPedidoService pedidoService = new PedidoService();

    @GetMapping("/lista")
    public List<Pedido> getPedidos() {
        return pedidoService.getPedidos();
    }

    @GetMapping("/obtener")
    public Pedido getPedido(@RequestParam Long pedidoId) throws BusinessException {
        return pedidoService.getPedido(pedidoId);
    }

    @PostMapping("/crear")
    public void crearPedido(@RequestBody List<Producto> productos) {
        Pedido pedido = new Pedido();
        ProductoPedido productoPedido = new ProductoPedido();
        //productoPedido.
        //pedido.setProductos(productos);
        pedidoService.crearPedido(pedido);
    }

    @DeleteMapping("/cancelar")
    public void cancelarPedido(@RequestBody Long longId) throws BusinessException {
        pedidoService.cancelarPedido(longId);
    }

    @PostMapping("/asignarEmpleado")
    public void asignarEmpleadoAPedido(@RequestBody EmpleadoPedido empleadoPedido) throws BusinessException {
        Long empleadoId = empleadoPedido.getEmpleadoId();
        Long pedidoId = empleadoPedido.getPedidoId();
        pedidoService.asignarEmpleadoAPedido(empleadoId, pedidoId);
    }

}
