package com.restservices.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restservices.model.Employee;

public interface EmployeeRepoIntf  extends JpaRepository<Employee, Integer>{

}
