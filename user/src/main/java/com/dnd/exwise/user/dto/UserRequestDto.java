package com.dnd.exwise.user.dto;

import jakarta.validation.constraints.NotBlank;

public class UserRequestDto {


    @NotBlank(message = "username is required!")
    private String username;

    @NotBlank(message = "email is required!")
    private String email;

    public UserRequestDto(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
