package com.userservice.service.mapper;

import com.userservice.domain.Role;
import com.userservice.domain.User;
import com.userservice.repository.RoleRepository;
import com.userservice.service.dto.UserDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    private RoleRepository roleRepository;

    User toEntity(UserDTO userDTO);

    @Mapping(target = "roleIds", ignore = true)
    UserDTO toDto(User user);

    @AfterMapping
    default void mappingRolesIdsToDTO(@MappingTarget UserDTO userDTO, User user) {
        user.getRoles().forEach(role -> userDTO.getRoleIds().add(role.getId()));
    }

    @AfterMapping
    default void mappingRolesIdsToEntity(@MappingTarget User user, UserDTO userDTO) {
        List<Role> roles = roleRepository.findAllById(userDTO.getRoleIds());
        user.setRoles(roles);
    }
}
