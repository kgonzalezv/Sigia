package com.ltp.sigia.service;

import com.ltp.sigia.model.Product;
import com.ltp.sigia.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Override
    public List<Product> getProductos() {
        return repository.findAll();
    }

    @Override
    public void crearProducto(Product product) {
        repository.save(product);
    }

    @Override
    public void eliminarProductoPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Product> getProductoPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public void actualizarProducto(Product product) {
        repository.save(product);
    }

    @Override
    public List<Product> buscarProductosPorNombreOrDescripcion(String nombreODescripcion) {
        return repository.findByNombreOrDescripcion(nombreODescripcion, nombreODescripcion);
    }
}
