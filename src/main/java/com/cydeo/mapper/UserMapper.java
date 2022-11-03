package com.cydeo.mapper;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.entity.Role;
import com.cydeo.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public User convertToEntity(UserDTO dto){ // give me the UserDto and I will give you the entity
        return modelMapper.map(dto,User.class);
    }

    public UserDTO convertToDto(User entity){ // give me the User entity, and I will give you the UserDto
        return modelMapper.map(entity,UserDTO.class);
    }
}
