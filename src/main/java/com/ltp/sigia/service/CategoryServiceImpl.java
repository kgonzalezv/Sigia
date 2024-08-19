package com.ltp.sigia.service;

import com.ltp.sigia.model.Category;
import com.ltp.sigia.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void guardarCategoria(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void eliminarCategoriaPorId(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category actualizarCategoria(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> getCategoriaPorId(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> buscarCategoriasPorNombreODescripcion(String nombreODescripcion) {
        return categoryRepository.findByNombreOrDescripcion(nombreODescripcion, nombreODescripcion);
    }
}
