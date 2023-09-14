package com.tipperoo.springbootInfrastructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tipperoo.springbootInfrastructure.CoinBalanceHandler;
import com.tipperoo.springbootInfrastructure.dao.Gift;
import com.tipperoo.springbootInfrastructure.repos.GiftRepository;
import com.tipperoo.springbootInfrastructure.repos.UserRepository;
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
@RequestMapping(path="/gift")
public class GiftController {

    @Autowired
    private GiftRepository giftRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add")
    public @ResponseBody ResponseEntity<Object> addNewGift (@RequestParam Integer gifterUserId, @RequestParam Integer recipientUserId,
                                       @RequestParam Integer amountGiven, @RequestParam Boolean anonymous,
                                       @RequestParam String message) throws Exception {
        Gift newGift = new Gift();
        CoinBalanceHandler coinBalanceHandler = new CoinBalanceHandler(userRepository);
        if (coinBalanceHandler.validateUserBalance(gifterUserId, amountGiven)) {
            newGift.setAmountGiven(amountGiven);
            newGift.setGifterUserId(gifterUserId);
            newGift.setAnonymous(anonymous);
            newGift.setMessage(message);
            newGift.setRecipientUserId(recipientUserId);
            newGift.setDateCreated(new Timestamp(System.currentTimeMillis()));
            Gift newCreatedGift = giftRepository.save(newGift);
            coinBalanceHandler.changeGiftUsersBalances(gifterUserId, recipientUserId, amountGiven);
            ObjectMapper mapper = new ObjectMapper();
            return ResponseEntity.ok(mapper.writeValueAsString(newCreatedGift));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Gift creation failed: amount given exceeds " +
                    "gifter's coin balance");
        }
    }

    @GetMapping(path="/get/{id}")
    public @ResponseBody Optional<Gift> getGift(@PathVariable Integer id) {
        return giftRepository.findById(id);
    }

    @GetMapping(path="/get/all/{userId}")
    public @ResponseBody Iterable<Gift> getGiftsByUserId(@PathVariable Integer userId) {
        Iterable<Gift> allGifts = giftRepository.findAll();
        List<Gift> searchResults = new ArrayList<>();
        for (Gift gift: allGifts) {
            if (gift.getGifterUserId().equals(userId) || gift.getRecipientUserId().equals(userId)) {
                searchResults.add(gift);
            }
        }
        return searchResults;
    }

    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<Object> deleteGift(@PathVariable Integer id) {
        try {
            giftRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Deletion failed: gift entity not found");
        }
        return ResponseEntity.ok("Deleted gift: " + id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateGift(@RequestBody Gift gift, @PathVariable Integer id) {
        Optional<Gift> studentOptional = giftRepository.findById(id);
        if (studentOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        gift.setGiftId(id);
        gift.setDateUpdated(new Timestamp(System.currentTimeMillis()));
        giftRepository.save(gift);
        return ResponseEntity.ok("Updated gift: " + id + "\nwith new details:\n" + gift);
    }

    @GetMapping(path="/get/given/{userId}")
    public @ResponseBody Iterable<Gift> getGivenGiftsByUserId(@PathVariable Integer userId) {
        Iterable<Gift> allGifts = giftRepository.findAll();
        List<Gift> searchResults = new ArrayList<>();
        for (Gift gift: allGifts) {
            if (gift.getGifterUserId().equals(userId)) {
                searchResults.add(gift);
            }
        }
        return searchResults;
    }

    @GetMapping(path="/get/received/{userId}")
    public @ResponseBody Iterable<Gift> getReceivedGiftsByUserId(@PathVariable Integer userId) {
        Iterable<Gift> allGifts = giftRepository.findAll();
        List<Gift> searchResults = new ArrayList<>();
        for (Gift gift: allGifts) {
            if (gift.getRecipientUserId().equals(userId)) {
                searchResults.add(gift);
            }
        }
        return searchResults;
    }
}
