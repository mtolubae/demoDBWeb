package com.example.demoDBWeb.Service;

import com.example.demoDBWeb.Model.*;
import com.example.demoDBWeb.Repository.DepartmentRepo;
import com.example.demoDBWeb.Repository.EmployeeRepo;
import com.example.demoDBWeb.Repository.StudentRepo;
import com.example.demoDBWeb.Repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepo emprepo;
    private StudentRepo studrepo;
    private DepartmentRepo deprepo;
    private TeacherRepo teacherRepo;

    public EmployeeService(EmployeeRepo emprepo, StudentRepo studrepo,
                           DepartmentRepo deprepo, TeacherRepo teacherRepo) {
        this.emprepo = emprepo;
        this.studrepo = studrepo;
        this.deprepo = deprepo;
        this.teacherRepo = teacherRepo;
    }

    public EmployeeRepo getEmprepo() {
        return emprepo;
    }

    @Autowired
    public void setEmprepo(EmployeeRepo emprepo) {
        this.emprepo = emprepo;
    }

    public List<Employee> listEmployees(){
        return emprepo.findAll();
    }

    public void addEmployee(Employee1 e){
        System.out.println(e.toString());
        Department d = deprepo.findById(e.getDepartment_id()).get();
        Employee ee = new Employee();
        ee.setDepartment(d);
        ee.setName(e.getName());
        ee.setSalary(e.getSalary());
        ee.setRole(e.getRole());
        emprepo.save(ee);
    }

    public void addTeacher(Teacher1 t1){
        Teacher t = new Teacher();
        t.setName(t1.getName());
        Department d;
        for(int i=0; i<t1.getDepartment_idlist().size();i++){
            d = deprepo.findById(t1.getDepartment_idlist().get(i)).get();
            t.getDepartmentList().add(d);
        }
        teacherRepo.save(t);
    }

    public List<Student> listStudents(){
        return studrepo.findAll();
    }

    public void addStudent(Student s){
        studrepo.save(s);
    }

    public void changeSalary(String name, Integer salary){
        /*List<Employee> employeeList = emprepo.findAll();
        for(Employee e: employeeList){
            if(e.getName().equals(name)){
                e.setSalary(salary);
                emprepo.save(e);
                break;
            }
        }*/

        List<Employee> employeeList1 = emprepo.findByName(name);
        if(employeeList1 != null){
            for(Employee e: employeeList1){
                if(e.getName().equals(name)){
                    e.setSalary(salary);
                    emprepo.save(e);
                    break;
                }
            }
        }
    }

public void addDepartment(Department d){
        deprepo.save(d);
}

public void updateDepartment(Long empid, Long depid){
        Employee e = emprepo.findById(empid).get();
        Department d = deprepo.findById(depid).get();
        e.setDepartment(d);
        emprepo.save(e);
}

}
