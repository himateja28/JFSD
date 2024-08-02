package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="type3contractemployee")
@PrimaryKeyJoinColumn(name="eid")
public class ContractEmployee extends Employee {
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
