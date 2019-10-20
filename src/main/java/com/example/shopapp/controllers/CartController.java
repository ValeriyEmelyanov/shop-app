package com.example.shopapp.controllers;

import com.example.shopapp.entities.Order;
import com.example.shopapp.entities.OrderItem;
import com.example.shopapp.entities.Product;
import com.example.shopapp.services.OrderService;
import com.example.shopapp.utils.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    private ShoppingCart cart;

    private OrderService orderService;

    @Autowired
    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String cartPage(Model model) {
        model.addAttribute("items", cart.getItems());
        return "cart";
    }

    @GetMapping("/add/{id}")
    public String addProductToCart(Model model, @PathVariable("id") Long id) {
        cart.addProductById(id);
        return "redirect:/shop";
    }

    @GetMapping("/create_order")
    public String createOrder(Principal principal) {
        Order order = new Order();

//        order.setItems(new ArrayList<>());
//        cart.getItems().forEach(i -> {i.setOrder(order); order.getItems().add(i);});
        List<OrderItem> items = new ArrayList<>();
        cart.getItems().forEach(i -> {i.setOrder(order); items.add(i);});
        cart.getItems().clear();

        order.setUsername(principal.getName());
        order.setItems(items);
        orderService.saveOrder(order);

        return "redirect:/shop";
    }

}
