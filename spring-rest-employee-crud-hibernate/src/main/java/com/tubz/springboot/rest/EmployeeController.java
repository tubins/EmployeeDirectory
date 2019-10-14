package com.tubz.springboot.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	// Inject EmployeeDAO
	// Expose "/employees" and return list of employees
}
