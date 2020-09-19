package com.microservice1.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;

import com.microservice1.IdNotFound;
import com.microservice1.NullFeild;
import com.microservice1.SameCompanyName;
import com.microservice1.model.Employee;

@Component
public class Dao1imp implements Dao1 {
	@Autowired
	private EntityManager em;

	public void saveEmployee(Employee e) {

		
		try {
			Session cs = em.unwrap(Session.class);
			Query<Employee> q = cs.createQuery("from Employee", Employee.class);
			List<Employee> li = q.getResultList();
			Iterator<Employee> it = li.iterator();
			while (it.hasNext()) {

				Employee em = it.next();
				if (em.getCompanyname().equals(e.getCompanyname())) {
					System.out.println("check1");

					throw new SameCompanyName();

				}

			}

			cs.save(e);
			System.out.println("Employee is save");

		} catch (SameCompanyName scn) {
			throw new SameCompanyName();

		} catch (Exception ex) {
			throw new NullFeild();
		}

	}

	@Override
	public List<Employee> getEmployeeList() {
		// TODO Auto-generated method stub
		Session cs = em.unwrap(Session.class);
		Query<Employee> q = cs.createQuery("from Employee", Employee.class);
		List<Employee> li = q.getResultList();

		return li;

	}
	public Employee getEmployeeById(int id) {
		Session cs = em.unwrap(Session.class);
		Employee emp = cs.get(Employee.class, id);
		return emp;
		
		
	}

	
	public void updateEmployee(Employee emp) {
		
		Session cs = em.unwrap(Session.class);
		Query<Employee> q = cs.createQuery("from Employee", Employee.class);
		List<Employee> li = q.getResultList();
		Iterator<Employee> it = li.iterator();
		while (it.hasNext()) {

			Employee em = it.next();
			if (em.getCompanyname().equals(emp.getCompanyname()) && em.getId()!=emp.getId()) {
				System.out.println("check4");

				throw new SameCompanyName();

			}


		
		}
		cs.flush();
		cs.clear();

		
		cs.update(emp);
		
		
	}
	public void deleteEmployee(int id ) {
		
		
		Session cs = em.unwrap(Session.class);
		Employee emp = cs.get(Employee.class, id);
		if(emp==null) {
			throw new IdNotFound();
		
		}
		else {
			cs.delete(emp);
		}
		
		
		}

}
