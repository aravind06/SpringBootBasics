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
		repo.saveAll(myList);
	}
	
//	public Employee findEmployee(String name) {
//		return repo.findAll();
//	}
	
	public List<Employee> findAllEmployee() {
		return repo.findAll();
	}
	
	public boolean deleteById(Integer id) {
		repo.deleteById(id);
		return true;
	}
}
