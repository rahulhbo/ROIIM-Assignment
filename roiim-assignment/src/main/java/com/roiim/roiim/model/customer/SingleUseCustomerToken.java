package com.roiim.roiim.model.customer;

public class SingleUseCustomerToken {
	
	    private String id;
	    private String customerId;
	    private String timeToLiveSeconds;
	    private String status;
	    private String singleUseCustomerToken;
	    private String locale;
	    private String firstName;
	    private String lastName;
	    
		public SingleUseCustomerToken(String id, String customerId, String timeToLiveSeconds, String status,
				String singleUseCustomerToken, String locale, String firstName, String lastName) {
			super();
			this.id = id;
			this.customerId = customerId;
			this.timeToLiveSeconds = timeToLiveSeconds;
			this.status = status;
			this.singleUseCustomerToken = singleUseCustomerToken;
			this.locale = locale;
			this.firstName = firstName;
			this.lastName = lastName;
		}
		public SingleUseCustomerToken() {
			super();
			// TODO Auto-generated constructor stub
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getCustomerId() {
			return customerId;
		}
		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}
		public String getTimeToLiveSeconds() {
			return timeToLiveSeconds;
		}
		public void setTimeToLiveSeconds(String timeToLiveSeconds) {
			this.timeToLiveSeconds = timeToLiveSeconds;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getSingleUseCustomerToken() {
			return singleUseCustomerToken;
		}
		public void setSingleUseCustomerToken(String singleUseCustomerToken) {
			this.singleUseCustomerToken = singleUseCustomerToken;
		}
		public String getLocale() {
			return locale;
		}
		public void setLocale(String locale) {
			this.locale = locale;
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
		@Override
		public String toString() {
			return "SingleUseCustomerToken [id=" + id + ", customerId=" + customerId + ", timeToLiveSeconds="
					+ timeToLiveSeconds + ", status=" + status + ", singleUseCustomerToken=" + singleUseCustomerToken
					+ ", locale=" + locale + ", firstName=" + firstName + ", lastName=" + lastName + "]";
		}
		
		
}
