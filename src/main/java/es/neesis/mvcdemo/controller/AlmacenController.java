package es.neesis.mvcdemo.controller;

import es.neesis.mvcdemo.model.Producto;
import es.neesis.mvcdemo.service.BusinessException;
import es.neesis.mvcdemo.service.IAlmacenService;
import es.neesis.mvcdemo.service.impl.AlmacenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/almacen")
public class AlmacenController {

    private final IAlmacenService almacenService = new AlmacenService();

    @GetMapping("/productos")
    public List<Producto> getProductos() {
        return almacenService.getProductos();
    }

    @GetMapping("/producto")
    public Producto getProducto(@RequestParam Long productoId) throws BusinessException {
        return almacenService.getProducto(productoId);
    }

    @PostMapping("/addProducto")
    public void addProducto(@RequestBody Producto producto) {
        almacenService.addProducto(producto);
    }

    @DeleteMapping("/producto")
    public void deleteProducto(@RequestBody Producto producto) {
        almacenService.addProducto(producto);
    }

}
