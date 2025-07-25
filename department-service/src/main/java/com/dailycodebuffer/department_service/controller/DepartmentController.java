package com.dailycodebuffer.department_service.controller;

import com.dailycodebuffer.department_service.client.EmployeeClient;
import com.dailycodebuffer.department_service.model.Department;
import com.dailycodebuffer.department_service.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeClient employeeClient;

    @PostMapping
    public Department add(@RequestBody Department department) {
        LOGGER.info("Department add: {}", department);
        return departmentRepository.addDepartments(department);
    }

    @GetMapping
    public List<Department> findAll() {
        LOGGER.info("Department findAll");
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id) {
        LOGGER.info("Department find: id = {}", id);
        return departmentRepository.findById(id);
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees() {
        LOGGER.info("Department find");
        List<Department> departments = departmentRepository.findAll();
        departments.forEach((department -> department.setEmployees(employeeClient.findByDepartmentId(department.getId()))));
        return departments;
    }

}
