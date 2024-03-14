package es.neesis.mvcdemo.service;

import es.neesis.mvcdemo.model.Empleado;

public interface IPlantillaService {
    void altaEmpleado(Empleado empleado);
    void bajaEmpleado(Long empleadoId) throws BusinessException;

    void asignarEmpleadoAPedido(Long empleadoId, Long pedidoId) throws BusinessException;
}
