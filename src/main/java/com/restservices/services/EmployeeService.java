package com.restservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restservices.model.Employee;
import com.restservices.repo.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepo repo;
	
	public void insertInitial(List<Employee> myList) {
		repo.insert(myList);
	}
	
	public Employee findEmployee(String name) {
		return repo.findEmployee(name);
	}
	
	public List<Employee> findAllEmployee() {
		return repo.findAllEmp();
	}
	
	public boolean deleteById(int id) {
		return repo.del(id);
	}
}
