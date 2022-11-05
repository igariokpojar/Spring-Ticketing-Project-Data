package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;
import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.UserRepository;
import com.cydeo.service.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;

        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> listAllUsers() {
    // go to Db bring all users and convert it
        // to bring info from DB we need repository so need DI

      List<User> userList  =  userRepository.findAll(Sort.by("firstName"));
        // convert to DTO and returned
        return userList.stream().map(userMapper::convertToDto).collect(Collectors.toList());

    }

    @Override
    public UserDTO findByUserName(String username) {

       User user = userRepository.findByUserName(username);
        return userMapper.convertToDto(user);
    }

    @Override // Save method is accepting Entity, but you are giving DTO coming from UI so need converter by using mapper
    public void save(UserDTO user) {
        userRepository.save(userMapper.convertToEntity(user)); // for using mapper you need DI

    }

    @Override
    public void deleteByUserName(String username) {
        userRepository.deleteByUserName(username); // go to UserRepository and Implement the method
    }

    @Override
    public UserDTO update(UserDTO user) { // this user is coming from UI
        // To avoid duplicate id in DB use the steps
        // Find the current User bc im going to use the ID of this User
        // this is not updated one
        User user1 = userRepository.findByUserName(user.getUserName()); // this has the id
        // map update the UserDTO to entity object
        User convertedUser = userMapper.convertToEntity(user); // convert Entity to DTO
        // set id to the converted object
        convertedUser.setId(user1.getId());
        // save updated user in the DB
        userRepository.save(convertedUser);
        return findByUserName(user.getUserName());

    }

    @Override
    public void delete(String username) {
        // go to DB and get the User with username
        User user = userRepository.findByUserName(username);
        // change isdeleted field to true
        user.setIsDeleted(true);
        // save the object in the DB
        userRepository.save(user);

    }

    @Override
    public List<UserDTO> listAllByRole(String role) {

      List<User> users = userRepository.findByRoleDescriptionIgnoreCase(role);

        return users.stream().map(userMapper::convertToDto).collect(Collectors.toList());
    }


}
