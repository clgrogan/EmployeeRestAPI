package com.cg;

import java.util.List;
import java.util.Optional;

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

	public Employee getEmployee(long id) {
		Optional<Employee> empOptional = employeeRepository.findById(id);
		if(!empOptional.isPresent()) {
			throw new EmployeeNotFoundException("Employee with id " + id + " not found");
		}
		return empOptional.get();
	}
	
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public void deleteEmployee(long id) {
		employeeRepository.deleteById(id);
	}
}
