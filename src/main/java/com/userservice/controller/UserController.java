package com.userservice.controller;

import com.userservice.domain.User;
import com.userservice.service.UserService;
import com.userservice.service.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body( userService.getUsers());
    }

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody UserDTO userDTO) throws URISyntaxException {
        User user = userService.saveUser(userDTO);
        return ResponseEntity.created(new URI(user.getId().toString())).body(userService.saveUser(userDTO));
    }
}
