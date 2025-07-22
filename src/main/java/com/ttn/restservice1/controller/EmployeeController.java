package com.ttn.restservice1.controller;

import com.ttn.restservice1.entity.Employee;
import com.ttn.restservice1.exception.EmployeeNotFoundException;
import com.ttn.restservice1.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id) throws EmployeeNotFoundException {
        return employeeService.getEmployee(id);
    }

    @PostMapping("/employee")
    public ResponseEntity<Void> createEmployee(@Valid @RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        URI location = UriComponentsBuilder
                .fromPath("/employee/{id}")
                .buildAndExpand(employee.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/employee/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody Employee employee) throws EmployeeNotFoundException {
        employeeService.updateEmployee(id, employee);
    }

}
