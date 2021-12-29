package com.hyber.vendor.serviceImpl;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.hyber.vendor.repository.VendorOldRegRepo;
import com.hyber.vendor.repository.dataentity.VendorOldReg;
import com.hyber.vendor.service.VendorEmailService;

@Service
public class VendorEmailServiceImpl implements VendorEmailService{
	
	 @Autowired
	 private JavaMailSender emailSender;
	 
	 @Autowired
	 private VendorOldRegRepo vendorOldRegRepo;
	 	
	 @Override
	    public void sendEmail(String to,
	    							  String subject, 
	    							  String text) throws MessagingException {
	      
		 	MimeMessage message = emailSender.createMimeMessage();
	     
		    MimeMessageHelper helper = new MimeMessageHelper(message, true);
		    
		    helper.setFrom(new InternetAddress("NoReply@Hyber.com"));
		    helper.setTo(to);
		    helper.setSubject(subject);
		    helper.setText(text, true);

		    emailSender.send(message);
	    }

	@Override
	public String textOfThemail(VendorOldReg vendorReg) throws Exception {
		String emailBody = "<html>" +
							"<h1>" +
							"Welcome " + vendorReg.getFirstName() + " ...!" +
							"</h1>" +
							"</br>" +
							"<h3>" +
							"Your Registration is Successful...Continue Using Services" +
							"</h3>" +
							"</html>";
		return emailBody;
	}

	@Override
	public void prepareAndCallSendEmail(String vendorRegId) {
		VendorOldReg vendorReg = vendorOldRegRepo.getById(Integer.parseInt(vendorRegId));
		
		String subject = "Vendor Registration Successfull-Hyber";
		
		try {
			/*-Hard coading gmail...will be taken from vendorlist after adding to entity-*/
			sendEmail("shareef0508@gmail.com", subject, textOfThemail(vendorReg));
		} catch (Exception e) {
			throw new RuntimeException("Error at sendEmail : "+ e.getLocalizedMessage());
		}
	}

}
