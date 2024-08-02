package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class FacultyManager {
	public List<Faculty> getData()throws Exception
	{
		SessionFactory SF = new Configuration().configure().buildSessionFactory();
		Session SES = SF.openSession();
		
		SES.getTransaction().begin();
		List<Faculty> flist = null;
		
		CriteriaBuilder CB = SES.getCriteriaBuilder();
		CriteriaQuery<Faculty> CR = CB.createQuery(Faculty.class);
		Root<Faculty> root = CR.from(Faculty.class);
//		CR.select(root);		//Retrive all data 
		
		CR.select(root).where(CB.gt(root.get("fid"), 2));
		TypedQuery<Faculty> qry = SES.createQuery(CR);
		flist = qry.getResultList();
		
		
		SES.getTransaction().commit();
		
		SES.close();
		SF.close();
		return flist;
	}
}
