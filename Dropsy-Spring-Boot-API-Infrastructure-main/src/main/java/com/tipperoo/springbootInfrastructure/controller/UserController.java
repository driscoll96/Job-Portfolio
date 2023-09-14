package com.tipperoo.springbootInfrastructure.controller;

import com.tipperoo.springbootInfrastructure.dao.User;
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
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String firstName, @RequestParam String lastName,
                                            @RequestParam String email, @RequestParam String password,
                                            @RequestParam String username) {
        User newUser = new User();
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setCoinBalance(0);
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setDateCreated(new Timestamp(System.currentTimeMillis()));
        User newCreatedUser = userRepository.save(newUser);
        return "Saved with UserId: " + newCreatedUser.getUserId();
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable Integer id) {
        Optional<User> studentOptional = userRepository.findById(id);
        if (studentOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        user.setUserId(id);
        user.setDateUpdated(new Timestamp(System.currentTimeMillis()));
        userRepository.save(user);
        return ResponseEntity.ok("Updated user: " + id + "\nwith new details:\n" + user);
    }

    @GetMapping(path="/get/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Integer id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Deletion failed: user entity not found");
        }
        return ResponseEntity.ok("Deleted user: " + id);
    }

    @GetMapping(path="/get/{id}")
    public @ResponseBody Optional<User> getUser(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    @GetMapping(path="/username/get/{username}")
    public @ResponseBody Iterable<User> getUsersByUsername(@PathVariable String username) {
        Iterable<User> allUsers = userRepository.findAll();
        List<User> searchResults = new ArrayList<>();
        for (User user: allUsers) {
            if (user.getUsername().toLowerCase().contains(username.toLowerCase())) {
                searchResults.add(user);
            }
        }
        return searchResults;
    }

}
