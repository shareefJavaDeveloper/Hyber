package com.hyber.vendor.service;

import java.util.List;

import com.hyber.vendor.repository.dataentity.VendorReg;

public interface VendorRegistrationService {
	
	public void addVendor(VendorReg vendor);
	
	public List<VendorReg> getAllVendorsDetails();
	

}
