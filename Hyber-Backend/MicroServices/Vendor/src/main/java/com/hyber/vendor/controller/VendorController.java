package com.hyber.vendor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyber.vendor.repository.VendorRepo;
import com.hyber.vendor.repository.dataentity.Vendor;

import java.util.*;

@RestController
@RequestMapping("/api")
public class VendorController {
	
	@Autowired
	private VendorRepo vendorRepo;
	
	@GetMapping("/getVendor")
	public List<Vendor> getVendor(){
		
		return vendorRepo.findAll();
	}

}
