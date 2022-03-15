package com.javatpoint.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatpoint.entity.Student;
import com.javatpoint.repository.EmployeeRepository;
@Service
public class EmployeeService {
   @Autowired
   EmployeeRepository repository;
   public Student getEmployeeById(int id) {
	   return repository.findById(id).get();
   }
   public List<Student> getAllEmployees(){
	   List<Student> employees = new ArrayList<Student>();
	   repository.findAll().forEach(employee -> employees.add(employee));
	   return employees;
   }
   public void saveOrUpdate(Student employee) {
	   repository.save(employee);
   }
   public void deleteEmployeeById(int id) {
	   repository.deleteById(id);
   }
}