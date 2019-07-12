package com.stackroute.employee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.employee.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	void delete(Employee emp);

	List<Employee> findAll();

	Employee findById(int id);

	Employee save(Employee emp);
	
	List<Employee> findByFirstName(String firstName);
	

}
