package es.neesis.mvcdemo.service;

import es.neesis.mvcdemo.model.Producto;
import java.util.List;

public interface IAlmacenService {
    List<Producto> getProductos();
    Producto getProducto(Long productoId) throws BusinessException;
    void addProducto(Producto producto);
    void deleteProducto(Long productoId);
}
