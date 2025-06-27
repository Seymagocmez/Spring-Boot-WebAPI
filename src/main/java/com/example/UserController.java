package com.example.demo;
import com.example.demo.model.User;
import com.example.demo.dto.UserRequest;  // DTO importu
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.time.LocalDateTime;

@RestController
public class UserController {

    private Map<UUID, User> userMap = new ConcurrentHashMap<>();

    @GetMapping("/users/getuser/{id}")
public User getUser(@PathVariable UUID id) {
    return userMap.get(id);
}


@PostMapping("/users/newuser")
public String createUser(@RequestBody UserRequest userRequest) {
    UUID id = UUID.randomUUID();
    User newUser = new User(id, userRequest.getUserName(), userRequest.getUserPassword(), LocalDateTime.now());
    userMap.put(id, newUser);
    return "User created with id: " + id;
}

@PutMapping("/users/updateuser/{id}")
public String updateUser(@PathVariable UUID id, @RequestBody UserRequest userRequest) {
    User existingUser = userMap.get(id);
    if (existingUser == null) {
        return "User not found";
    }
    existingUser.setUserName(userRequest.getUserName());
   
    userMap.put(id, existingUser);
    return "User updated successfully";
}

    @DeleteMapping("users/deleteuser{id}")
    public String userDeletion(@PathVariable("id") UUID userId) {
        userMap.remove(userId);
        return "User with id: " + userId + " is deleted successfully!";
    }
}


/* @GetMapping("/yol")         → URL'den veri al
@PostMapping("/yol")        → Form/JSON ile veri gönder
@PutMapping("/yol")         → Veri güncelle
@DeleteMapping("/yol")      → Veri sil
@RequestMapping("/taban")   → Diğer mapping'lerin önüne eklenir
 */