package com.stackroute.employee.service;

import java.util.List;

import com.stackroute.employee.model.Employee;

public interface EmployeeService {
	
	Employee save(Employee emp);

	public Employee delete(int id);

	public List<Employee> findAll();

	Employee findById(int id);

	Employee update(Employee emp);
	
	public List<Employee> findByFirstName(String firstName);
}
