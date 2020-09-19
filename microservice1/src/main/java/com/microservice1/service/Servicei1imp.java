package com.microservice1.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microservice1.EmailFormat;
import com.microservice1.IdNotFound;
import com.microservice1.NullFeild;
import com.microservice1.PasswordNotMatch;
import com.microservice1.dao.Dao1;
import com.microservice1.model.Employee;

@Component
public class Servicei1imp implements Service1 {
	@Autowired
	Dao1 dao;

	@Override
	@Transactional
	public void saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		Boolean flag = false;
		String password = emp.getPassword();
		String confirmpassword = emp.getConfirmpassword();
		if (password.equals(confirmpassword)) {
			String emailid = emp.getEmailid();
			int i = emailid.length();
			--i;
			System.out.println("Last index =" + i);
			if (emailid.charAt(0) != '@' && emailid.charAt(i) != '@') {
				for (int j = 1; j < i; j++) {
					if (emailid.charAt(j) == '@') {
						dao.saveEmployee(emp);
						
						flag = true;
						break;

					}

				}

			}

			else {
				throw new EmailFormat();

			}
			if (flag == false) {

				throw new EmailFormat();
			}

		} else {
			throw new PasswordNotMatch();
		}

	}

	@Transactional
	public List<Employee> getEmployeeList() {
		List<Employee> li = dao.getEmployeeList();
		return li;

	}
	@Transactional
	public void updateEmployee(Employee emp) {
		dao.updateEmployee(emp);
		
	}
	
	@Transactional
	public void deleteEmployee(int id ) {
		dao.deleteEmployee(id);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Employee getEmployeeById(int id) {
		Employee emp = dao.getEmployeeById(id);
		if(emp==null) {
			throw new IdNotFound();
		}
		return emp;
		
	}

}
