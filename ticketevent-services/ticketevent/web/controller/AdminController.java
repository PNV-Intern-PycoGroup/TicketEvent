package pnv.intern.pyco.ticketevent.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	@RequestMapping(value = "admin-page", method= RequestMethod.GET)
	public String displayAdminPage(){
		return "admin_home_page";
	}
	
	@RequestMapping(value = "mail-inbox", method= RequestMethod.GET)
	public String mailBoxAdmin(){
		return "admin_mail_inbox";
	}
}
