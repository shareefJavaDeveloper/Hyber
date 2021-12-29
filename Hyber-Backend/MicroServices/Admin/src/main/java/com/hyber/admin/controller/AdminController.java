package com.hyber.admin.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hyber.admin.repository.dataentity.VendorReg;
import com.hyber.admin.utils.AdminUtils;

@RestController
@RequestMapping("/api")
public class AdminController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(value = "/AdminVendorList")
	public List<VendorReg> getVendorListApi(){
		
		return Arrays.asList(restTemplate.getForObject(AdminUtils.V_API_GETVENDORLIST, VendorReg[].class));
		
	}
	
	@PutMapping(value = "/adminAcceptVendor/{vendorRegId}")
	public void adminAcceptingVendor(@PathVariable String vendorRegId){
		
		restTemplate.put(AdminUtils.V_API_ADMINACCEPTINGVENDOR + vendorRegId, null);
		
	}

}
