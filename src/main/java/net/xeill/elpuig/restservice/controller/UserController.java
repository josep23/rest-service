package net.xeill.elpuig.restservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.xeill.elpuig.restservice.exception.ResourceNotFoundException;

import net.xeill.elpuig.restservice.model.User;
import net.xeill.elpuig.restservice.repository.UserRepository;

/**
 * Created by rusben on 22/04/21.
 */
@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost" })
@RequestMapping("/api")

public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    //public Note createNote(@Valid @RequestBody Note note) {
    //https://stackoverflow.com/questions/51337489/content-type-multipart-form-databoundary-webkitformboundary-not-suppor
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable(value = "id") Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable(value = "id") Integer userId,
                                           @Valid @RequestBody User userDetails) {

    	User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        user.setEmail(userDetails.getEmail());
        user.setFullname(userDetails.getFullname());
        user.setPassword(userDetails.getPassword());
        
        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }
}
