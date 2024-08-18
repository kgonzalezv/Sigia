package com.ltp.sigia.controller;

import com.ltp.sigia.model.Category;
import com.ltp.sigia.model.Product;
import com.ltp.sigia.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public String getCategorias(Model model){
        model.addAttribute("categorias", categoryService.getCategories());
        model.addAttribute("categoria", new Category());
        return "categorias";
    }

    @PostMapping("/nuevo")
    public String grabarCategoria(@ModelAttribute("categoria") Category category){
        categoryService.guardarCategoria(category);
        return "redirect:/categorias";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPorId(@PathVariable Long id) {
        categoryService.eliminarCategoriaPorId(id);
        return "redirect:/categorias";
    }

    @GetMapping("/editar")
    public String editarPorId(@RequestParam Long id, Model model) {
        Category category = categoryService.getCategoriaPorId(id);
        model.addAttribute("categoria", category);
        return "fragments/modal :: form-editar-categoria";
    }

    @GetMapping("/editar/{id}")
    public String mostrarModal(@PathVariable Long id, Model model) {
        Category category = categoryService.getCategoriaPorId(id);
        model.addAttribute("categoria", category);
        return "fragments/modal :: form-editar-categoria";
    }


    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute("categoria") Category category){
        categoryService.actualizarCategoria(category);
        return "redirect:/categorias";
    }
}
