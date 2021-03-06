package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.app.model.Employee;

public class Main {

	public static void main(String[] args) {
		Configuration configuration=new Configuration().configure();
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory=configuration.buildSessionFactory(builder.build());
		

		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		//inserting a employee row
		Employee employee1= new Employee(101, "ramesh", 55000.00);
		Employee employee2= new Employee(107, "suresh", 65000.00);
		session.save(employee1);
		session.save(employee2);
		//to get the deatils
		Employee employee =(Employee)session.get(Employee.class, 101);
		System.out.println(employee);
		Employee employe =(Employee)session.get(Employee.class, 107);
		System.out.println(employe);
		
				
		
		
		
		
		
		
		transaction.commit();
		session.close();
		
		factory.close();
	}

	}


