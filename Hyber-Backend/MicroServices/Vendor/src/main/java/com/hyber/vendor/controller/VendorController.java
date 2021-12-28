package com.hyber.vendor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.hyber.vendor.repository.dataentity.Vendor;
import com.hyber.vendor.service.VendorRegistrationService;

import java.util.*;

@RestController
@RequestMapping("/api")
public class VendorController {
	
	@Autowired
	private VendorRegistrationService vendorRegService;
	
	@GetMapping("/getVendor")
	public List<Vendor> getVendor(){
		try {
		List<Vendor> AllVendorDetails = vendorRegService.getAllVendorsDetails();
		 return AllVendorDetails;
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage(),e);
		}
	}
	
	@PostMapping("/vendorRegistration")
	public void vendorReg(@RequestBody Vendor vendorRegistration,ModelMap model) {
		
	try{
		vendorRegService.addVendor(vendorRegistration);
	}catch (Exception e) {
		throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage(),e);
	}
	}
		
	}

