package ru.danilov.Spring_data_Projection.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.danilov.Spring_data_Projection.model.Employee;
import ru.danilov.Spring_data_Projection.model.EmployeeProjection;
import ru.danilov.Spring_data_Projection.repository.EmployeeRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public String getEmployeeDepartmentName(int id) {
        return employeeRepository.findEmployeeProjections().get(id).getDepartmentName();
    }

    public String getEmployeeFullName(int id) {
        return employeeRepository.findEmployeeProjections().get(id).getFullName();
    }

    public String getEmployeePosition(int id) {
        return employeeRepository.findEmployeeProjections().get(id).getPosition();
    }

    public List<EmployeeProjection> getAllEmployeeProjection() {
        return employeeRepository.findEmployeeProjections();
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Transactional
    public void update(int id, Employee upEmployee) {
        upEmployee.setId(id);
        employeeRepository.save(upEmployee);
    }

    @Transactional
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

}
