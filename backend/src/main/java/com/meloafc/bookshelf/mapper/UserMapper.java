package com.meloafc.bookshelf.mapper;

import com.meloafc.bookshelf.dto.UserDTO;
import com.meloafc.bookshelf.model.User;

public class UserMapper implements GenericMapper<User, UserDTO> {

    @Override
    public UserDTO convertToDTO(User entity) {
        return UserDTO.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .name(entity.getName())
                .build();
    }

    @Override
    public User convertToEntity(UserDTO dto) {
        return User.builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .name(dto.getName())
                .password(dto.getPassword())
                .build();
    }

}
