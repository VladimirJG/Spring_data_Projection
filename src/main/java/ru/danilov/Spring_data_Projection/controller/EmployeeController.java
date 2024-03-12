package ru.danilov.Spring_data_Projection.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.danilov.Spring_data_Projection.model.Employee;
import ru.danilov.Spring_data_Projection.model.EmployeeProjection;
import ru.danilov.Spring_data_Projection.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/dep/{id}")
    public String getEmployeeDepartmentName(@PathVariable("id") int id) {
        return employeeService.getEmployeeDepartmentName(id);
    }

    @GetMapping("/name/{id}")
    public String getEmployeeFullName(@PathVariable("id") int id) {
        return employeeService.getEmployeeFullName(id);
    }

    @GetMapping("/pos/{id}")
    public String getEmployeePosition(@PathVariable("id") int id) {
        return employeeService.getEmployeePosition(id);
    }

    @GetMapping("/EP")
    public List<EmployeeProjection> getAllEmployeeProjection() {
        return employeeService.getAllEmployeeProjection();
    }

    @GetMapping()
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping()
    public void save(@RequestBody @Valid Employee employee) {
        employeeService.save(employee);
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody @Valid Employee upEmployee) {
        employeeService.update(id, upEmployee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        employeeService.delete(id);
    }
}