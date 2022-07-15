package com.stringcodeltd.empoyeeApp.controller;

import com.stringcodeltd.empoyeeApp.dao.EmployeeRepository;
import com.stringcodeltd.empoyeeApp.exception.ResourceNotFoundException;
import com.stringcodeltd.empoyeeApp.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/")
public class EmployeeController {
    @Autowired
    private EmployeeRepository repository;

    @GetMapping("employees")
    public List<Employee> getAllEmployee(){
        return repository.findAll();
    }

    //save emplyee
    @PostMapping("employees")
    public String addEmployee(@RequestBody Employee employee){
        repository.save(employee);
        return employee.getFirstname().toUpperCase() +" "+employee.getLastname()+" saved successfully";
    }
//get an employee
@GetMapping("employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value= "id") Long employeedId) throws ResourceNotFoundException {
     Employee employee =  repository.findById(employeedId)
             .orElseThrow(()-> new ResourceNotFoundException("Sorry employee with "+employeedId+ " is not found"));
            return ResponseEntity.ok().body(employee);
    }

 //update employee
 @PutMapping("employee/{id}")
 public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id")Long employeeId, @RequestBody Employee emp) throws ResourceNotFoundException {
        Employee employee = repository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found"));
        employee.setFirstname(emp.getFirstname());
        employee.setLastname(emp.getLastname());
        employee.setSalary(emp.getSalary());
        employee.setEmail(emp.getEmail());
        employee.setGender(emp.getGender());
        employee.setDepartment(emp.getDepartment());
        return  ResponseEntity.ok(repository.save(employee));
 }
 //delete
@DeleteMapping("employee/{id}")
     public Map<String, Boolean> deleteEmployee(@PathVariable(value="id")Long id) throws ResourceNotFoundException {
        Employee employee =  repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee with "+id+" not exists"));
        repository.deleteById(id);
        Map<String,Boolean> feedback =  new HashMap<>();
        feedback.put("Employedd "+id +" deleted ",Boolean.TRUE);
        return  feedback;
     }





}
