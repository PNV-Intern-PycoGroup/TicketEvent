package pnv.intern.pyco.ticketevent.services;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

import pnv.intern.pyco.ticketevent.services.constants.EmailConstant;

@Service
public class EmailServices {
	
	private EmailServices emailService;
	private Email email;
	
	public EmailServices(){};
	
	public EmailServices(EmailServices emailService) {
		this.emailService = emailService;
	}
	
	public void sentEmailCreateEvent(String emailTo){
		try {
			email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthentication(EmailConstant.MY_EMAIL, EmailConstant.MY_PASSWORD);
			email.setFrom(EmailConstant.MY_EMAIL);
			email.addTo(emailTo);
			email.setSSLOnConnect(true);
			email.setSubject("Create Event Success");
			email.setMsg("Chúc mừng bạn đã tạo thành công sự kiện");
			email.send();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
