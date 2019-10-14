package com.tubz.springboot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tubz.springboot.dao.EmployeeDAO;
import com.tubz.springboot.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	// Inject EmployeeDAO
	private EmployeeDAO employeeDAO;

	@Autowired
	public EmployeeController(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}

	// Expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}
}
