package com.hyber.vendor.serviceImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.hyber.vendor.repository.VendorHIstRegRepo;
import com.hyber.vendor.repository.dataentity.VendorHistReg;
import com.hyber.vendor.service.VendorEmailService;
import com.hyber.vendor.util.VendorConstants;

@Service
public class VendorEmailServiceImpl implements VendorEmailService{
	
	 @Autowired
	 private JavaMailSender emailSender;
	 
	 @Autowired
	 private VendorHIstRegRepo vendorHistRegRepo;
	 	
	 @Override
	    public void sendEmail(String to,
	    							  String subject, 
	    							  String text) throws MessagingException {
	      
		 	MimeMessage message = emailSender.createMimeMessage();
	     
		    MimeMessageHelper helper = new MimeMessageHelper(message, true);

		    helper.setTo(to);
		    helper.setSubject(subject);
		    helper.setText(text, true);

		    emailSender.send(message);
	    }

	@Override
	public String textOfTheSuccessfulmail(VendorHistReg vendorHistReg) throws Exception {
		 String emailBody = "<html>" +
				 "<h1>" +
				 "Welcome " + vendorHistReg.getFirstName() + " ...!" +
				 "</h1>" +
				 "</br>" +
				 "<h3>" +
				 "Your Registration is Successful...Continue Using Services" +
				 "</h3>" +
				 "</html>";
		return emailBody;
	}
	

	@Override
	public String textOfTheFailuremail(VendorHistReg vendorHistReg) throws Exception {
		String emailBody = "<html>" +
							"<h2>" +
							"Hi " + vendorHistReg.getFirstName() + ", " +
							"</h2>" +
							"</br>" +
							"<p>" +
							"Your Registration is Failed...please check the submitted details" +
							"</p>" +
							"</html>";
return emailBody;
	}


	@Override
	public void prepareAndCallSendEmail(String vendorRegId) {
		
		VendorHistReg vendorHistReg = vendorHistRegRepo.findByVendorRegId(Integer.parseInt(vendorRegId));
		
		if (vendorHistReg.getVendorStatus().equalsIgnoreCase(VendorConstants.ACCEPTED)) {
			String subject = "Vendor Registration Successful-Hyber";
			
			try {
				sendEmail(vendorHistReg.getEmailId(), subject, textOfTheSuccessfulmail(vendorHistReg));
			} catch (Exception e) {
				throw new RuntimeException("Error at AcceptedSendEmail : "+ e.getLocalizedMessage());
			}
		}
		else if (vendorHistReg.getVendorStatus().equalsIgnoreCase(VendorConstants.REJECTED)){
			String subject = "Vendor Registration Rejected-Hyber";
			
			try {
				sendEmail(vendorHistReg.getEmailId(), subject, textOfTheFailuremail(vendorHistReg));
			} catch (Exception e) {
				throw new RuntimeException("Error at RejectedSendEmail : "+ e.getLocalizedMessage());
			}
		}
		
	}

	
}
