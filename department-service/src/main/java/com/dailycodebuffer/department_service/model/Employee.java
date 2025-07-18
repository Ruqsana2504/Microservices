package com.dailycodebuffer.department_service.model;

//By default, this class is immutable and provides a compact representation of an employee.It will not have setters but have getters
//Introduced in Java17
public record Employee(Long id, Long departmentId, String name, int age, String position) {
}