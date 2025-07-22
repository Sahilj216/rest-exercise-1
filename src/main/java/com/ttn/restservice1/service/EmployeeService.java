package com.ttn.restservice1.service;

import com.ttn.restservice1.entity.Employee;
import com.ttn.restservice1.exception.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void deleteEmployee(int id);
    Employee getEmployee(int id) throws EmployeeNotFoundException;
    void saveEmployee(Employee employee);
    void updateEmployee(int id,Employee employee) throws EmployeeNotFoundException;
}
