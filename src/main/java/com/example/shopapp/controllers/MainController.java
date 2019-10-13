package com.example.shopapp.controllers;

import com.example.shopapp.entities.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/index")
    public String homePage() {
        return "index";
    }

    @GetMapping("/shop")
    public String shopPage(Model model) {
        Product product = new Product(1L, "Milk", 80);
        model.addAttribute("product", product);
        return "shop";
    }
}
