package com.example.seuApp.controller;

import com.example.seuApp.domain.product.Category;
import com.example.seuApp.domain.product.CategoryRepository;
import com.example.seuApp.domain.product.RequestCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryRepository repository;
    @GetMapping
    public List<Category> findAll(){
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity registerCategory(@RequestBody @Validated RequestCategory data){
        Category newCategory = new Category(data);
        System.out.println(data);
        repository.save(newCategory);
        return ResponseEntity.ok().build();
    }
}
