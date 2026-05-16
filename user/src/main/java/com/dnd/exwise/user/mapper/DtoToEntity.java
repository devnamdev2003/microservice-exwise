package com.dnd.exwise.user.mapper;

import com.dnd.exwise.user.dto.UserRequestDto;
import com.dnd.exwise.user.entity.UserEntity;

public class DtoToEntity {

    public static UserEntity userReqDtoToEntity(UserRequestDto user) {
        return new UserEntity(user.getUsername(), user.getEmail());

    }
}
