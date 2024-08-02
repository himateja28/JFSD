package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@Column(name="eid")
	int eid;
	
	@Column(name="ename")
	String ename;
	
	@Column(name="esalary")
	double esalary;
	public void setEid(int eid)
	{
		this.eid=eid;
	}
	public void setEname(String ename)
	{
		this.ename=ename;
	}
	public void setEsalary(double esalary)
	{
		this.esalary=esalary;
	}
	public int getEid()
	{
		return eid;
	}
	public String getEname()
	{
		return ename;
	}
	public double getEsalary()
	{
		return esalary;
	}
	
}
