package com.javaguides.springboot.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaguides.springboot.model.Employee;
import com.javaguides.springboot.repository.EmployeeRepository;
import com.javaguides.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl  implements EmployeeService{
     
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		
	  List<Employee> emplist= employeeRepository.findAll();	 
		
		return emplist;
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
           employeeRepository.save(employee);
           
	}

	@Override
	public Employee getEmployeeById(long id) {
		
		Employee employee;
		
		Optional<Employee> optional = employeeRepository.findById(id);
		
		if(optional.isPresent()) {
			
		employee=optional.get(); 
			
		}else {
             
			throw new RuntimeException("this id is not found");
			
		}
		
		return employee;
	}

	@Override
	public void deleteById(long id) {
		
		employeeRepository.deleteById(id);
		
	}

	

}
