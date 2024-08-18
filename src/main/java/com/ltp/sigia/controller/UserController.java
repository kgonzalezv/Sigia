package com.ltp.sigia.controller;


import com.ltp.sigia.model.User;
import com.ltp.sigia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login(Model model,  String username, String password){
        Optional<User> user = userService.getUser(username, password);
       return user.isPresent() ? "User login": "No presente";
    }

}
