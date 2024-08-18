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

    @Autowired
    UserService userService;

    @GetMapping( "/")
    public String getProductos(Model model) {
        model.addAttribute("productos", productService.getProductos());
        model.addAttribute("producto", new Product());
        model.addAttribute("categorias", categoryService.getCategories());
        return "productos";
    }
    @PostMapping("/nuevo")
    public String submitProducto( @ModelAttribute("producto") Product producto) {
        productService.crearProducto(producto);
        return "redirect:/productos";
    }

  /*  @PostMapping("/login")
    public String login(@ModelAttribute("user")User user){
        Optional<User> found = userService.getUser(user.getUsername(), user.getPassword());
       return found.isPresent()? "productos": "Not found";
    }*/


}
