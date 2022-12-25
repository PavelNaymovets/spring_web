package com.naumovets.spring.web.repositories;

import com.naumovets.spring.web.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> list;

    public ProductRepository() {
        list = new ArrayList<>(Arrays.asList(
                new Product(1L, "sugar", 100),
                new Product(2L, "milk", 10),
                new Product(3L, "bread", 20),
                new Product(4L, "orange", 5),
                new Product(5L, "tea", 15)
        ));
    }

    public List<Product> getProducts(){
        return list;
    }

    public Product findById(Long id) {
        return list.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addProduct(Product product) {
        list.add(product);
    }

}
