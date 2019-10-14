package com.example.shopapp.controllers;

import com.example.shopapp.entities.Product;
import com.example.shopapp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
    // http://localhost:8080/app/index

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

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

    @GetMapping("/details/{id}")
    public String detailsPage(Model model, @PathVariable("id") Long id) {
        Product product = productService.getProducts().get(id.intValue() - 1);
        model.addAttribute("product", product);
        return "details";
    }
}
