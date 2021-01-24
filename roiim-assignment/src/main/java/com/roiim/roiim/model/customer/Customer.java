package com.roiim.roiim.model.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long customer_id_generated;
	 
	 @Column
	 private String id;
	 
	 @Column
	 private String  email;
	 
	 @Column
	 private String merchantCustomerId;
	 
	 @Column
	 private String firstName;
	 
	 @Column
	 private String lastName ;
	 
	 String responseMessage;
	public Customer() {
		super();
		
	}
	public Customer(Long customer_id_generated, String id, String email, String firstName,
			String lastName, String merchantCustomerId) {
		super();
		this.customer_id_generated = customer_id_generated;
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.merchantCustomerId=merchantCustomerId;
	}
	public String getMerchantCustomerId() {
		return merchantCustomerId;
	}
	public void setMerchantCustomerId(String merchantCustomerId) {
		this.merchantCustomerId = merchantCustomerId;
	}
	public Long getCustomer_id_generated() {
		return customer_id_generated;
	}
	public void setCustomer_id_generated(Long customer_id_generated) {
		this.customer_id_generated = customer_id_generated;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	@Override
	public String toString() {
		return "Customer [customer_id_generated=" + customer_id_generated + ", id=" + id + ", email=" + email
				+ ", merchantCustomerId=" + merchantCustomerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", responseMessage=" + responseMessage + "]";
	}
	
	
	
	
}
