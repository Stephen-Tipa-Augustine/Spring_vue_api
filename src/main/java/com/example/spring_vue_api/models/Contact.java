package com.example.spring_vue_api.models;
import javax.persistence.*;
 
@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @Column(name = "email", nullable = false, length = 45)
    private String email;
     
    @Column(name = "name", nullable = false, length = 64)
    private String name;
     
    @Column(name = "message", nullable = false, length = 500)
    private String message;

    public Contact() {

    }

    public Contact(String name, String email, String message) {
        this.name = name;
        this.email = email;
        this.message = message;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }
    
}
