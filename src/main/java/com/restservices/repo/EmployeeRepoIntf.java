package com.restservices.repo;

import java.util.List;

import com.restservices.model.Employee;

public interface EmployeeRepoIntf {

	void insert(List<Employee> emplList);

	Employee findEmployee(String name);

	List<Employee> findAllEmp();

	List<Employee> findByName(String name);

	boolean del(int id);

}