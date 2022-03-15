package com.javatpoint.controller;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

//import com.javatpoint.entity.Employee;
import com.javatpoint.entity.Student;
import com.javatpoint.springbooth2databaseEmployeeJUNIT.SpringBootH2DatabaseEmployeeJunitApplication;
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringBootH2DatabaseEmployeeJunitApplication.class)
@AutoConfigureMockMvc
public class EmployeeControllerTest {
   @Autowired
   private MockMvc mvc;
   @MockBean
   private EmployeeController employeeController;
   @Test
   public void testGetAllEmployees() throws Exception {
      Student employee = getEmployee();
      List<Student> employees = new ArrayList<>();
      employees.add(employee);
      given(employeeController.getAllEmployees()).willReturn(employees);
      mvc.perform(get("/emp/employees/").contentType(APPLICATION_JSON)).andExpect(status().isOk())
         .andExpect(jsonPath("$[0].name", is(employee.getName())));
   }
   @Test
   public void testGetEmployee() throws Exception {
      Student employee = getEmployee();
      given(employeeController.getEmployee(1)).willReturn(employee);
      mvc.perform(get("/emp/employee/" + employee.getId()).contentType(APPLICATION_JSON)).andExpect(status().isOk())
         .andExpect(jsonPath("name", is(employee.getName())));
   }
   @Test
   public void testDeleteEmployee() throws Exception {
      Student employee = getEmployee();
      doNothing().when(employeeController).deleteEmployee(1);
      mvc.perform(delete("/emp/employee/" + employee.getId()).contentType(APPLICATION_JSON))
         .andExpect(status().isOk()).andReturn();
   }
   @Test
   public void testAddEmployee() throws Exception {
      Student employee = getEmployee();
      doNothing().when(employeeController).addEmployee(employee);
      mvc.perform(post("/emp/employee/").content(asJson(employee)).contentType(APPLICATION_JSON))
         .andExpect(status().isOk()).andReturn();
   }
   @Test
   public void testUpdateEmployee() throws Exception {
      Student employee = getEmployee();
      doNothing().when(employeeController).updateEmployee(employee);
      mvc.perform(put("/emp/employee/").content(asJson(employee)).contentType(APPLICATION_JSON))
         .andExpect(status().isOk()).andReturn();
   }
   private Student getEmployee() {
      Student employee = new Student();
      employee.setId(1);
      employee.setName("Mahesh");
      employee.setAge(30);
      employee.setEmail("mahesh@test.com");
      return employee;
   }
   private static String asJson(final Object obj) {
      try {
         return new ObjectMapper().writeValueAsString(obj);
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }
}