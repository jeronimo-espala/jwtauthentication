package com.userservice.service.imp;

import com.userservice.domain.Role;
import com.userservice.domain.User;
import com.userservice.repository.RoleRepository;
import com.userservice.repository.UserRepository;
import com.userservice.service.RoleService;
import com.userservice.service.UserService;
import com.userservice.service.dto.RoleDTO;
import com.userservice.service.dto.UserDTO;
import com.userservice.service.mapper.RoleMapper;
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
public class RoleServiceImp implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public Role saveRole(RoleDTO roleDTO) {
        log.info("Saving new role {} to the database", roleDTO.getName());
        Role role = roleMapper.toEntity(roleDTO);
        return roleRepository.save(role);
    }
}
