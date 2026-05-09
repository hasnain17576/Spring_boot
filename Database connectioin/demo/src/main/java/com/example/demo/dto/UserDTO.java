package com.example.demo.dto;

import jakarta.validation.constraints.*;

public class UserDTO {

    @NotBlank(message = "Name empty nahi ho sakta")
    private String name;

    @Email(message = "Email sahi nahi hai")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}