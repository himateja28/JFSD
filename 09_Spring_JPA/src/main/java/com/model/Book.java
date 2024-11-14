package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	@Id
	@Column(name = "id")
	Long id;
	
	@Column(name = "booktitle")
	String booktitle;
	
	@Column(name = "price")
	double price;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
