package com.stringcodeltd.empoyeeApp.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employeetbl")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    @NotNull
    private String firstname;
    @Column(name = "last_name")
    @NotNull
    private String lastname;

    @Column(name = "salary")
    @NotNull
    private double salary;
    @Column(name = "email")
    @NotNull
    private String email;
    @Column(name = "gender")
    @NotNull
    private String gender;
    @Column(name = "department")
    @NotNull
    private String department;

    public Employee() {}

    public Employee(long id, String firstname, String lastname, double salary, String email, String gender, String department) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = salary;
        this.email = email;
        this.gender = gender;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
