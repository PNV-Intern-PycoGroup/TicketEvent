package pnv.intern.pyco.ticketevent.web.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pnv.intern.pyco.ticketevent.services.SmtpMailSender;

@Controller
public class AdminController {
	@Autowired
	private SmtpMailSender mailSender;
	
	@RequestMapping(value = "admin-page", method= RequestMethod.GET)
	public String displayAdminPage(){
		return "admin/admin_home_page";
	}
	
	@RequestMapping(value = "user-management", method= RequestMethod.GET)
	public String UserByAdmin(){
		return "admin/admin_user_manage";
	}
	
	@RequestMapping(value = "admin-comment-manage", method= RequestMethod.GET)
	public String commentAdmin(){
		return "admin/admin_comment_manage";
	}
	
	
	
	@RequestMapping(value = "send-mail", method = RequestMethod.GET)
	public String sendMail() throws MessagingException{
		mailSender.send("phamyqb@gmail.com", "hello", "Chúc mừng bạn đã đăng kí thành công");
		return "index";
	}
	
	
}
