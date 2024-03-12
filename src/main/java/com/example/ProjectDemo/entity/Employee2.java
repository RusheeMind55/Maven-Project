package com.example.ProjectDemo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Employee2 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	private String name;
	private String department;
	private String status;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdt;
	private String createdby;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedt;
	private String updateby;
	
	@ManyToOne(fetch =FetchType.EAGER)
	@JoinColumn(name = "cid")
	private Country country;

	public Employee2() {
		
		
	}
	
	

	public Employee2(int id, String name, String department, String status, Date createdt, String createdby,
			Date updatedt, String updateby, Country country) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.status = status;
		this.createdt = createdt;
		this.createdby = createdby;
		this.updatedt = updatedt;
		this.updateby = updateby;
		this.country = country;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedt() {
		return createdt;
	}

	public void setCreatedt(Date createdt) {
		this.createdt = createdt;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getUpdatedt() {
		return updatedt;
	}

	public void setUpdatedt(Date updatedt) {
		this.updatedt = updatedt;
	}

	public String getUpdateby() {
		return updateby;
	}

	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Employee2 [id=" + id + ", name=" + name + ", department=" + department + ", status=" + status
				+ ", createdt=" + createdt + ", createdby=" + createdby + ", updatedt=" + updatedt + ", updateby="
				+ updateby + ", country=" + country + "]";
	}

	
	}
	
	
	
	

