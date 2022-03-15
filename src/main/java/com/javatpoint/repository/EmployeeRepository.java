package com.javatpoint.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javatpoint.entity.Student;
@Repository
public interface EmployeeRepository extends CrudRepository<Student, Integer>  {
}