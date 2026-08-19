package com.fernando84.department_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fernando84.department_service.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, String> {
}
