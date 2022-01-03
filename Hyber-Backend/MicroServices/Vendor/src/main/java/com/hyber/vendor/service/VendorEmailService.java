package com.hyber.vendor.service;

import javax.mail.MessagingException;

import com.hyber.vendor.repository.dataentity.VendorHistReg;

public interface VendorEmailService {
	public void sendEmail(String to,
			  String subject, 
			  String text) throws MessagingException;
	
	public String textOfTheSuccessfulmail(VendorHistReg vendor) throws Exception;

	public void prepareAndCallSendEmail(String vendorRegId);
	
	public String textOfTheFailuremail(VendorHistReg vendor) throws Exception;
}
