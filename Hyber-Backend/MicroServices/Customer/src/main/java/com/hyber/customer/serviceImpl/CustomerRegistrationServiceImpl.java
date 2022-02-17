package com.hyber.customer.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyber.customer.repository.CustomerRegRepo;
import com.hyber.customer.repository.dataentity.CustomerReg;
import com.hyber.customer.service.CustomerRegistrationService;

@Service
public class CustomerRegistrationServiceImpl implements CustomerRegistrationService{
    @Autowired
    private CustomerRegRepo customerRegRepo;
	@Override
	public void addCustomer(CustomerReg customerRegistration) {
		try {
			//if(customerRegRepo.findById(null))
		customerRegRepo.save(customerRegistration);
		}catch(Exception e) {
			throw new RuntimeException("Unable to save customer"+e.getLocalizedMessage());
		}
	}

}
