package es.neesis.mvcdemo.controller;

import es.neesis.mvcdemo.model.Producto;
import es.neesis.mvcdemo.model.ProductoCarta;
import es.neesis.mvcdemo.service.BusinessException;
import es.neesis.mvcdemo.service.ICartaService;
import es.neesis.mvcdemo.service.impl.CartaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/carta")
public class CartaController {

    private final ICartaService cartaService = new CartaService();

    @GetMapping("/productos")
    public List<ProductoCarta> getProductos() throws BusinessException {
        return cartaService.getProductos();
    }

    @PostMapping("/addProducto")
    public void addProducto(Producto producto) throws BusinessException {
        ProductoCarta productoCarta = new ProductoCarta();
        productoCarta.setProducto(producto);
        cartaService.addProducto(productoCarta);
    }

    @DeleteMapping("/producto")
    public void removeProducto(Producto producto) throws BusinessException {
        cartaService.removeProducto(producto.getId());
    }

}
