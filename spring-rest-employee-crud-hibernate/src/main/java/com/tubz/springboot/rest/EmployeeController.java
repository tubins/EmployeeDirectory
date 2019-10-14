package com.tubz.springboot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tubz.springboot.dao.EmployeeDAO;
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
}
