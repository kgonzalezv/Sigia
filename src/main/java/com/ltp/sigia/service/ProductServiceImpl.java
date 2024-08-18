package com.ltp.sigia.service;

import com.ltp.sigia.model.Product;
import com.ltp.sigia.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
