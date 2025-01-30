package org.ug.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.ug.user.dto.UserDTO;
import org.ug.user.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "department.id", target = "departmentId")
    UserDTO toUserDTO(User user);

    @Mapping(source = "departmentId", target = "department.id")
    User toUser(UserDTO userDTO);

    @Mapping(target = "id", ignore = true)
    void toUser(UserDTO userDTO, @MappingTarget User user);
}
