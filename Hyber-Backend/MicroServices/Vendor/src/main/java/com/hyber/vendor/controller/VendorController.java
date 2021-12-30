package com.hyber.vendor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.hyber.vendor.repository.StoreProcedureCustomRepository;
import com.hyber.vendor.repository.VendorRepo;
import com.hyber.vendor.repository.dataentity.VendorReg;
import com.hyber.vendor.service.VendorEmailService;
import com.hyber.vendor.service.VendorRegistrationService;
import com.hyber.vendor.util.VendorConstants.SPNames;

import java.util.*;

@RestController
@RequestMapping("/api")
public class VendorController {
	
	@Autowired
	private VendorRegistrationService vendorRegService;
	
	@Autowired
	private VendorEmailService vendorEmailService;
	
	@Autowired
	private com.hyber.vendor.repository.StoreProcedureCustomRepository spcr;
	
	@GetMapping("/getVendor")
	public List<VendorReg> getVendorApi(){
		try {
		List<VendorReg> AllVendorDetails = vendorRegService.getAllVendorsDetails();
		 return AllVendorDetails;
			}catch (Exception e) {
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage(),e);
		}
	}
	
	@PostMapping("/vendorRegistration")
	public void vendorRegApi(@RequestBody VendorReg vendorRegistration) {
		
	try{
		vendorRegService.addVendor(vendorRegistration);
		}catch (Exception e) {
			throw new RuntimeException(e.getLocalizedMessage());
			}
	}
	
	@GetMapping(value = "/acceptVendor/{vendorRegId}")
	public void acceptVendor(@PathVariable String vendorRegId) {
		
		try {	
				vendorRegService.UpdateStatusToAccepted(Integer.parseInt(vendorRegId));
				spcr.executeStoredProcedure(SPNames.SP_VENDOR_REGISTRATION_PROCESS, vendorRegId);
				vendorEmailService.prepareAndCallSendEmail(vendorRegId);
		}catch (Exception e) {
			throw new RuntimeException(e.getLocalizedMessage());
		}	
	}
	
	@DeleteMapping(value = "/deleteVendor/{vendorRegId}")
	public void removeVendor(@PathVariable String vendorRegId) {
		try {
			
			vendorRegService.UpdateStatusToRejected(Integer.parseInt(vendorRegId));
			spcr.executeStoredProcedure(SPNames.SP_VENDOR_REGISTRATION_PROCESS, vendorRegId);
			vendorEmailService.prepareAndCallSendEmail(vendorRegId);
			
		}catch (Exception e) {
			throw new RuntimeException(e.getLocalizedMessage());
		}
		
	}
	
		
	}

