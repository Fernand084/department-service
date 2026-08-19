package com.fernando84.department_service.exception;

public class DepartmentNotFoundException extends RuntimeException {
    public DepartmentNotFoundException(String id) {
        super("Department Not Found, Department_id: " + id);
    }
}
