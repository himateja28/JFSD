package model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="type2regularemployee")
@AttributeOverrides({ 
	@AttributeOverride(name="id",column = @Column(name="eid")),
	@AttributeOverride(name="name",column = @Column(name="ename"))
})
public class RegularEmployee extends Employee
{
	@Column(name="salary")
	double salary;
	@Column(name="bonus")
	int bonus ;
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
}
