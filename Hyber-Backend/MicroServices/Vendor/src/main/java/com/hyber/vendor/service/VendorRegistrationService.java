package com.hyber.vendor.service;

import java.util.List;

import com.hyber.vendor.repository.dataentity.Vendor;

public interface VendorRegistrationService {
	
	public void addVendor(Vendor vendor);
	
	public List<Vendor> getAllVendorsDetails();
	

}
