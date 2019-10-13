package com.example.shopapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/index")
    public String homePage() {
        return "index";
    }

    @GetMapping("/shop")
    public String shopPage() {
        return "shop";
    }
}
