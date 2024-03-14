package es.neesis.mvcdemo.service;

import es.neesis.mvcdemo.model.Producto;
import es.neesis.mvcdemo.model.ProductoCarta;

import java.util.List;
public interface ICartaService {
    List<ProductoCarta> getProductos();

    void addProducto(ProductoCarta producto)throws BusinessException;
    void updateProducto(ProductoCarta producto)throws BusinessException;
    void removeProducto(Long productoId)throws BusinessException;

}
