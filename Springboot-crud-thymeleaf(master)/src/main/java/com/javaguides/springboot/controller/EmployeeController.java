package com.javaguides.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.javaguides.springboot.model.Employee;
import com.javaguides.springboot.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/")
	public String ShowAllEmployee(Model model) {
		
	     model.addAttribute("employee", employeeService.getAllEmployees());	
		
		return "index";
	}
   
	@GetMapping("/good")
	public String AddEmployee(Model model) {
		
		Employee employee = new Employee();
			
		model.addAttribute("employee", employee);
		
		return "new"; 
		
	}
	@PostMapping("/h")
	public String save(Employee employee) {
    
		employeeService.addEmployee(employee);
		
		return "redirect:/";
}
	@GetMapping("/y/{id}")
	public String backToHome(@PathVariable(value="id") long id,Model model) {
		
		model.addAttribute("employee",employeeService.getEmployeeById(id));
		
		return "x";
	}
	
	@GetMapping("/z/{id}")
     public String deleteById(@PathVariable(value="id") long id) {
		
		employeeService.deleteById(id);
		
		return "redirect:/";	
		
	}
	
}