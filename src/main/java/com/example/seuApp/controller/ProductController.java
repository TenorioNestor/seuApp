package com.example.seuApp.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.seuApp.domain.product.Product;
import com.example.seuApp.domain.product.ProductRepository;
import com.example.seuApp.domain.product.RequestProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository repository;
    @GetMapping
    public ResponseEntity getAllProduct(){
        var allProducts = repository.findAll();
        return  ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity registerProduct(@RequestBody @Validated RequestProduct data){
        Product newProduct = new Product(data);
        System.out.println(data);
        repository.save(newProduct);
        return ResponseEntity.ok("Produto Enviado");
    }

}
