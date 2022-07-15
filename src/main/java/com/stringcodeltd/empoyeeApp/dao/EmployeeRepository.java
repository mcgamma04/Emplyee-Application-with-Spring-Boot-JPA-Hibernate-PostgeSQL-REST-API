package com.stringcodeltd.empoyeeApp.dao;

import com.stringcodeltd.empoyeeApp.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
