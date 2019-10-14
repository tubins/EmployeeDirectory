package com.tubz.springboot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tubz.springboot.entity.Employee;
import com.tubz.springboot.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	// Inject EmployeeDAO
	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	// Expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	// Add mapping for GET /employee/{employeeId}
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		if (theEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		return theEmployee;
	}

	// add mapping for POST /employees - add a new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {

		// Just in case user send an id in the JSON, we need to force to add new item
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
	}
}
