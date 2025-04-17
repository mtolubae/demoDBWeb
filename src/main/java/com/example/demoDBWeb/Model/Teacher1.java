package com.example.demoDBWeb.Model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Teacher1 {
    String name;
    ArrayList<Long> department_idlist;

    public Teacher1() {
        department_idlist = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Long> getDepartment_idlist() {
        return department_idlist;
    }

    public void setDepartment_idlist(ArrayList<Long> department_idlist) {
        this.department_idlist = department_idlist;
    }
}
