package com.example.demoDBWeb.Repository;

import com.example.demoDBWeb.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department,Long> {
}
