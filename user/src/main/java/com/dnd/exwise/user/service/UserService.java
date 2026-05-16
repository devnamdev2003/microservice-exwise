package com.dnd.exwise.user.service;

import com.dnd.exwise.user.dto.UserRequestDto;
import com.dnd.exwise.user.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto save(UserRequestDto user);

    UserResponseDto getById(Long id);

    List<UserResponseDto> getAll();

    UserResponseDto update(UserRequestDto user, Long id);

    UserResponseDto delete(Long id);

    List<UserResponseDto> saveBulk(List<UserRequestDto> users);

    String deleteAll();
}
