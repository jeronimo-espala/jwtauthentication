package com.userservice.service.mapper;

import com.userservice.domain.User;
import com.userservice.service.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDTO userDTO);
}
