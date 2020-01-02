package com.restservices.repo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.restservices.model.Employee;

@Repository
public class EmployeeRepo implements EmployeeRepoIntf {
	@Autowired
	private SessionFactory sessionFactory;

	List<Employee> myList = new ArrayList<Employee>();

	@Override
	public void insert(List<Employee> emplList) {
		 Session session = sessionFactory.getCurrentSession();
	     for (Employee employee : emplList) {
	    	 session.save(employee);
		}   
		 
	}

	@Override
	public Employee findEmployee(String name) {
		Employee returnObj = new Employee();
		for (Employee e : myList) {
			if (e.getFirstName().equalsIgnoreCase(name)) {
				returnObj = e;
			}
		}
		return returnObj;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Employee> findAllEmp() {
		Session ses = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Employee> list = ses.createCriteria(Employee.class).list();
		return list;
	}

	@Override
	public List<Employee> findByName(String name) {
		Session ses = sessionFactory.getCurrentSession();
		Criteria crit = ses.createCriteria(Employee.class);
		crit.add(Restrictions.eq("firstName", name));
		List<Employee> results = crit.list();
		return results;
	}

	@Override
	public boolean del(int id) {
		Employee delObj = new Employee();
		for (Employee e : myList) {
			if (e.getId() == id) {
				delObj = e;
			}
		}
		return myList.remove(delObj);

	}
}
