package com.cydeo.service.impl;

import com.cydeo.dto.RoleDTO;
import com.cydeo.entity.Role;
import com.cydeo.mapper.RoleMapper;
import com.cydeo.repository.RoleRepository;
import com.cydeo.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }


    @Override
    public List<RoleDTO> listAllRoles() {
    // Controller called me and requesting all RoleDto, so it can show in the drop-down in the UI
        // I need to make a call to Db and get all the roles from table
        // go to repository and find a service which gives me rhe roles fromDB
        // how I will cal any service here? = DI(dep inj)

       List<Role>roleList = roleRepository.findAll();

  // I have Role entities from DB
        // I need to convert this Role entities to DTOs
        // I need to use ModelMapper
        // I already created a class called RoleMapper and there are methods for me that will make this for conversion

       return roleList.stream().map(roleMapper::convertToDto).collect(Collectors.toList());

    }

    @Override
    public RoleDTO findById(Long id) {
        // get the ID and look in DB for it
        // The RoleDto is coming from UI as a value 1,2,3,(inspect HTML for it) that's why we need converter from Object to RoleDTO
        // get Entity convert to RoleDTO and give back  to RoleDTOConverter
        return roleMapper.convertToDto(roleRepository.findById(id).get());

    }
}
