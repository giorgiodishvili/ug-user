package org.ug.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ug.user.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
