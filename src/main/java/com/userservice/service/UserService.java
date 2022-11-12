package com.userservice.service;

import com.userservice.domain.Role;
import com.userservice.domain.User;
import com.userservice.service.dto.UserDTO;

import java.util.List;

public interface UserService {
    User saveUser(UserDTO userDTO);
    void addRoleToUser(String username, String roleName);
    User getUsers(String username);
    List<User> getUsers();
}
