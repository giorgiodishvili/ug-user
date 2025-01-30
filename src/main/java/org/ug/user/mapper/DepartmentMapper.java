package org.ug.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.ug.user.dto.DepartmentDTO;
import org.ug.user.entity.Department;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    DepartmentDTO toDepartmentDTO(Department department);

    Department toDepartment(DepartmentDTO departmentDTO);

    @Mapping(target = "id", ignore = true)
    void toDepartment(DepartmentDTO departmentDTO, @MappingTarget Department department);


}
