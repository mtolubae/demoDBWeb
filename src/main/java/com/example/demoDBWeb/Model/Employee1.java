package com.example.demoDBWeb.Model;

import org.springframework.stereotype.Component;

@Component
public class Employee1 {
    private String name;
    private Integer salary;
    private String role;
    private Long department_id;

    public Employee1(String name, Integer salary, String role, Long department_id) {
        this.name = name;
        this.salary = salary;
        this.role = role;
        this.department_id = department_id;
    }

    public Employee1() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", role='" + role + '\'' +
                ", department_id=" + department_id +
                '}';
    }
}
