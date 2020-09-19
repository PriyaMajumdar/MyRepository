package com.microservice1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice1.model.Employee;

@Service
public interface Service1 {
	public void saveEmployee(Employee emp);
	public List<Employee>  getEmployeeList();
	public Employee getEmployeeById(int id);
	public void updateEmployee(Employee emp);
	public void deleteEmployee(int id );

}
