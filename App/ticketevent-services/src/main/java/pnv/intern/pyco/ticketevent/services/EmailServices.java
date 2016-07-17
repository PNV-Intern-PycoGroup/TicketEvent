package pnv.intern.pyco.ticketevent.services;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

import pnv.intern.pyco.ticketevent.services.util.EmailConstant;

@Service
public class EmailServices {
	
	private Email email;
	
	public EmailServices(){};
	
	public void sentEmailCreateEvent(String emailTo){
		try {
			email = new SimpleEmail();
			email.setCharset("utf-8");
			email.setHostName(EmailConstant.MAIL_HOST);
			email.setSmtpPort(EmailConstant.MAIL_POST);
			email.setSSLOnConnect(true);
			email.setAuthentication(EmailConstant.MY_EMAIL, EmailConstant.MY_PASSWORD);
			email.setFrom(EmailConstant.MY_EMAIL);
			
			email.addTo(emailTo);
			email.setSubject(EmailConstant.MAIL_SUBJECT_CREATE_EVENT);
			email.setMsg(EmailConstant.MAIL_MES_CREATE_EVENT);
			email.send();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	public void sentEmailRegister(String emailTo){
		try {
			email = new SimpleEmail();
			email.setCharset("utf-8");
			email.setHostName(EmailConstant.MAIL_HOST);
			email.setSmtpPort(EmailConstant.MAIL_POST);
			email.setSSLOnConnect(true);
			email.setAuthentication(EmailConstant.MY_EMAIL, EmailConstant.MY_PASSWORD);
			email.setFrom(EmailConstant.MY_EMAIL);
			
			email.addTo(emailTo);
			email.setSubject(EmailConstant.MAIL_SUBJECT_REGISTER);
			email.setMsg(EmailConstant.MAIL_MES_REGISTER);
			email.send();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
