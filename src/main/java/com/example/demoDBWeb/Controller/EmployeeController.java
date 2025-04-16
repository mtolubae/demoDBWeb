package com.example.demoDBWeb.Controller;

import com.example.demoDBWeb.Model.Department;
import com.example.demoDBWeb.Model.Employee;
import com.example.demoDBWeb.Model.Employee1;
import com.example.demoDBWeb.Model.Student;
import com.example.demoDBWeb.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    EmployeeService empservice;

    public EmployeeController(EmployeeService empservice) {
        this.empservice = empservice;
    }

    public EmployeeService getEmpservice() {
        return empservice;
    }

    public void setEmpservice(EmployeeService empservice) {
        this.empservice = empservice;
    }

    @GetMapping("/employees")
    public List<Employee> listAllEmployees(){
        return empservice.listEmployees();
    }

    @PostMapping("employees/add")
    public void addEmployee(@RequestBody Employee1 e){
        empservice.addEmployee(e);
    }

    @PatchMapping("employees/update")
    public void changeSalary(@RequestParam String name, @RequestParam Integer salary){
        empservice.changeSalary(name,salary);
    }

    @GetMapping("/students")
    public List<Student> listAllStudents(){
        return empservice.listStudents();
    }

    @PostMapping("students/add")
    public void addStudent(@RequestBody Student s){
        empservice.addStudent(s);
    }

    @PostMapping("department/add")
    public void addDepartment(@RequestBody Department d){
        empservice.addDepartment(d);
    }

    @PatchMapping("department/update")
    public void departmentUpdate(@RequestParam Long empid, @RequestParam Long depid){
        empservice.updateDepartment(empid,depid);
    }

//    @PostMapping("department/{depid}/add/{empid}")
//    public void addEmployee2Department(@PathVariable Long empid,
//                                       @PathVariable Long depid){
//        //empservice.addEmployee2Department(empid, depid);
//    }
}
