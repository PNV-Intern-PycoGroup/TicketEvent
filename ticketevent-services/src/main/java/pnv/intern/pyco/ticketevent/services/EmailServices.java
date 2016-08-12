package pnv.intern.pyco.ticketevent.services;

import java.net.MalformedURLException;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pnv.intern.pyco.ticketevent.repository.MailConfigRepository;
import pnv.intern.pyco.ticketevent.repository.entity.MailConfigEntity;
import pnv.intern.pyco.ticketevent.services.converter.MailConfigConverter;
import pnv.intern.pyco.ticketevent.services.model.EventModel;
import pnv.intern.pyco.ticketevent.services.model.MailConfigModel;
import pnv.intern.pyco.ticketevent.services.util.EmailConstant;

@Service
public class EmailServices {

	@Autowired
	private MailConfigRepository mailConfigRepository;

	public EmailServices() {
	};

	public void sentEmailCreateEvent(String emailTo) throws EmailException {
		SimpleEmail simpleEmail = configSimpleEmailBeforeSend();
		simpleEmail.addTo(emailTo);
		simpleEmail.setSubject(EmailConstant.MAIL_SUBJECT_CREATE_EVENT);
		simpleEmail.setMsg(EmailConstant.MAIL_MES_CREATE_EVENT);
		simpleEmail.send();
	}
	
	public void sentTestEmail(String emailTo, String content) throws EmailException{
		SimpleEmail simpleEmail = configSimpleEmailBeforeSend();
		simpleEmail.addTo(emailTo);
		simpleEmail.setSubject("Email Test TicketEvent System");
		simpleEmail.setMsg(content);
		simpleEmail.send();
	}
	
	public SimpleEmail configSimpleEmailBeforeSend() throws EmailException {
		MailConfigEntity mEntity = mailConfigRepository.findOne((long) 1);
		SimpleEmail simleEmail = null;
		if(mEntity != null){
			simleEmail = new SimpleEmail();
			simleEmail.setCharset("utf-8");
			simleEmail.setHostName(mEntity.getMailHost());
			simleEmail.setSmtpPort(mEntity.getMailPort());
			simleEmail.setSSLOnConnect(true);
			simleEmail.setAuthentication(mEntity.getUserName(), mEntity.getEmailPass());
			simleEmail.setFrom(mEntity.getUserName());
		}
		return simleEmail;
	}
	
	public HtmlEmail configHtmlEmailBeforeSend() throws EmailException {
		MailConfigEntity mEntity = mailConfigRepository.findOne((long) 1);
		HtmlEmail htmlEmail = null;
		if(mEntity != null){
			htmlEmail = new HtmlEmail();
			htmlEmail.setCharset("utf-8");
			htmlEmail.setHostName(mEntity.getMailHost());
			htmlEmail.setSmtpPort(mEntity.getMailPort());
			htmlEmail.setSSLOnConnect(true);
			htmlEmail.setAuthentication(mEntity.getUserName(), mEntity.getEmailPass());
			htmlEmail.setFrom(mEntity.getUserName());
		}
		return htmlEmail;
	}

	public void sentEmailRegister(String emailTo, String path) throws EmailException, MalformedURLException {
			HtmlEmail hemail = configHtmlEmailBeforeSend();
			hemail.addTo(emailTo);
			hemail.setSubject(EmailConstant.MAIL_SUBJECT_REGISTER);
			hemail.setMsg(EmailConstant.MAIL_MES_REGISTER);
			
		  hemail.setHtmlMsg("<html><img style=\"width:200px; height:100px\" src=\"https://s9.postimg.org/4j1fmochb/logo2.png\">"
			  		+ "<br><br>"+EmailConstant.MAIL_MES_REGISTER
			  		+ "<br> Vui lòng click vào đường link này để kích hoạt tài khoản của bạn: <a href="+path+">"+path+"</a>"
			  		+ "</html>");

			hemail.send();
	}

	public void sendEmailDeleteEventNotAccept(String emailTo, EventModel eventModel, String content) throws EmailException {
		SimpleEmail simpleEmail = configSimpleEmailBeforeSend();
		simpleEmail.addTo(emailTo);
		simpleEmail.setSubject("THÔNG BÁO HỦY SỰ KIỆN");
		simpleEmail.setMsg("Xin chào quý khách: "
					+ eventModel.getAccount().getUserName() + "\n Sự kiện: "
					+ eventModel.getName() + " của bạn vừa tạo ngày: "
					+ eventModel.getCreateDate()
					+ "\n không được chấp nhận vì lí do: \n " + content);
		simpleEmail.send();
	}
	
	public void changeSystemConfig(MailConfigModel mailConfigModel){
		MailConfigEntity mailConfigEntity = MailConfigConverter.convertToEntity(mailConfigModel);
		mailConfigRepository.saveAndFlush(mailConfigEntity);
	}
	
	public MailConfigModel getMailConfigModel(){
		MailConfigModel mailConfigModel = null;
		MailConfigEntity mailConfigEntity = mailConfigRepository.findOne((long) 1);
		if(mailConfigEntity != null){
			mailConfigModel = MailConfigConverter.convertFromEntityToDTO(mailConfigEntity);
		}
		return mailConfigModel;
	}
}
