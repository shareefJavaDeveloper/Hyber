package com.hyber.customer.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyber.customer.repository.CustomerRegRepo;
import com.hyber.customer.repository.dataentity.CustomerReg;
import com.hyber.customer.service.CustomerRegistrationService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	private CustomerRegistrationService customerRegService;

	@PostMapping("/CustomerRegistration")
    public void customerRegApi(@RequestBody CustomerReg customerRegistration) {
		try {
			customerRegService.addCustomer(customerRegistration);
			
		}catch (Exception e) {
			throw new RuntimeException(e.getLocalizedMessage());
	}
	}
}
