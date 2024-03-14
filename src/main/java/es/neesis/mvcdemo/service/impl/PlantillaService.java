package es.neesis.mvcdemo.service.impl;

import es.neesis.mvcdemo.model.Empleado;
import es.neesis.mvcdemo.model.Pedido;
import es.neesis.mvcdemo.repository.IEmpleadoRepository;
import es.neesis.mvcdemo.repository.IPedidoRepository;
import es.neesis.mvcdemo.service.BusinessException;
import es.neesis.mvcdemo.service.IPlantillaService;
import es.neesis.mvcdemo.utils.BusinessChecks;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PlantillaService implements IPlantillaService {
    @Autowired
    private IEmpleadoRepository empleadoRepository;
    @Autowired
    private IPedidoRepository pedidoRepository;

    @Override
    public void altaEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    @Override
    public void bajaEmpleado(Long empleadoId) {
        empleadoRepository.deleteById(empleadoId);
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
