package com.dailycodebuffer.department_service.model;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private Long id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Department() {
    }

    public Department(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
