package com.userservice.service.imp;

import com.userservice.domain.Role;
import com.userservice.domain.User;
import com.userservice.repository.RoleRepository;
import com.userservice.repository.UserRepository;
import com.userservice.service.UserService;
import com.userservice.service.dto.UserDTO;
import com.userservice.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    @Override
    public User saveUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        log.info("Saving new user {} to the database", user.getName());
        return userRepository.save(user);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} toe user {}", roleName, username);
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUsers(String username) {
        log.info("Fetching user {}", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fething all users");
        return userRepository.findAll();
    }
}
