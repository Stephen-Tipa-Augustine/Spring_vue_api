package com.example.spring_vue_api.payload.request;
import javax.validation.constraints.*;

public class ContactRequest {
    @NotBlank
    @Size(min = 3, max = 64)
    private String name;

    @NotBlank
    @Size(max = 45)
    @Email
    private String email;

    @NotBlank
    @Size(min = 3, max = 500)
    private String message;
    
    public void setEmail(String email) {
        this.email = email;
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

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }
}
