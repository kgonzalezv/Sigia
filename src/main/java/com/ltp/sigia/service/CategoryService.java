package com.ltp.sigia.service;

import com.ltp.sigia.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getCategories();

    void guardarCategoria (Category category);
    void eliminarCategoriaPorId(Long id);

    Category actualizarCategoria(Category category);

    Optional<Category> getCategoriaPorId(Long id);

    List<Category> buscarCategoriasPorNombreODescripcion(String nombre);
}
