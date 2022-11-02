package com.cydeo.mapper;

import com.cydeo.dto.RoleDTO;
import com.cydeo.entity.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    private  ModelMapper modelMapper;

    public RoleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Role convertToEntity(RoleDTO dto){ // give me the RoleDto and I will give you the entity
       return modelMapper.map(dto,Role.class);
    }

    public RoleDTO convertToDto(Role entity){
       return modelMapper.map(entity,RoleDTO.class);
    }
}
