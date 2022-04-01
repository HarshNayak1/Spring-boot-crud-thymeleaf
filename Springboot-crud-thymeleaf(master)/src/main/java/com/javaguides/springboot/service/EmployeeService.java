package com.javaguides.springboot.service;

import java.util.List;

import com.javaguides.springboot.model.Employee;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    void  addEmployee(Employee employee);
    Employee getEmployeeById(long id);
	void deleteById(long id);
}
