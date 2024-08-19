package com.ltp.sigia.repository;

import com.ltp.sigia.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNombreOrDescripcion(String nombre, String descripcion);
}
