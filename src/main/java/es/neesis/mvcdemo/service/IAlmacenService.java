package es.neesis.mvcdemo.service;

import es.neesis.mvcdemo.dto.ProductoDTO;
import es.neesis.mvcdemo.model.Producto;

import java.util.List;

public interface IAlmacenService {
    List<ProductoDTO> getProductos();

    ProductoDTO getProducto(Long productoId) throws BusinessException;

    void addProducto(ProductoDTO producto);

    void deleteProducto(Long productoId);
}
