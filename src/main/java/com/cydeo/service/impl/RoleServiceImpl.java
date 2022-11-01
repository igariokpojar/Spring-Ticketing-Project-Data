package com.cydeo.service.impl;

import com.cydeo.dto.RoleDTO;
import com.cydeo.entity.Role;
import com.cydeo.repository.RoleRepository;
import com.cydeo.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository repository, RoleRepository roleRepository) {
        this.roleRepository = roleRepository;

    }

    @Override
    public List<Role> listAllRoles() {
    // Controller called me and requesting all RoleDto, so it can show in the drop-down in the UI
        // I need to make a call to Db and get all the roles from table
        // go to repository and find a service which gives me rhe roles fromDB
        // how I will cal any service here? = DI(dep inj)

       List<Role>roleList = roleRepository.findAll();

       return roleList;
    }

    @Override
    public RoleDTO findById(Long id) {
        return null;
    }
}
