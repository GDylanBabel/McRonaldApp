package es.neesis.mvcdemo.controller;

import es.neesis.mvcdemo.model.Empleado;
import es.neesis.mvcdemo.model.Producto;
import es.neesis.mvcdemo.model.ProductoCarta;
import es.neesis.mvcdemo.service.BusinessException;
import es.neesis.mvcdemo.service.ICartaService;
import es.neesis.mvcdemo.service.IPlantillaService;
import es.neesis.mvcdemo.service.impl.CartaService;
import es.neesis.mvcdemo.service.impl.PlantillaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/plantilla")
public class PlantillaController {

    private final IPlantillaService plantillaService = new PlantillaService();

    @PostMapping("/addEmpleado")
    public void addEmpleado(@RequestBody Empleado empleado) {
        plantillaService.altaEmpleado(empleado);
    }

    @DeleteMapping("/bajaEmpleado")
    public void bajaEmpleado(@RequestBody Long empleadoId) throws BusinessException {
        plantillaService.bajaEmpleado(empleadoId);
    }

}
