package com.fernando84.department_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fernando84.department_service.dto.DepartmentDTO;
import com.fernando84.department_service.exception.DepartmentNotFoundException;
import com.fernando84.department_service.repository.DepartmentRepository;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository dr) {
        this.departmentRepository = dr;
    }

    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(d -> new DepartmentDTO(d.getId(), d.getDeptName()))
                .toList();
    }

    public DepartmentDTO getDepartmentById(String id) {
        return departmentRepository.findById(id)
                .map(d -> new DepartmentDTO(d.getId(), d.getDeptName()))
                .orElseThrow(() -> new DepartmentNotFoundException(id));
    }

}
