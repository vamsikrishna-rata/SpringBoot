package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	public EmployeeService employeeService;

	// Build create Employee Rest API
	//http://localhost:8080/employees

	@PostMapping("/employees")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}

	// Build Get All Employee Rest API
	//http://localhost:8080/get/employees
	
	@GetMapping("/get/employees")
	public ResponseEntity<List<Employee>> getAllEmploye() {
		return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.FOUND);
	}
	
	//Build Get Employee ById Rest Api
	//http://localhost:8080/byid/1
	
	  @GetMapping("/byid/{id}")
	public ResponseEntity<Employee> getEmployeebyId(@PathVariable(name="id") long id){
		  return new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.ACCEPTED);
		
	}

	  //Build Update Employee REST API
	 // http://localhost:8080/putmap/1
	  @PutMapping("/putmap/{id}")
	   public ResponseEntity<Employee> updateEmployee(@PathVariable(name="id") long id,@RequestBody Employee employee){
		  
		  return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id), HttpStatus.CREATED);
		   
	   }
	  
	     //Build Delete Employee REST API
		 // http://localhost:8080/delete/1
	  @DeleteMapping("/delete/{id}")
	  public ResponseEntity<String> delteEmployeebyId(@PathVariable long id){
		  
		  employeeService.deleteEmployee(id);
		  
		   return new ResponseEntity<String>("deleted successfully",HttpStatus.NOT_FOUND);
	  }
}
