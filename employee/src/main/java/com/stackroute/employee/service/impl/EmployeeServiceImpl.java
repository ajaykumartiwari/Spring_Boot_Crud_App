package com.stackroute.employee.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.employee.model.Employee;
import com.stackroute.employee.repository.EmployeeRepository;
import com.stackroute.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;


	@Override
	public Employee delete(int id) {
		Employee employee = findById(id);
		if (employee != null) {
			empRepository.delete(employee);
		}
		return employee;
	}

	@Override
	public List<Employee> findAll() {
		return empRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		return empRepository.findById(id);
	}

	@Override
	public Employee update(Employee employee) {
		Employee updateemployee = empRepository.save(employee);
		
		return updateemployee;
	}

	@Override
	public Employee save(Employee emp) {
		return empRepository.save(emp);
	}

	@Override
	public List<Employee> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return empRepository.findByFirstName(firstName);
	}
}
