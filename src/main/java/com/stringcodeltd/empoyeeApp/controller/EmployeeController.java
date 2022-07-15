package com.stringcodeltd.empoyeeApp.controller;

import com.stringcodeltd.empoyeeApp.dao.EmployeeRepository;
import com.stringcodeltd.empoyeeApp.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class EmployeeController {
    @Autowired
    private EmployeeRepository repository;

    @GetMapping("employees")
    public List<Employee> getAllEmployee(){
        return repository.findAll();
    }



}
