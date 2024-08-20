package com.ltp.sigia.controller;


import com.ltp.sigia.model.User;
import com.ltp.sigia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public String formularioLogin(Model model){
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/login")
    public String login(User user){
        Optional<User> userOp = userService.getUser(user.getUsername(), user.getPassword());
        if(userOp.isPresent()){
            return "redirect:/productos";
        }
       return "redirect:/error";
    }

}
