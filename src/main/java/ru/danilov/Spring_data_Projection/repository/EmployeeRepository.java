package ru.danilov.Spring_data_Projection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.danilov.Spring_data_Projection.model.Employee;
import ru.danilov.Spring_data_Projection.model.EmployeeProjection;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query("SELECT CONCAT(e.firstName, ' ', e.lastName) AS fullName, e.position AS position, e.owner.name AS departmentName FROM Employee e")
    List<EmployeeProjection> findEmployeeProjections();
}
