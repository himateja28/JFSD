package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;

import jakarta.persistence.TypedQuery;

public class StudentManager {
	
	public String addStudent(Student s) throws Exception
	{
		SessionFactory SF = new Configuration().configure().buildSessionFactory();
		Session SES = SF.openSession();
		
		SES.getTransaction().begin();
		SES.persist(s);
		SES.getTransaction().commit();
		
		SES.close();
		SF.close();
		return "Data saved successfully";
	}
	
	public String updateStudent(Student s) throws Exception
	{

		SessionFactory SF = new Configuration().configure().buildSessionFactory();
		Session SES = SF.openSession();
		
		SES.getTransaction().begin();
		Student tmp = SES.find(Student.class,s.getSid());
		tmp.setSname(s.getSname());
		tmp.setSdept(s.getSdept());
		SES.merge(tmp);
		SES.getTransaction().commit();
		
		SES.close();
		SF.close();
		return "Data updated successfully";
		
	}
	public String deleteStudent(int sid) throws Exception
	{
		SessionFactory SF = new Configuration().configure().buildSessionFactory();
		Session SES = SF.openSession();
		
		SES.getTransaction().begin();
		
		
		Student tmp = SES.find(Student.class,sid);
		SES.remove(tmp);
		
		
		SES.getTransaction().commit();
		
		SES.close();
		SF.close();
		return "Data deleted successfully";
	}
	public List<Student> readStudent()throws Exception
	{
		List<Student> slist =null;
		SessionFactory SF = new Configuration().configure().buildSessionFactory();
		Session SES = SF.openSession();
		
		SES.getTransaction().begin();
		
		TypedQuery<Student> qry=SES.createQuery("select s from Student s",Student.class);
		slist = qry.getResultList();
		
		SES.getTransaction().commit();
		
		SES.close();
		SF.close();
		return slist;
	}

}
