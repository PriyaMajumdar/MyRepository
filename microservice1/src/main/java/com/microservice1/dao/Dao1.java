package com.microservice1.dao;


import java.util.List;

import org.springframework.stereotype.Repository;


import com.microservice1.model.Employee;

@Repository
public interface Dao1 {
	public void saveEmployee(Employee e);
	public List<Employee>  getEmployeeList();
	public Employee getEmployeeById(int id);
	public void updateEmployee(Employee emp);
	public void deleteEmployee(int id );

}
