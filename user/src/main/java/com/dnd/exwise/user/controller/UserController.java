package com.dnd.exwise.user.controller;

import com.dnd.exwise.user.dto.UserRequestDto;
import com.dnd.exwise.user.dto.UserResponseDto;
import com.dnd.exwise.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponseDto save(@Valid @RequestBody UserRequestDto user) {
        return userService.save(user);
    }

    @GetMapping("/all")
    public List<UserResponseDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{userId}")
    public UserResponseDto getById(@PathVariable Long userId) {
        return userService.getById(userId);
    }

    @PutMapping("/{userId}")
    public UserResponseDto update(@Valid @RequestBody UserRequestDto user, @PathVariable Long userId) {
        return userService.update(user, userId);
    }

    @DeleteMapping("/{userId}")
    public UserResponseDto delete(@PathVariable Long userId) {
        return userService.delete(userId);
    }

    @PostMapping("/save-bulk")
    public List<UserResponseDto> saveBulk(@Valid @RequestBody List<UserRequestDto> users) {
        return userService.saveBulk(users);
    }

    @DeleteMapping("/delete-bulk")
    public String deleteAll() {
        return userService.deleteAll();
    }
}
