package com.restservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restservices.model.Employee;
import com.restservices.repo.EmployeeRepoIntf;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepoIntf repo;
	
	public void insertInitial(List<Employee> myList) {
		repo.insert(myList);
	}
	
	public Employee findEmployee(String name) {
		return repo.findEmployee(name);
	}
	
	public List<Employee> findAllEmployee() {
		return repo.findAllEmp();
	}
	
	public List<Employee> findMatchingNames(String name) {
		return repo.findByName(name);
	}
	
	public boolean deleteById(int id) {
		return repo.del(id);
	}
}
