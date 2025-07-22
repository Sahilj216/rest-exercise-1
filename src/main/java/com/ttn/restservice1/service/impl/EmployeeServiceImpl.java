package com.ttn.restservice1.service.impl;

import com.ttn.restservice1.entity.Employee;
import com.ttn.restservice1.exception.EmployeeNotFoundException;
import com.ttn.restservice1.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final List<Employee> employees;

    static {
        employees = new ArrayList<>(
                List.of(
                        new Employee(20, 1, "Sahil"),
                        new Employee(24, 2, "Ramu"),
                        new Employee(25, 3, "Shyam")
                )
        );
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public void deleteEmployee(int id) {
        employees.removeIf(employee -> employee.id() == id);
    }

    @Override
    public Employee getEmployee(int id) throws EmployeeNotFoundException {
        for (Employee employee : employees) {
            if (employee.id() == id) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    @Override
    public void saveEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void updateEmployee(int id, Employee employee) throws EmployeeNotFoundException {
        int idx = -1;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).id() == id) {
                idx = i;
            }
        }
        if (idx == -1) {
            throw new EmployeeNotFoundException("Employee not found");
        }
        employees.set(idx, employee);
    }
}
