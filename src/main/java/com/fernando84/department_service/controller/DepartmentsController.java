package com.fernando84.department_service.controller;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fernando84.department_service.model.Department;
import com.fernando84.department_service.dto.DepartmentDTO;
import com.fernando84.department_service.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentsController {

    private DepartmentService departmentService;

    public DepartmentsController(DepartmentService ds) {
        this.departmentService = ds;
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public List<DepartmentDTO> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public DepartmentDTO getDepartmentById(@PathVariable String id) {
        return departmentService.getDepartmentById(id);
    }

    @GetMapping("/admin-test")
    @PreAuthorize("hasRole('ADMIN')")
    public void adminTest() {
        System.out.println("This is a message only for ADMINS!");
    }

}
