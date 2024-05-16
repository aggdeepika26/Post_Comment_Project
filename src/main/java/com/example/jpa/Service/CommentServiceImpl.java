package com.example.jpa.Service;

import com.example.jpa.model.Comment;
import com.example.jpa.model.Post;
import com.example.jpa.repository.CommentRepository;
import com.example.jpa.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository)
    {
        this.commentRepository= commentRepository;
    }

    @Override
    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getCommentById(Long id)
    {
        Optional<Comment> commentOptional = commentRepository.findById(id);
        Comment comment = null;
        if(commentOptional.isPresent())
        {
            comment = commentOptional.get();

        }
        else
        {
            throw new RuntimeException("No Comment found" );
        }
        return comment;

    }

    @Override
    public void saveComment(Comment comment)
    {
        this.commentRepository.save(comment);

    }
    @Override

    public void deleteCommentById(Long id)
    {
        this.commentRepository.deleteById(id);
    }


}
