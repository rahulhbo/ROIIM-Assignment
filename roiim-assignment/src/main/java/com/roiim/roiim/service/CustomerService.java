package com.roiim.roiim.service;

import java.util.Collections;
import java.util.List;

import org.json.JSONObject;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roiim.roiim.model.customer.Customer;
import com.roiim.roiim.model.customer.SingleUseCustomerToken;
import com.roiim.roiim.model.payment.CheckoutPayment;
import com.roiim.roiim.model.payment.PaymentRequest;
import java.util.UUID;

public class CustomerService {

	private RestTemplate restTemplate;
	private HttpHeaders headers;
	private String APIKeyId;
	private String APIKeyPassword;
	
	public CustomerService() {
		
		restTemplate=new RestTemplate();
		
		APIKeyId = "private-7751";
	    APIKeyPassword = "B-qa2-0-5f031cdd-0-302d0214496be84732a01f690268d3b8eb72e5b8ccf94e2202150085913117f2e1a8531505ee8ccfc8e98df3cf1748";
		
	    headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setBasicAuth( APIKeyId, APIKeyPassword );
	}
	
	
	public CheckoutPayment processPayment(PaymentRequest paymentRequest) {
		String paymentUrl="https://api.test.paysafe.com/paymenthub/v1/payments";
		JSONObject  checkoutPaymentRequest=new JSONObject();
		
		checkoutPaymentRequest.put("amount",paymentRequest.getAmount() );
		checkoutPaymentRequest.put("customerId",paymentRequest.getCustomerId());
		
		checkoutPaymentRequest.put("merchantRefNum",paymentRequest.getMerchantRefNum());
		checkoutPaymentRequest.put("paymentHandleToken",paymentRequest.getPaymentHandleToken());
		checkoutPaymentRequest.put("currencyCode",paymentRequest.getCurrency());
		
		
		HttpEntity<String> entity = new HttpEntity<String>(checkoutPaymentRequest.toString(),headers);
		ResponseEntity<CheckoutPayment> responseEntity = restTemplate.postForEntity( paymentUrl, entity ,CheckoutPayment.class);
		
		return responseEntity.getBody();
	}
	
	
	public SingleUseCustomerToken getCustomer(Customer customer) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		String jsonString = null;
        try {

            jsonString = objectMapper.writeValueAsString(customer);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
		HttpEntity<String> entity = new HttpEntity<String>(jsonString,headers);
		
		String tokenUrl="https://api.test.paysafe.com/paymenthub/v1/customers"+"/"+customer.getId()+"/singleusecustomertokens";
		
		ResponseEntity<SingleUseCustomerToken> responseEntity = restTemplate.postForEntity( tokenUrl, entity, SingleUseCustomerToken.class );

		SingleUseCustomerToken customerResponse=responseEntity.getBody();
		
		return customerResponse;
		
	}
	
	
	public Customer createCustomer(Customer customer,List<Customer> allCustomers) {
		
		
		for(Customer cust : allCustomers) {
		
			if(cust.getEmail().equals( customer.getEmail())) {
				cust.setResponseMessage("EXISTING_CUSTOMER");
				return cust;
			}
		}
		
		final String uuid = UUID.randomUUID().toString();
		customer.setMerchantCustomerId(uuid);
		
		
		String urlCreateCustomer="https://api.test.paysafe.com/paymenthub/v1/customers";
		ObjectMapper objectMapper = new ObjectMapper();
		
		String jsonString = null;
        try {

            jsonString = objectMapper.writeValueAsString(customer);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		
		HttpEntity<String> entity = new HttpEntity<String>(jsonString,headers);
		ResponseEntity<Customer> responseEntity = restTemplate.postForEntity( urlCreateCustomer, entity, Customer.class );

		
		Customer customerResponse=responseEntity.getBody();
		customerResponse.setResponseMessage("NEW_CUSTOMER");
		
		return customerResponse;
	}
	
	
}
