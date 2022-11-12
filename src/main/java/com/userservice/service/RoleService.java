package com.userservice.service;

import com.userservice.domain.Role;
import com.userservice.service.dto.RoleDTO;

public interface RoleService {
    Role saveRole(RoleDTO roleDTO);
}
