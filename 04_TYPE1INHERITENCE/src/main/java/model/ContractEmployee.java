package model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value="ContractEmployee")
public class ContractEmployee extends Employee
{
	@Column(name="payperhour")
	double payperhour;
	@Column(name="duration")
	String duration;
	public double getPayperhour() {
		return payperhour;
	}
	public void setPayperhour(double payperhour) {
		this.payperhour = payperhour;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
}
