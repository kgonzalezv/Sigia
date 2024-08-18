package com.ltp.sigia.service;

import com.ltp.sigia.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();

    void guardarCategoria (Category category);
    void eliminarCategoriaPorId(Long id);

    Category actualizarCategoria(Category category);

    Category getCategoriaPorId(Long id);
}
