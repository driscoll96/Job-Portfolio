package com.tipperoo.springbootInfrastructure.controller;

import com.tipperoo.springbootInfrastructure.dao.Tag;
import com.tipperoo.springbootInfrastructure.repos.TagRepository;
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
@RequestMapping(path="/tag")
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @PostMapping(path="/add")
    public @ResponseBody
    String addNewTag (@RequestParam Integer giftId, @RequestParam Integer userId, @RequestParam String tagName) {
        Tag newTag = new Tag();
        newTag.setUserId(userId);
        newTag.setGiftId(giftId);
        newTag.setTagName(tagName);
        newTag.setDateCreated(new Timestamp(System.currentTimeMillis()));
        Tag newCreatedTag = tagRepository.save(newTag);
        return "Saved with TagId: " + newCreatedTag.getTagId();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateTag(@RequestBody Tag tag, @PathVariable Integer id) {
        Optional<Tag> studentOptional = tagRepository.findById(id);
        if (studentOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        tag.setTagId(id);
        tag.setDateUpdated(new Timestamp(System.currentTimeMillis()));
        tagRepository.save(tag);
        return ResponseEntity.ok("Updated tag: " + id + "\nwith new details:\n" + tag);
    }

    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<Object> deleteTag(@PathVariable Integer id) {
        try {
            tagRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Deletion failed: tag entity not found");
        }
        return ResponseEntity.ok("Deleted tag: " + id);
    }

    @GetMapping(path="/get/{id}")
    public @ResponseBody Optional<Tag> getTag(@PathVariable Integer id) {
        return tagRepository.findById(id);
    }

    @GetMapping(path="/get/all")
    public @ResponseBody Iterable<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @GetMapping(path="/get/all/{giftId}")
    public @ResponseBody Iterable<Tag> getTagsInGift(@PathVariable Integer giftId) {
        Iterable<Tag> allTags = tagRepository.findAll();
        List<Tag> searchResults = new ArrayList<>();
        for (Tag Tag: allTags) {
            if (Tag.getGiftId().equals(giftId)) {
                searchResults.add(Tag);
            }
        }
        return searchResults;
    }
    
}
