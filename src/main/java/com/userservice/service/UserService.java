package com.userservice.service;

import com.userservice.domain.Role;
import com.userservice.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUsers(String username);
    List<User> getUsers();
}
