package com.roiim.roiim.model.payment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="payment")
public class PaymentRequest {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;
	
	 @JsonProperty("amount")
	 private long amount;
	 
	 @JsonProperty("currency")
	 private String currency;
	 
	 @Column
	 @JsonProperty("customerId")
	 private String customerId;
	 
	 @JsonProperty("customerOperation")
	 private String customerOperation;
	 
	 @JsonProperty("merchantRefNum")
	 private String merchantRefNum;
	 
	 @Column
	 @JsonProperty("paymentHandleToken")
	 private String paymentHandleToken;
	 
	 @JsonProperty("paymentMethod")
	 private String paymentMethod;
	 
	 @JsonProperty("transactionType")
	 private String transactionType;
	 
	 private String message;
	 
	 
	
	
	public PaymentRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PaymentRequest(long amount, String currency, String customerId, String customerOperation, String merchantRefNum,
			String paymentHandleToken, String paymentMethod, String transactionType , String message) {
		super();
		this.amount = amount;
		this.currency = currency;
		this.customerId = customerId;
		this.customerOperation = customerOperation;
		this.merchantRefNum = merchantRefNum;
		this.paymentHandleToken = paymentHandleToken;
		this.paymentMethod = paymentMethod;
		this.transactionType = transactionType;
		this.message=message;
	}
	
	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}

	public long getAmount() {
		return amount;
	}


	public void setAmount(long amount) {
		this.amount = amount;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getCustomerOperation() {
		return customerOperation;
	}


	public void setCustomerOperation(String customerOperation) {
		this.customerOperation = customerOperation;
	}


	public String getMerchantRefNum() {
		return merchantRefNum;
	}


	public void setMerchantRefNum(String merchantRefNum) {
		this.merchantRefNum = merchantRefNum;
	}


	public String getPaymentHandleToken() {
		return paymentHandleToken;
	}


	public void setPaymentHandleToken(String paymentHandleToken) {
		this.paymentHandleToken = paymentHandleToken;
	}


	public String getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}


	public String getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


	@Override
	public String toString() {
		return "PaymentRequest [amount=" + amount + ", currency=" + currency + ", customerId=" + customerId
				+ ", customerOperation=" + customerOperation + ", merchantRefNum=" + merchantRefNum
				+ ", paymentHandleToken=" + paymentHandleToken + ", paymentMethod=" + paymentMethod
				+ ", transactionType=" + transactionType + "]";
	}
	
	
	
	
}
