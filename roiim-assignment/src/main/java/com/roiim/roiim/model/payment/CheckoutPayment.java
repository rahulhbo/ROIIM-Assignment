package com.roiim.roiim.model.payment;

public class CheckoutPayment {
	 	private String id;
	 	private String paymentType;
	 	private String paymentHandleToken;
	 	private String merchantRefNum;
	 	private String currencyCode;
	 	private String settleWithAuth;
	 	private String txnTime;
	 	private String status;
	 	private Long amount;
	 	private String  preAuth;
	 	private Long  availableToSettle;
	 	
	 	private String multiUsePaymentHandleToken;
	 	private String customerId;
	 	
	 	private String message;
	    
	    
	 	
	 	
		public CheckoutPayment() {
			super();
			// TODO Auto-generated constructor stub
		}
		public CheckoutPayment(String id, String paymentType, String merchantRefNum, String currencyCode,
				String settleWithAuth, String txnTime, String status, Long amount, String preAuth,
				Long availableToSettle, String multiUsePaymentHandleToken, String customerId) {
			super();
			this.id = id;
			this.paymentType = paymentType;
			this.merchantRefNum = merchantRefNum;
			this.currencyCode = currencyCode;
			this.settleWithAuth = settleWithAuth;
			this.txnTime = txnTime;
			this.status = status;
			this.amount = amount;
			this.preAuth = preAuth;
			this.availableToSettle = availableToSettle;
			this.multiUsePaymentHandleToken = multiUsePaymentHandleToken;
			this.customerId = customerId;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPaymentType() {
			return paymentType;
		}
		public void setPaymentType(String paymentType) {
			this.paymentType = paymentType;
		}
		public String getMerchantRefNum() {
			return merchantRefNum;
		}
		public void setMerchantRefNum(String merchantRefNum) {
			this.merchantRefNum = merchantRefNum;
		}
		public String getCurrencyCode() {
			return currencyCode;
		}
		public void setCurrencyCode(String currencyCode) {
			this.currencyCode = currencyCode;
		}
		public String getSettleWithAuth() {
			return settleWithAuth;
		}
		public void setSettleWithAuth(String settleWithAuth) {
			this.settleWithAuth = settleWithAuth;
		}
		public String getTxnTime() {
			return txnTime;
		}
		public void setTxnTime(String txnTime) {
			this.txnTime = txnTime;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Long getAmount() {
			return amount;
		}
		public void setAmount(Long amount) {
			this.amount = amount;
		}
		public String getPreAuth() {
			return preAuth;
		}
		public void setPreAuth(String preAuth) {
			this.preAuth = preAuth;
		}
		public Long getAvailableToSettle() {
			return availableToSettle;
		}
		public void setAvailableToSettle(Long availableToSettle) {
			this.availableToSettle = availableToSettle;
		}
		public String getMultiUsePaymentHandleToken() {
			return multiUsePaymentHandleToken;
		}
		public void setMultiUsePaymentHandleToken(String multiUsePaymentHandleToken) {
			this.multiUsePaymentHandleToken = multiUsePaymentHandleToken;
		}
		public String getCustomerId() {
			return customerId;
		}
		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}
		public String getPaymentHandleToken() {
			return paymentHandleToken;
		}
		public void setPaymentHandleToken(String paymentHandleToken) {
			this.paymentHandleToken = paymentHandleToken;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
	    
}
