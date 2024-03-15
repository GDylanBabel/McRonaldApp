package es.neesis.mvcdemo.service;

import es.neesis.mvcdemo.dto.ProductoCartaDTO;
import es.neesis.mvcdemo.model.Producto;
import es.neesis.mvcdemo.model.ProductoCarta;

import java.util.List;
public interface ICartaService {
    List<ProductoCartaDTO> getProductos();

    void addProducto(ProductoCartaDTO producto)throws BusinessException;
    void updateProducto(ProductoCartaDTO producto)throws BusinessException;
    void removeProducto(Long productoId)throws BusinessException;

}
