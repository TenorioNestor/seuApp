package com.example.seuApp.controller;

import com.example.seuApp.domain.product.Comments;
import com.example.seuApp.domain.product.CommentsRepository;
import com.example.seuApp.domain.product.RequestComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentsController {
    @Autowired
    private CommentsRepository repository;

    @GetMapping
    public List<Comments> findAll(){
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity registerComment(@RequestBody @Validated RequestComments data){
        Comments newComment = new Comments(data);
        System.out.println(data);
        repository.save(newComment);
        return  ResponseEntity.ok("Comentário Enviado com Sucesso!");
    }
}
