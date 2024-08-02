package model;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class EmployeeManager {

	public String addEmployee(Employee E)throws Exception
	{
		SessionFactory SF = new Configuration().buildSessionFactory();
		Session S = SF.openSession();
		
		S.getTransaction().begin();
		S.persist(E);
		S.getTransaction().commit();
		
		S.close();
		SF.close();
		return "Data added successfully";
	}
}

