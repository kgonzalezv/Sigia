package com.ltp.sigia.controller;

import com.ltp.sigia.model.Category;
import com.ltp.sigia.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/categorias")
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    @GetMapping("")
    public String getCategorias(@RequestParam(value = "nombreODescricion", required = false) String nombreOrDescripcion, Model model) {
        List<Category> categories = categoryService.getCategories();
        List<Category> categoriasFiltrada = categoryService.buscarCategoriasPorNombreODescripcion(nombreOrDescripcion);
        if (nombreOrDescripcion != null) {
            model.addAttribute("categorias", categoriasFiltrada);
        } else {
            model.addAttribute("categorias", categories.isEmpty() ? Collections.emptyList() : categories);
        }
        model.addAttribute("categoria", new Category());
        return "categorias";
    }

    @PostMapping("/nuevo")
    public String grabarCategoria(@ModelAttribute("categoria") Category category) {
        categoryService.guardarCategoria(category);
        return "redirect:/categorias";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPorId(@PathVariable Long id) {
        categoryService.eliminarCategoriaPorId(id);
        return "redirect:/categorias";
    }

    @GetMapping("/editar/{id}")
    public String mostrarModal(@PathVariable("id") Long id, Model model) {
        Optional<Category> category = categoryService.getCategoriaPorId(id);
        model.addAttribute("categoria", category.isPresent() ? category.get() : null);
        return "fragments/modalEditarCategoria";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable("id") Long id, @ModelAttribute("categoria") Category category) {
        categoryService.actualizarCategoria(category);
        return "redirect:/categorias";
    }

    @GetMapping("/buscar/{nombreODescripcion}")
    public String buscarPorNombreODescripcion(@PathVariable("nombreODescripcion") String nombreODescripcion, Model model) {
        List<Category> categorias = categoryService.buscarCategoriasPorNombreODescripcion(nombreODescripcion);
        model.addAttribute("categorias", categorias);
        return "redirect:/categorias";
    }
}
