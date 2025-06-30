package com.example.demo.controller;
import java.time.LocalDateTime;
import java.util.Map;  // DTO importu
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserRequest;
import com.example.demo.model.User;

@RestController
public class UserController {

private final Map<UUID, User> userMap = new ConcurrentHashMap<>();

@GetMapping("/users/getuser/{id}")
public User getUser(@PathVariable UUID id) {
    return userMap.get(id);
}

@PostMapping("/users/newuser")
public String createUser(@RequestBody UserRequest userRequest) {
    UUID id = UUID.randomUUID();
    User newUser = new User(id, userRequest.getUserName(), userRequest.getUserPassword(), LocalDateTime.now());
    userMap.put(id, newUser);
    return "User " +userRequest.getUserName() + " created with id: " + id;
}

@PutMapping("/users/updateuser/{id}")
public String updateUser(@PathVariable UUID id, @RequestBody UserRequest userRequest) {
    User existingUser = userMap.get(id);
    if (existingUser == null) {
        return "User not found";
    }
    existingUser.setUserName(userRequest.getUserName());
   
    userMap.put(id, existingUser);
    return "User " + userRequest.getUserName() + " updated successfully!";
}

    @DeleteMapping("users/deleteuser{id}")
    public String userDeletion(@PathVariable("id") UUID userId, @RequestBody UserRequest userRequest) {
        userMap.remove(userId);
        return "User " + userRequest.getUserName() +  " with id: " + userId + " is deleted successfully!";
    }
}


/* @GetMapping("/yol")         → URL'den veri al
@PostMapping("/yol")        → Form/JSON ile veri gönder
@PutMapping("/yol")         → Veri güncelle
@DeleteMapping("/yol")      → Veri sil
@RequestMapping("/taban")   → Diğer mapping'lerin önüne eklenir
 */