package com.ltp.sigia.controller;

import com.ltp.sigia.model.Category;
import com.ltp.sigia.model.Product;
import com.ltp.sigia.model.User;
import com.ltp.sigia.service.CategoryService;
import com.ltp.sigia.service.ProductService;
import com.ltp.sigia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.rmi.MarshalledObject;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/productos")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public String getProductos(@RequestParam(value = "nombreODescripcion", required = false) String nombreOrDescripcion, Model model) {
        List<Product> productosFiltrados = productService.buscarProductosPorNombreOrDescripcion(nombreOrDescripcion);
        if (nombreOrDescripcion != null && !nombreOrDescripcion.isEmpty()) {
            model.addAttribute("productos", productosFiltrados);
        } else {
            model.addAttribute("productos", productService.getProductos());
        }
        model.addAttribute("producto", new Product());
        model.addAttribute("categorias", categoryService.getCategories());
        return "productos";
    }

    @PostMapping("/nuevo")
    public String submitProducto(@ModelAttribute("producto") Product producto) {
        productService.crearProducto(producto);
        return "redirect:/productos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPorId(@PathVariable Long id) {
        productService.eliminarProductoPorId(id);
        return "redirect:/productos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarModal(@PathVariable("id") Long id, Model model) {
        Optional<Product> productOptional = productService.getProductoPorId(id);
        Product product = productOptional.get();
        model.addAttribute("producto", product);
        model.addAttribute("categorias", product.getCategoria());
        return "fragments/modalEditarProducto";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@ModelAttribute("producto") Product product) {
        productService.actualizarProducto(product);
        return "redirect:/productos";
    }

}
