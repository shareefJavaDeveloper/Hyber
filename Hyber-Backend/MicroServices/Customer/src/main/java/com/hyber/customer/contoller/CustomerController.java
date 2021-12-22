package com.hyber.customer.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyber.customer.repository.CustomerRepo;
import com.hyber.customer.repository.dataentity.Customer;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@GetMapping("/getCustomer")
	public List<Customer> getAllCustomers(){
		return customerRepo.findAll();
		
	}

}
