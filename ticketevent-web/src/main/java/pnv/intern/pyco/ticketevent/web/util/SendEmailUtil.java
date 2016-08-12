package pnv.intern.pyco.ticketevent.web.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import pnv.intern.pyco.ticketevent.services.model.EventModel;
import pnv.intern.pyco.ticketevent.services.model.TicketModel;
import pnv.intern.pyco.ticketevent.services.util.EmailConstant;

public class SendEmailUtil {
	private static Md5PasswordEncoder md5Encode = new Md5PasswordEncoder();
	
	public static boolean sendEmailFinishCreateEvent(HtmlEmail htmlEmail, String emailSendTo, EventModel event, HttpServletRequest request) {
		try {
			htmlEmail.addTo(emailSendTo);
			htmlEmail.setSubject(EmailConstant.MAIL_SUBJECT_REGISTER);
			htmlEmail.setMsg(EmailConstant.MAIL_MES_REGISTER);
			
			String htmlSendEmail = "<html><h2>Barcode cho vé trong sự kiện " + event.getName() + " của bạn</h2><br/>";
			List<TicketModel> listTicket = event.getListTicket();
			int i = 1;
			for (TicketModel ticket : listTicket) {
				String ticketNameMd5Code = md5Encode.encodePassword(ticket.getName(), NonDataConstantUtil.BARCODE_CREATE_TICKET);
				String ticketEncode = EncryptionUtil.encodeId(ticket.getId());
				String eventEncode = EncryptionUtil.encodeId(event.getId());
				htmlSendEmail += "	<h3>" + i + ". Vé " + ticket.getName() + " </h3>";
				htmlSendEmail += "	<img height=\"200px\" width=\"200px\" alt=\"My Image\" src=\"http://localhost:8080/ticketevent-web/resources/images/barcode/event/" + eventEncode + "/ticket/" + ticketNameMd5Code + ticketEncode + ".png\"><br/>";
				i++;
			}
			htmlSendEmail += "</html>";

			htmlEmail.setHtmlMsg(htmlSendEmail);
			htmlEmail.send();
		} catch (EmailException e) {
			return false;
		}
		return true;
	}
}
