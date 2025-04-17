package com.example.demoDBWeb.Repository;

import com.example.demoDBWeb.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher,Long> {
}
