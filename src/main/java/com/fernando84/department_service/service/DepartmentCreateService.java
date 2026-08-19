package com.fernando84.department_service.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fernando84.department_service.dto.DepartmentCreateRequest;
import com.fernando84.department_service.model.Department;
import com.fernando84.department_service.repository.DepartmentRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentCreateService {
    private final DepartmentRepository departmentRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private String nextDepartmentId() {
        Number next = (Number) entityManager
                .createNativeQuery("SELECT nextval('department_id_seq')")
                .getSingleResult();
        return String.format("d%03d", next.intValue());
    }

    @Transactional
    public Department createDepartment(DepartmentCreateRequest request) {
        Department department = new Department();
        String id = nextDepartmentId();
        department.setId(id);
        department.setDeptName(request.deptName());
        departmentRepository.save(department);
        return department;
    }
}
