package com.example.jpa.Service;

import com.example.jpa.model.Comment;
import com.example.jpa.model.Post;
import com.example.jpa.repository.CommentRepository;
import com.example.jpa.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository)
    {
        this.commentRepository= commentRepository;
    }

    @Override
    public void saveComment(Comment comment)

    {
        this.commentRepository.save(comment);

    }

    public void deleteCommentById(Long id)
    {
        this.commentRepository.deleteById(id);
    }


}
