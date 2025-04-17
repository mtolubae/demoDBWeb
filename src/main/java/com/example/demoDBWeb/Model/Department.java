package com.example.demoDBWeb.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "department")
    private List<Employee> employeeList;

    @ManyToMany(mappedBy = "departmentList",cascade = CascadeType.ALL)
    private List<Teacher> teacherList;

    public Department(String name) {
        this.name = name;
        employeeList = new ArrayList<>();
        teacherList = new ArrayList<>();
    }

    public Department(){
        employeeList = new ArrayList<>();
        teacherList = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
