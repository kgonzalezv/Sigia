package com.ltp.sigia.service;

import com.ltp.sigia.model.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getProductos();

    public void crearProducto(Product product);
}
