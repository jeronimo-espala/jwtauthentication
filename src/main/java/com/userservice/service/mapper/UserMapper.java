package com.userservice.service.mapper;

import com.userservice.domain.User;
import com.userservice.service.dto.UserDTO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDTO userDTO);

    @Mapping(target = "roleIds", ignore = true)
    UserDTO toDto(User user);

    @AfterMapping
    default void mappingRolesIds(@MappingTarget UserDTO userDTO, User user) {
        user.getRoles().forEach(role -> userDTO.getRoleIds().add(role.getId()));
    }
}
