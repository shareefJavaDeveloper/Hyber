package com.hyber.vendor.service;

import javax.mail.MessagingException;

import com.hyber.vendor.repository.dataentity.VendorOldReg;

public interface VendorEmailService {
	public void sendEmail(String to,
			  String subject, 
			  String text) throws MessagingException;
	
	public String textOfThemail(VendorOldReg vendor) throws Exception;

	public void prepareAndCallSendEmail(String vendorRegId);
}
