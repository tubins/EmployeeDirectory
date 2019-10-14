package com.tubz.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tubz.springboot.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define field for entity manager
	private EntityManager entityManger;

	// setup constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManger = theEntityManager;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {

		// get the current hibernate session
		Session currentSession = entityManger.unwrap(Session.class);

		// create the query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

		// execute the query and get the result
		List<Employee> employees = theQuery.getResultList();

		// return the result
		return employees;
	}

}
