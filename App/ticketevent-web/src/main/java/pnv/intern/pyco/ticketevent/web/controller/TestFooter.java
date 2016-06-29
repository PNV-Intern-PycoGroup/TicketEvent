package pnv.intern.pyco.ticketevent.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pnv.intern.pyco.ticketevent.entity.AccountEntity;
import pnv.intern.pyco.ticketevent.services.AccountService;
import pnv.intern.pyco.ticketevent.services.EmailServices;


@Controller
public class TestFooter {
	@Autowired
	private EmailServices email;
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String test(ModelMap model) {
		AccountEntity account = accountService.getAccountbyUserName(SecurityContextHolder.getContext().getAuthentication().getName());
		model.put("account", account);
		return "index";
	}
	
	
	@RequestMapping(value = "sentEmail", method = RequestMethod.POST)
	public String sentTest(String emailTo){
		email.sentEmailCreateEvent("phamyqb@gmail.com");
		return "index";
	}
	
	@RequestMapping(value = "accountapi", method= RequestMethod.GET)
	public AccountEntity getAccount(){
		return accountService.getAccount(1);
	}
}
