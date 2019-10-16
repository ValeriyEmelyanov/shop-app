package com.example.shopapp.controllers;

import com.example.shopapp.entities.Product;
import com.example.shopapp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

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
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "shop";
    }

    @GetMapping("/cart")
    public String cartPage(Model model) {
        List<Product> products = new ArrayList<>();
        model.addAttribute("products", products);
        return "cart";
    }

    @GetMapping("/details/{id}")
    public String detailsPage(Model model, @PathVariable("id") Long id) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "details";
    }

    @GetMapping("/find_by_title")
    public String detailsPage(Model model, @RequestParam("title") String title) {
        Product product = productService.getByTitle(title);
        model.addAttribute("product", product);
        return "details";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        productService.deleteById(id);
        return "redirect:/shop";
    }
}
