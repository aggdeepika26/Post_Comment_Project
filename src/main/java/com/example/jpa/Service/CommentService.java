package com.example.jpa.Service;

import com.example.jpa.model.Comment;
import com.example.jpa.model.Post;

import java.util.List;

public interface CommentService {

    void saveComment(Comment comment);

    void deleteCommentById(Long id);
}
