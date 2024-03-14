package es.neesis.mvcdemo.service.impl;

import es.neesis.mvcdemo.model.Producto;
import es.neesis.mvcdemo.repository.IProductoRepository;
import es.neesis.mvcdemo.service.BusinessException;
import es.neesis.mvcdemo.service.IAlmacenService;
import es.neesis.mvcdemo.utils.BusinessChecks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlmacenService implements IAlmacenService {

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto getProducto(Long productoId) throws BusinessException {
        Optional<Producto> producto = productoRepository.findById(productoId);
        BusinessChecks.exists(producto,"El producto no existe");

        return producto.get();
    }

    @Override
    public void addProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void deleteProducto(Long productoId) {
        productoRepository.deleteById(productoId);
    }
}
