package com.cg;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	private EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	public List<Employee> getEmployees(){
		return employeeRepository.findAll();
	}
}
