package com.naumovets.spring.web.controllers;

import com.naumovets.spring.web.model.Product;
import com.naumovets.spring.web.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    ProductRepository productRepository;

    @Autowired
    public void setProductRepository() {
        this.productRepository = new ProductRepository();
    }

    @GetMapping("/getProducts")
    public String showAllProducts(Model model) {
        model.addAttribute("products", productRepository.getProducts());
        return "products_page";
    }

    @GetMapping("/product/{id}")
    public String productInfo(Model model, @PathVariable Long id) {
        Product product = productRepository.findById(id);
        model.addAttribute("product", product);
        return "product_page";
    }

    @GetMapping("/form")
    public String getForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "addProduct_page";
    }

    @PostMapping("/form")
    public String addProduct(Product product) {
        productRepository.addProduct(product);
        return "addProduct_page";
    }
}
