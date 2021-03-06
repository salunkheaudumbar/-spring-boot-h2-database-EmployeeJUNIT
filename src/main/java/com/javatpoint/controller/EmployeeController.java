package com.javatpoint.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.entity.Student;
import com.javatpoint.service.EmployeeService;
@RestController
@RequestMapping(path = "/emp")
public class EmployeeController {
   @Autowired
   EmployeeService employeeService;
   @GetMapping("/employees")
   public List<Student> getAllEmployees(){
	   return employeeService.getAllEmployees();
   }
   @GetMapping("/employee/{id}")
   public Student getEmployee(@PathVariable("id") int id) {
	   return employeeService.getEmployeeById(id);
   }
   @DeleteMapping("/employee/{id}")
   public void deleteEmployee(@PathVariable("id") int id) {
	   employeeService.deleteEmployeeById(id);
   }
   @PostMapping("/employee")
   public void addEmployee(@RequestBody Student employee) {
	   employeeService.saveOrUpdate(employee);
   }
   @PutMapping("/employee")
   public void updateEmployee(@RequestBody Student employee) {
	   employeeService.saveOrUpdate(employee);
   }	
}