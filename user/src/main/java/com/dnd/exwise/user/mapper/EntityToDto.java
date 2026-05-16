package com.dnd.exwise.user.mapper;

import com.dnd.exwise.user.dto.UserResponseDto;
import com.dnd.exwise.user.entity.UserEntity;

import java.util.List;

public class EntityToDto {

    public static UserResponseDto userEntityTODto(UserEntity user) {
        return new UserResponseDto(user.getUserId(), user.getUsername(), user.getEmail(), user.getCreatedAt());
    }

    public static List<UserResponseDto> userEntityTODto(List<UserEntity> users) {
        return users.stream().map(user -> EntityToDto.userEntityTODto(user)).toList();
    }
}
