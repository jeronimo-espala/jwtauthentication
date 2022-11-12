package com.userservice.service.mapper;

import com.userservice.domain.Role;
import com.userservice.service.dto.RoleDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDTO toDto(Role role);
    Role toEntity(RoleDTO roleDTO);
}
