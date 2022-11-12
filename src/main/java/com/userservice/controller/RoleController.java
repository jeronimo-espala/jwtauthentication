package com.userservice.controller;

import com.userservice.domain.Role;
import com.userservice.service.RoleService;
import com.userservice.service.dto.RoleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/role")
    public ResponseEntity<Role> saveUser(@RequestBody RoleDTO roleDTO) throws URISyntaxException {
        Role role = roleService.saveRole(roleDTO);
        return ResponseEntity.created(new URI(role.getId().toString())).body(role);
    }
}
