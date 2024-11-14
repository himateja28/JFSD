package klu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	Long rollno;
	String name;
	String dept;
	public Long getRollno() {
		return rollno;
	}
	public void setRollno(Long rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", dept=" + dept + "]";
	}
}
