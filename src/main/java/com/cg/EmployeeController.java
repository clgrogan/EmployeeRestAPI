package com.cg;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> employees = employeeService.getEmployees();
		return ResponseEntity.ok(employees);
	}
	
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable("id") long id){
		return employeeService.getEmployee(id);
	}
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		return ResponseEntity.ok(employeeService.createEmployee(employee));
	}
	
	@PutMapping
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		return ResponseEntity.ok(employeeService.updateEmployee(employee));
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable("id") long id) {
		employeeService.deleteEmployee(id);
	}

}
