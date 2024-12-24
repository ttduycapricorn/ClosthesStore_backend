package com.devteria.server.controller;

import com.devteria.server.entity.Comment;
import com.devteria.server.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/product/{productId}")
    public CompletableFuture<ResponseEntity<List<Comment>>> getComments(@PathVariable Long productId) {
        // Use the instance method through the service object
        return commentService.getCommentsByProductId(productId)
                .thenApply(ResponseEntity::ok);
    }
}