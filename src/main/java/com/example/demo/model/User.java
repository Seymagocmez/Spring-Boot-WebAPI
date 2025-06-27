package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.UUID;
public class User {
    private UUID id;
    private String userName;
    private String userPassword;
   private LocalDateTime createdAt = LocalDateTime.now();
   //sadece görülmesi için şimdilik diğer constructor'lara farklı şekilde gidebilir.


// Constructor

    public User( UUID id, String userName, String userPassword, LocalDateTime createdAt) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.createdAt = createdAt;
    }

// Getter-Setter

//Id
    public UUID getId() { 
        return id; 
        }
    public void setId(UUID id) { 
        this.id = id;
        }

//User Name
    public String getUserName() {
         return userName; 
         }
    public void setUserName(String userName){ 
        this.userName = userName; 
        }

//User Password
    public String getUserPassword() { 
        return userPassword; 
        }
    public void setUserPassword(String userPassword){
         this.userPassword = userPassword;
         }

//User Creation Date-time


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;

    }
}
