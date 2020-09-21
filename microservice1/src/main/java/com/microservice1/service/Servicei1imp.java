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
import com.microservice1.model.Signup;
import com.microservice1.model.UserLogin;

@Component
public class Servicei1imp implements Service1 {
	@Autowired
	Dao1 dao;
	@Autowired
	Employee e;

	@Override
	@Transactional
	public void saveEmployee(Signup emp, UserLogin ul) {
		// TODO Auto-generated method stub
		Boolean flag = false;
		
		
		if(emp.getEmailid() != null && emp.getPassword() != null && emp.getConfirmpassword() != null) {
			System.out.println("check 9 email id ="+emp.getEmailid());
			String password = emp.getPassword();
			String confirmpassword = emp.getConfirmpassword();
		if (password.equals(confirmpassword)) {
			
			String emailid = emp.getEmailid();
			int i = emailid.length();
			--i;
			System.out.println("Last index =" + i);
			
				System.out.println("Check 6");
			if (emailid.charAt(0) != '@' && emailid.charAt(i) != '@') {
				for (int j = 1; j < i; j++) {
					if (emailid.charAt(j) == '@') {

						

							ul.setEmailid(emp.getEmailid());
							
							ul.setPassword(emp.getPassword());
							ul.setConfirmpassword(emp.getConfirmpassword());
							
							
							e.setName(emp.getName());
							e.setEmailid(emp.getEmailid());
							e.setState(emp.getState());
							e.setPhoneno(emp.getPhoneno());
							e.setZipcode(emp.getZipcode());
							e.setPhoneno(emp.getPhoneno());
							e.setCountry(emp.getCountry());
							e.setAddressLine1(emp.getAddressLine1());
							e.setCompanyname(emp.getCompanyname());
							e.setAddressLine2(emp.getAddressLine2());
							
							dao.saveEmployee(e, ul);

					

						flag = true;
						break;

					}// if end

				} // for end

			}// if end

			else {
				throw new EmailFormat();

			} //if email @ check (first and last @ check)
			if (flag == false) {

				throw new EmailFormat();
			}

		} else {
			
			System.out.println("Check 7");
			throw new PasswordNotMatch();
		}
		}
		else {
			throw new NullFeild();
			
		}// if (null)

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
	public void deleteEmployee(int id) {
		dao.deleteEmployee(id);

	}

	public Employee getEmployeeById(int id) {
		Employee emp = dao.getEmployeeById(id);
		if (emp == null) {
			throw new IdNotFound();
		}
		return emp;

	}

	@Override

	@Transactional
	public Employee userLoginVerificatio(UserLogin ul) {
		// TODO Auto-generated method stub
		Employee e1 = dao.userLoginVerification(ul);
		return e1;
		
		
		
		
	}

}
