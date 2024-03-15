package es.neesis.mvcdemo.controller;

import es.neesis.mvcdemo.model.ProductoCarta;
import es.neesis.mvcdemo.model.ProductoPedido;
import es.neesis.mvcdemo.service.BusinessException;
import es.neesis.mvcdemo.service.ICartaService;
import es.neesis.mvcdemo.service.impl.CartaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/carta")
public class CartaController {

    @Autowired
    private  ICartaService cartaService;

    @GetMapping
    public void inicializacion(Model model) {
        model.addAttribute("productos", new ArrayList<>());

        if(model.getAttribute("carrito") != null){
            model.addAttribute("carrito", model.getAttribute("carrito"));
        }
        model.addAttribute("carrito", new ArrayList<>());
    }

    @GetMapping("/productos")
    @ResponseBody
    public void getProductos(Model model) {
        model.addAttribute("productos", cartaService.getProductos());
    }

    @PostMapping("/addProductoCarrito")
    public String addProductoCarrito(Model model,@RequestBody ProductoPedido producto) {
        List<ProductoPedido> carrito = (List<ProductoPedido>) model.getAttribute("carrito");
        carrito.add(producto);
        model.addAttribute("carrito", carrito);
        return "carta";
    }

    @PostMapping("/addProducto")
    @ResponseBody
    public void addProducto(@RequestBody ProductoCarta productoCarta) throws BusinessException {
        cartaService.addProducto(productoCarta);
    }

    @DeleteMapping("/producto/{productoId}")
    @ResponseBody
    public void removeProducto(@PathVariable Long productoId) throws BusinessException {
        cartaService.removeProducto(productoId);
    }

}
