package es.neesis.mvcdemo.controller;

import es.neesis.mvcdemo.model.Producto;
import es.neesis.mvcdemo.service.BusinessException;
import es.neesis.mvcdemo.service.IAlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/almacen")
public class AlmacenController {

    @Autowired
    private IAlmacenService almacenService;

    @GetMapping
    public String inicializacion(Model model) {
        model.addAttribute("productos", new ArrayList<>());
        return "almacen";
    }

    @GetMapping("/productos")
    @ResponseBody
    public void getProductos(Model model) {
        model.addAttribute("productos", almacenService.getProductos());
    }

    @GetMapping("/producto/{productoId}")
    @ResponseBody
    public void getProducto(@PathVariable Long productoId, Model model) throws BusinessException {
        model.addAttribute("productoSeleccionado", almacenService.getProducto(productoId));
    }

    @PostMapping("/addProducto")
    @ResponseBody
    public void addProducto(@RequestBody Producto producto, Model model) {
        almacenService.addProducto(producto);
        model.addAttribute("productos", almacenService.getProductos());
    }

    @DeleteMapping("/producto/{productoId}")
    @ResponseBody
    public void deleteProducto(@PathVariable Long productoId, Model model) {
        almacenService.deleteProducto(productoId);
        model.addAttribute("productos", almacenService.getProductos());
    }

}
