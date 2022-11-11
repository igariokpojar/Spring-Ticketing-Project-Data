package com.cydeo.service;

import com.cydeo.dto.RoleDTO;

import java.util.List;

public interface RoleService {

    List<RoleDTO> listAllRoles(); // bring all(List of Roles) to UI -> we are in Service So we need DTO
    RoleDTO findById(Long id);
}
