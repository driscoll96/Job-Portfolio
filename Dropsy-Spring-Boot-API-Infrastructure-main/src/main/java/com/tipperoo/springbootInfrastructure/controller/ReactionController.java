package com.tipperoo.springbootInfrastructure.controller;

import com.tipperoo.springbootInfrastructure.dao.Reaction;
import com.tipperoo.springbootInfrastructure.enums.ReactionObject;
import com.tipperoo.springbootInfrastructure.enums.ReactionType;
import com.tipperoo.springbootInfrastructure.repos.ReactionRepository;
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
@RequestMapping(path="/reaction")
public class ReactionController {

    @Autowired
    private ReactionRepository reactionRepository;

    @PostMapping(path="/add")
    public @ResponseBody
    String addNewReaction (@RequestParam Integer objectId, @RequestParam String reactionObject,
                           @RequestParam Integer userId, @RequestParam String reactionType) {
        Reaction newReaction = new Reaction();
        newReaction.setUserId(userId);
        newReaction.setObjectId(objectId);
        newReaction.setReactionObject(ReactionObject.valueOf(reactionObject));
        newReaction.setReactionType(ReactionType.valueOf(reactionType));
        newReaction.setDateCreated(new Timestamp(System.currentTimeMillis()));
        Reaction newCreatedReaction = reactionRepository.save(newReaction);
        return "Saved with ReactionId: " + newCreatedReaction.getReactionId();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateReaction(@RequestBody Reaction reaction, @PathVariable Integer id) {
        Optional<Reaction> studentOptional = reactionRepository.findById(id);
        if (studentOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        reaction.setReactionId(id);
        reaction.setDateUpdated(new Timestamp(System.currentTimeMillis()));
        reactionRepository.save(reaction);
        return ResponseEntity.ok("Updated reaction: " + id + "\nwith new details:\n" + reaction);
    }

    @GetMapping(path="/get/{id}")
    public @ResponseBody
    Optional<Reaction> getReaction(@PathVariable Integer id) {
        return reactionRepository.findById(id);
    }

    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<Object> deleteReaction(@PathVariable Integer id) {
        try {
            reactionRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Deletion failed: reaction entity not found");
        }
        return ResponseEntity.ok("Deleted reaction: " + id);
    }

    /**
     * Gets all the reactions tied to the gift or comment
     * @param objectType - either "Gift" or "Comment"
     * @param objectId - giftId or commentId
     * @return - all reactions tied to the gift or comment
     */
    @GetMapping(path="/get/all/{objectType}/{objectId}")
    public @ResponseBody Iterable<Reaction> getReactionsInGift(@PathVariable String objectType,
                                                               @PathVariable Integer objectId) {
        Iterable<Reaction> allReactions = reactionRepository.findAll();
        List<Reaction> searchResults = new ArrayList<>();
        for (Reaction reaction: allReactions) {
            if (reaction.getObjectId().equals(objectId) &&
                    ReactionObject.valueOf(objectType) == reaction.getReactionObject()) {
                searchResults.add(reaction);
            }
        }
        return searchResults;
    }
    
}
