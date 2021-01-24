package com.roiim.roiim.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.roiim.roiim.model.customer.Customer;
import com.roiim.roiim.model.customer.SingleUseCustomerToken;
import com.roiim.roiim.model.payment.CheckoutPayment;
import com.roiim.roiim.model.payment.PaymentRequest;
import com.roiim.roiim.repository.CustomerRepository;

import com.roiim.roiim.service.CustomerService;

@CrossOrigin
@RestController
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
	
	CustomerService customerService=new CustomerService();
	
	@PostMapping("/payment")
	public CheckoutPayment ProcessPayment(@RequestBody PaymentRequest paymentRequest ){
		
		return customerService.processPayment(paymentRequest);

	}
	
	
	@PostMapping("/create-customer")
	public Customer createCustomer(@RequestBody Customer customer) {
		
		List<Customer> allCustomers =customerRepository.findAll();
	    Customer customerResponse = customerService.createCustomer(customer,allCustomers );
	    customerRepository.save(customerResponse);
	    
	    return customerResponse;
	}
	
	
	@PostMapping("/get-customer")
	public SingleUseCustomerToken getCustomer(@RequestBody Customer customer) {
		
		return customerService.getCustomer(customer);
	}
	

	
	@GetMapping("/")
	public String getAllCustomers() { 
		
		return "SERVER_STARTED";
	}
	
}
