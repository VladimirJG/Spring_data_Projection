package ru.danilov.Spring_data_Projection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import ru.danilov.Spring_data_Projection.controller.EmployeeController;
import ru.danilov.Spring_data_Projection.model.Department;
import ru.danilov.Spring_data_Projection.model.Employee;
import ru.danilov.Spring_data_Projection.service.EmployeeService;

@SpringBootTest
class SpringDataProjectionApplicationTests {
    @InjectMocks
    private EmployeeController employeeController;
    @Mock
    private EmployeeService employeeService;


    @Test
    void testGetEmployeeDepartmentName() {
        int id = 1;
        String departmentName = "IT Department";
        Department department = new Department(2, departmentName);
        Employee employee1 = new Employee(id, "Test", "LastTest", "TestPosition", 100, department);

        Mockito.when(employeeService.getEmployeeDepartmentName(id)).thenReturn(employee1.getOwner().getName());

        String result = employeeController.getEmployeeDepartmentName(id);

        Assertions.assertEquals(departmentName, result);
    }

    @Test
    void testGetEmployeeFullName() {
        int id = 1;
        String fullName = "John Doe";

        Mockito.when(employeeService.getEmployeeFullName(id)).thenReturn(fullName);

        String result = employeeController.getEmployeeFullName(id);

        Assertions.assertEquals(fullName, result);
    }
}