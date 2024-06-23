package com.tipperoo.springbootInfrastructure.controller;

import com.tipperoo.springbootInfrastructure.dao.Comment;
import com.tipperoo.springbootInfrastructure.repos.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/comment")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @PostMapping(path="/add")
    public @ResponseBody
    String addNewComment (@RequestParam Integer giftId, @RequestParam Integer userId, @RequestParam String message) {
        Comment newComment = new Comment();
        newComment.setUserId(userId);
        newComment.setGiftId(giftId);
        newComment.setMessage(message);
        newComment.setDateCreated(new Timestamp(System.currentTimeMillis()));
        Comment newCreatedComment = commentRepository.save(newComment);
        return "Saved with CommentId: " + newCreatedComment.getCommentId();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateComment(@RequestBody Comment comment, @PathVariable Integer id) {
        System.out.println("comment json: " + comment.toString());
        Optional<Comment> studentOptional = commentRepository.findById(id);
        if (studentOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        comment.setCommentId(id);
        comment.setDateUpdated(new Timestamp(System.currentTimeMillis()));
        commentRepository.save(comment);
        return ResponseEntity.ok("Updated comment: " + id + "\nwith new details:\n" + comment);
    }

    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<Object> deleteComment(@PathVariable Integer id) {
        try {
            commentRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Deletion failed: comment entity not found");
        }
        return ResponseEntity.ok("Deleted comment: " + id);
    }

    @GetMapping(path="/get/{id}")
    public @ResponseBody
    Optional<Comment> getComment(@PathVariable Integer id) {
        return commentRepository.findById(id);
    }

    @GetMapping(path="/get/all/{giftId}")
    public @ResponseBody
    Iterable<Comment> getCommentsInGift(@PathVariable Integer giftId) {
        Iterable<Comment> allComments = commentRepository.findAll();
        List<Comment> searchResults = new ArrayList<>();
        for (Comment comment: allComments) {
            if (comment.getGiftId().equals(giftId)) {
                searchResults.add(comment);
            }
        }
        return searchResults;
    }
    
}
