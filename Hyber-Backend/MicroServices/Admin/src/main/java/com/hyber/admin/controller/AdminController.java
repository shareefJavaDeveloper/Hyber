package com.hyber.admin.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hyber.admin.repository.dataentity.Vendor;
import com.hyber.admin.utils.AdminUtils;

@RestController
@RequestMapping("/api")
public class AdminController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(value = "/AdminVendorList", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Vendor> getVendorList(){
		
		return Arrays.asList(restTemplate.getForObject(AdminUtils.V_API_GETVENDORLIST, Vendor[].class));
		
	}

}
