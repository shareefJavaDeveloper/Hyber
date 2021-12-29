package com.hyber.vendor.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.hyber.vendor.repository.VendorOldRegRepo;
import com.hyber.vendor.repository.VendorRepo;
import com.hyber.vendor.repository.dataentity.VendorReg;
import com.hyber.vendor.service.VendorRegistrationService;

@Service
public class VendorRegistrationServiceImpl implements VendorRegistrationService{
	
	@Autowired
	private VendorRepo vendorRepo;
	
	@Autowired
	private VendorOldRegRepo vendorOldRegRepo;
	
	
	@Override
	public void addVendor(VendorReg vendor) {
		if (vendorRepo.existsById(vendor.getVendorRegId()) || vendorOldRegRepo.existsById(vendor.getVendorRegId())) {
			throw new RuntimeException("Error at addVendor() : VendorRegId Already Exists");
		}
		else {
			vendorRepo.save(vendor);
		}
	}


	@Override
	public List<VendorReg> getAllVendorsDetails() {
		List<VendorReg> allVendorsList = vendorRepo.findAll();
		return allVendorsList;
	}

}
