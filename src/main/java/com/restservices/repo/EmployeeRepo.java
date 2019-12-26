package com.restservices.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.restservices.model.Employee;

@Repository
public class EmployeeRepo {

	List<Employee> myList = new ArrayList<Employee>();

	public void insert(List<Employee> emplList) {
		if (!emplList.isEmpty()) {
			myList = emplList;
		}
	}

	public Employee findEmployee(String name) {
		Employee returnObj = new Employee();
		for(Employee e: myList) {
			if(e.getFirstName().equalsIgnoreCase(name)) {
				returnObj = e;
			}
		}
		return returnObj;
	}
	
	public List<Employee> findAllEmp() {
//		Employee emp1 = new Employee("Aravind", "kumar", "24", "CTS");
//		Employee emp2 = new Employee("Ak", "palani", "24", "Verizon");
//		myList.add(emp1);
//		myList.add(emp2);
		return myList;
	}
	public boolean del(int id) {
		Employee delObj = new Employee();
		for(Employee e: myList) {
			if(e.getId()==id) {
				delObj = e;
			}
		}
		return myList.remove(delObj);
		
	}
}
