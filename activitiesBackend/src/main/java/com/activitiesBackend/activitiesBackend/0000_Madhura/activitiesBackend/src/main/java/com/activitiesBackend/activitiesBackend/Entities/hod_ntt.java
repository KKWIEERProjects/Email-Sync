package com.activitiesBackend.activitiesBackend.Entities;
/* This file will have all the variable , functions and getter and setter methods*/

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Builder
@Table(name="hod",
		uniqueConstraints= {
								@UniqueConstraint(
													name = "unique_hodid",
													columnNames = "hod_id"
													),
								@UniqueConstraint(
													name = "unique_emailid",
													columnNames ="email_address") ,
								
								@UniqueConstraint(
										name = "unique_hodphone",
										columnNames = "phone")
							}
		)
public class hod_ntt
{
	@Id
	@Column(name= "hod_id",nullable= false)
	private String hod_id ;
	
	@OneToMany
	private Coordinator coCtrl;
	// I have not kept it as auto-generated because our teachers are already having unique ID CrnNO. we'll use that
	
	@Column(name= "email_address", nullable = false)
	private String emailid;
	
	@Column(name= "phone" , nullable = false)
	private String phone;
	
	@Column(name= "hod_name")
	private String hod_name; 
	
	@Column(name= "department")
	private String department;
	
	@Column(name= "address")
	private String address ;
	
	@Column(name= "bdate")
	private String bdate ;
	
	@Column(name= "password", nullable = false)
	private String password;
	

	public String getHod_id() {
		return hod_id;
	}

	public void setHod_id(String hod_id) {
		this.hod_id = hod_id;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHod_name() {
		return hod_name;
	}

	public void setHod_name(String hod_name) {
		this.hod_name = hod_name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	
	
	//Default Constructor
	public hod_ntt() {
		super();
	}
		
	//Parameterized Constructor
	public hod_ntt(String hod_id, String emailid, String phone, String hod_name, String department, String address, String bdate) 
	{
		super();
		this.hod_id = hod_id;
		this.emailid = emailid;
		this.phone = phone;
		this.hod_name = hod_name;
		this.department = department;
		this.address = address;
		this.bdate = bdate;
	}
}