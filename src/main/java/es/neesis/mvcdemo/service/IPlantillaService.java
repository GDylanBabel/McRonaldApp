package es.neesis.mvcdemo.service;

import es.neesis.mvcdemo.model.Empleado;
import java.util.List;

public interface IPlantillaService {
    List<Empleado> getEmpleados();
    void altaEmpleado(Empleado empleado);
    void bajaEmpleado(Long empleadoId) throws BusinessException;

    void asignarEmpleadoAPedido(Long empleadoId, Long pedidoId) throws BusinessException;
}
