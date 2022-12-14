package com.step.dz8.controller;

import com.step.dz8.model.Pizza;
import com.step.dz8.model.Toppings;
import com.step.dz8.model.User;
import com.step.dz8.repository.UserRepository;
import com.step.dz8.service.MailSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserRepository repository;
    @Autowired
    private MailSend sendEmail;
    @GetMapping("/*")
    public String getUsers(Model model){
        model.addAttribute("users",repository.findAll());
        return "main";
    }

    @GetMapping("/add")
    public String getUserForm(Model model){
        model.addAttribute("pizzas", Pizza.values());
        model.addAttribute("toppings", Toppings.values());
        model.addAttribute("user",new User());
        return "addOrders";
    }
    @PostMapping("/add")
    public String addUser(User user){
        repository.save(user);
        try {
            sendEmail.SendMail(user);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }



}
