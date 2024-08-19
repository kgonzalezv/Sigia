package com.ltp.sigia.service;

import com.ltp.sigia.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

     List<Product> getProductos();

     void crearProducto(Product product);

    void eliminarProductoPorId(Long id);

    Optional<Product> getProductoPorId(Long id);

    void actualizarProducto(Product product);

    List<Product> buscarProductosPorNombreOrDescripcion(String nombreODescripcion);


}
