package com.devteria.server.service;

import com.devteria.server.entity.Comment;
import com.devteria.server.repository.CommentRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Async
    public CompletableFuture<List<Comment>> getCommentsByProductId(Long productId) {
        List<Comment> comments = commentRepository.findByProductId(productId);
        return CompletableFuture.completedFuture(comments);
    }

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
