package org.ug.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ug.user.dto.DepartmentDTO;
import org.ug.user.entity.Department;
import org.ug.user.mapper.DepartmentMapper;
import org.ug.user.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(departmentMapper::toDepartmentDTO)
                .collect(Collectors.toList());
    }

    public DepartmentDTO getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .map(departmentMapper::toDepartmentDTO)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        Department department = departmentMapper.toDepartment(departmentDTO);
        Department savedDepartment = departmentRepository.save(department);
        return departmentMapper.toDepartmentDTO(savedDepartment);
    }

    public DepartmentDTO updateDepartment(Long id, DepartmentDTO departmentDTO) {
        Department existingDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        departmentMapper.toDepartment(departmentDTO, existingDepartment);// Update fields
        Department updatedDepartment = departmentRepository.save(existingDepartment);
        return departmentMapper.toDepartmentDTO(updatedDepartment);
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
