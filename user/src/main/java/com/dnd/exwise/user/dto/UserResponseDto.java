package com.dnd.exwise.user.dto;

import java.time.LocalDateTime;

public class UserResponseDto {


    private Long userId;

    private String username;

    private String email;

    private LocalDateTime createdAt;

    public UserResponseDto(Long id, String username, String email, LocalDateTime createdAt) {
        this.userId = id;
        this.username = username;
        this.email = email;
        this.createdAt = createdAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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
