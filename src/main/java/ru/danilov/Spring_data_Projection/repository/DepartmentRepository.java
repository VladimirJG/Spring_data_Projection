package ru.danilov.Spring_data_Projection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.danilov.Spring_data_Projection.model.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
