package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="faculty")
public class Faculty {
	@Id
	@Column(name="fid")
	int fid;
	@Column(name="fname")
	String fname;
	@Column(name="fsalary")
	double fsalary;
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public double getFsalary() {
		return fsalary;
	}
	public void setFsalary(double fsalary) {
		this.fsalary = fsalary;
	}
	@Override
	public String toString() {
		return "Faculty [fid=" + fid + ", fname=" + fname + ", fsalary=" + fsalary + "]";
	}
	
	
}
