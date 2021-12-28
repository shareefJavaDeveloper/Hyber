package com.hyber.vendor.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyber.vendor.repository.VendorRepo;
import com.hyber.vendor.repository.dataentity.Vendor;
import com.hyber.vendor.service.VendorRegistrationService;

@Service
public class VendorRegistrationServiceImpl implements VendorRegistrationService{
	
	@Autowired
	private VendorRepo vendorRepo;
	
	
	@Override
	public void addVendor(Vendor vendor) {
		vendorRepo.save(vendor);
	}


	@Override
	public List<Vendor> getAllVendorsDetails() {
		List<Vendor> allVendorsList = vendorRepo.findAll();
		return allVendorsList;
	}

}
