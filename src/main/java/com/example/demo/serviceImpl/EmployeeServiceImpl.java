package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return employeeRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
//		Optional<Employee> employee=employeeRepo.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}
//		else
//		{
//			throw new ResourceNotFoundException("Employee", "Id",id);
//		}
//	}
		
		//Using Lambda Expression
		
		return employeeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id",id));
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		// We to need check whether employee id is Exist in DB or not
		
		Employee existingemployee= employeeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "Id",id));
		
		existingemployee.setFirstname(employee.getFirstname());
		existingemployee.setLastname(employee.getLastname());
		existingemployee.setEmail(employee.getEmail());
		
		//Save existing employee to DB
		
		   return employeeRepo.save(existingemployee);
		
		// return existingemployee;
	}

	@Override
	public void deleteEmployee(long id) {
		
		//Check whether a employee exist in DB or not
		employeeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "Id", id));
		
	 employeeRepo.deleteById(id);
		
	}
}
