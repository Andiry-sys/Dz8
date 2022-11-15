package com.step.dz8.controller;

import com.step.dz8.model.Pizza;
import com.step.dz8.model.User;
import com.step.dz8.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @Autowired
    private UserRepository repository;
    @GetMapping("/*")
    public String getUsers(Model model){
        model.addAttribute("users",repository.findAll());
        return "users";
    }

    @GetMapping("/add")
    public String getUserForm(Model model){
        model.addAttribute("pizzas", Pizza.values());
        model.addAttribute("users",new User());
        return "user_add";
    }
}
