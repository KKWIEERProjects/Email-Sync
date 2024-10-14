package com.activitiesBackend.activitiesBackend.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data
@Builder
@Table(name="coordinator", 
		uniqueConstraints= {
								@UniqueConstraint(name="unique_id", columnNames="cooordinatorId"),
								@UniqueConstraint(name="unique_emailId" , columnNames="emailId"),
								@UniqueConstraint(name ="unique_phone", columnNames= "phone")
							})
public class Coordinator{
	
	//@SequenceGenerator(name = "student_sequence",sequenceName ="student_sequence", allocationSize =1)
	
	@Id
	@Column(name="coordinator_id", nullable= false)
	private String coordinatorId;
	
	@Column(name="coordinatorname")
	private String coordinatorName;
	
	@Column(name="emailId", nullable= false)
	private String emailId;
	
	@Column(name="phone", nullable = false)
	private String phone;
	
	@Column(name="password", nullable= false)
	private String password;
	
	
	//Getter and Setter Methods
	public String getCoordinatorId() {
		return coordinatorId;
	}
	public void setCoordinatorId(String coordinatorId) {
		this.coordinatorId = coordinatorId;
	}
	public String getCoordinatorName() {
		return coordinatorName;
	}
	public void setCoordinatorName(String coordinatorName) {
		this.coordinatorName = coordinatorName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//Default Constructor 
	public Coordinator() {
		super();
	}
	//Parameterized Constructor
	public Coordinator(String coordinatorId, String coordinatorName, String emailId, String phone, String password) 
	{
		super();
		this.coordinatorId = coordinatorId;
		this.coordinatorName = coordinatorName;
		this.emailId = emailId;
		this.phone = phone;
		this.password = password;
	}
	
	//Constructor with 2 values Id and Password
	public Coordinator(String coordinatorId, String password) 
	{
		super();
		this.coordinatorId = coordinatorId;
		this.password = password;
	}	
}