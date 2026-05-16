package com.dnd.exwise.user.serviceImpl;

import com.dnd.exwise.user.dto.UserRequestDto;
import com.dnd.exwise.user.dto.UserResponseDto;
import com.dnd.exwise.user.entity.UserEntity;
import com.dnd.exwise.user.exception.UserException;
import com.dnd.exwise.user.mapper.DtoToEntity;
import com.dnd.exwise.user.mapper.EntityToDto;
import com.dnd.exwise.user.repository.UserRepository;
import com.dnd.exwise.user.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto save(UserRequestDto user) {
        UserEntity newUser = userRepository.save(DtoToEntity.userReqDtoToEntity(user));
        return EntityToDto.userEntityTODto(newUser);
    }

    @Override
    public UserResponseDto getById(Long userId) {
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new UserException("user not found"));
        return EntityToDto.userEntityTODto(user);
    }

    @Override
    public List<UserResponseDto> getAll() {
        List<UserEntity> user = userRepository.findAll();
        return EntityToDto.userEntityTODto(user);
    }

    @Override
    public UserResponseDto update(UserRequestDto user, Long userId) {
        UserEntity existingUser = userRepository.findById(userId).orElseThrow(() -> new UserException("user not found"));
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        userRepository.save(existingUser);
        return EntityToDto.userEntityTODto(existingUser);
    }

    @Override
    public UserResponseDto delete(Long userId) {
        UserEntity existingUser = userRepository.findById(userId).orElseThrow(() -> new UserException("user not found"));
        userRepository.delete(existingUser);
        return EntityToDto.userEntityTODto(existingUser);
    }

    @Override
    public String deleteAll() {
        userRepository.deleteAll();
        return "Deleted All!";
    }

    @Transactional
    @Override
    public List<UserResponseDto> saveBulk(List<UserRequestDto> users) {
        List<UserEntity> newUsers = new ArrayList<>();
        for (UserRequestDto user : users) {
            UserEntity newUser = DtoToEntity.userReqDtoToEntity(user);
            userRepository.save(newUser);
            newUsers.add(newUser);
        }
        return EntityToDto.userEntityTODto(newUsers);
    }
}
