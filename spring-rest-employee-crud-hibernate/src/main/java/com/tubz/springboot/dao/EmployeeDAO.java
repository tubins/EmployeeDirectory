package com.tubz.springboot.dao;

import java.util.List;

import com.tubz.springboot.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();

}
