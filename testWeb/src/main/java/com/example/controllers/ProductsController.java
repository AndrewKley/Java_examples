package com.example.controllers;

import com.example.models.Product;
import com.example.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductsController {
    private final ProductService productService;

    ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String viewProducts(Model model) {
        List<Product> products = productService.findAll();
            model.addAttribute("products", products);
        return "products";
    }

//    @RequestMapping(path = "/products", method = RequestMethod.POST)
//    public String addProduct(
//            @RequestParam String name,
//            @RequestParam double price,
//            Model model) {
    @PostMapping("/products")
    public String addProduct(
                Product product,
                Model model
    ) {
//        Product p = new Product();
//        p.setName(name);
//        p.setPrice(price);
//        productService.addProduct(p);
        productService.addProduct(product);

        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products";
    }
}
