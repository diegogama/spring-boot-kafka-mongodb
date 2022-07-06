package com.product.controller;

import com.product.model.Product;
import com.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping("/product")
    public void createNote(@RequestBody Product product) {
         service.sendMessageKafka(product);
    }

}
