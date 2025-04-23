package com.example.lab2p2oop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.lab2p2oop.model.User;

@Controller
public class MainController {

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/processForm")
    public String processForm(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("userData", user);
        return "secondPage";
    }
}