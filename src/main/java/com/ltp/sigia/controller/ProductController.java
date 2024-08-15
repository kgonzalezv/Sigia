package com.ltp.sigia.controller;

import com.ltp.sigia.model.Category;
import com.ltp.sigia.model.Product;
import com.ltp.sigia.repository.CategoryRepository;
import com.ltp.sigia.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;


    @PostMapping("/nuevoProducto")
    public String submitProducto(Product producto, BindingResult result) {
        productRepository.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/productos")
    public String getProductos(Model model) {
        model.addAttribute("productos", productRepository.findAll());
        return "productos";
    }

    @GetMapping("/")
    public String mostrarFormularioDeCreacion(Model model) {
        List<Category> categorias = categoryRepository.findAll();
        model.addAttribute("categorias", categorias);
        model.addAttribute("producto", new Product());
        return "redirect:/productos";
    }

}
