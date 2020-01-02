package com.restservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restservices.model.Employee;
import com.restservices.services.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@PostMapping(path="/init")
	public void insertInitial(@RequestBody List<Employee> employeeList) {
		employeeList.forEach(System.out::println);
		 service.insertInitial(employeeList);
	}
	
	@GetMapping(path="/find")
	public List<Employee> findEmployee(@RequestParam(name="name", required=true) String name) {
		return service.findMatchingNames(name);
	}
	
	
	@GetMapping(path="/getAll")
	public List<Employee> findAllEmployee() {
		System.out.println("getting all");
		return service.findAllEmployee();
	}
	
	@DeleteMapping(path="del/{id}")
	public boolean deleteById(@PathVariable int id) {
		System.out.println(id);
		return service.deleteById(id);
	}
	
}
