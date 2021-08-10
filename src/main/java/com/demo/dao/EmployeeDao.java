package com.demo.dao;

import java.util.List;

import com.demo.model.Employee;

public interface EmployeeDao {

	Long save(Employee employee);

	Employee findById(Long id);

	void update(Employee employee);
	
	List<Employee> findAll();

}
