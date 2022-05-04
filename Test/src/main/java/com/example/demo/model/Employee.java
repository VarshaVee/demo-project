package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Emp")
public class Employee {
	
	@Id
	@GeneratedValue
	private Integer  id;
	private String name;
	private String address;
	private double salary;
	private String companyId;
	private float pfpercentage;
	private double netsalary;
	private double pfamount;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public float getPfpercentage() {
		return pfpercentage;
	}
	public void setPfpercentage(float pfpercentage) {
		this.pfpercentage = pfpercentage;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
	 public double getNetsalary() {
		return netsalary;
	}
	public void setNetsalary(double netsalary) {
		this.netsalary = netsalary;
	}
	public double getPfamount() {
		return pfamount;
	}
	public void setPfamount(double pfamount) {
		this.pfamount = pfamount;
	}

   
			
}
