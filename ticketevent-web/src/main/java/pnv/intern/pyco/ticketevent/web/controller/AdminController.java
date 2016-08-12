package pnv.intern.pyco.ticketevent.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pnv.intern.pyco.ticketevent.CusAuthenticationProvider;
import pnv.intern.pyco.ticketevent.services.AccountService;
import pnv.intern.pyco.ticketevent.services.EmailServices;
import pnv.intern.pyco.ticketevent.services.EventService;
import pnv.intern.pyco.ticketevent.services.model.AccountModel;
import pnv.intern.pyco.ticketevent.services.model.EventModel;
import pnv.intern.pyco.ticketevent.services.model.MailConfigModel;

@Controller
public class AdminController {
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private EmailServices emailServices;
	
	private List<AccountModel> listAllUser;
	private AccountModel account;
	
	@RequestMapping(value = "admin/admin-page", method= RequestMethod.GET)
	public String displayAdminPage(ModelMap model){
		account = accountService.getAccountModelByAuthencated();
		
		if(account != null){
			listAllUser = accountService.getAllAccountModelUser();
			List<AccountModel> accountModels = accountService.getLastestMember();
			List<EventModel> eventModels = eventService.getLastestEvent();
			model.put("account", account);
			model.put("listAllUser", listAllUser.size());
			model.put("newLastestMember", accountModels);
			model.put("lastestEvent", eventModels);
		}
		return "admin/home_page";
	}
	
	@RequestMapping(value = "admin/config-system", method = RequestMethod.POST)
	public @ResponseBody String configSystem(@RequestBody MailConfigModel mailConfigModel){
		emailServices.changeSystemConfig(mailConfigModel);
		return "";
	}
	
	@RequestMapping(value="admin/sendTestEmail", method = RequestMethod.POST)
	public @ResponseBody String sendTestEmail(@RequestBody String[] object){
		if(object.length != 0){
			try {
				emailServices.sentTestEmail(object[0], object[1]);
			} catch (EmailException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@RequestMapping(value = "admin/getMailConfig", method = RequestMethod.GET)
	public @ResponseBody MailConfigModel getConfigSystem(){
		MailConfigModel mailConfigModel = emailServices.getMailConfigModel();
		return mailConfigModel;
	}

	
	@RequestMapping(value = "admin/setAccountActive/{id}/{type}", method = RequestMethod.GET)
	public @ResponseBody String editAccount(@PathVariable("id") long id, @PathVariable("type") int type){
		accountService.setActive(id, type);
		return null;
	}
	
	
	@RequestMapping(value = "admin/user-management", method = RequestMethod.GET)
	public String getRunbookPage(ModelMap model) {
		account = accountService.getAccountModelByAuthencated();
		if(account != null){
		List<AccountModel> accountModels = accountService.getAllAccountModel();
	    model.put("account", account);
	    model.put("listAllAccount", accountModels);
		}
	    return "admin/user_management";
	}
	
	@RequestMapping(value = "admin/addAdmin", method= RequestMethod.POST)
	public @ResponseBody String addNewAdmin(@RequestBody AccountModel accountModel, HttpServletRequest request){
		if(accountModel != null){
			//String path = request.getRequestURL().toString();
			accountService.saveAdminAccount(accountModel);
		}
		return null;
	}
	
	
	@RequestMapping(value = "login/{urlRedirect}", method = RequestMethod.GET)
	public String login(@PathVariable String urlRedirect, ModelMap model){
		String convertUrl = urlRedirect.replace("+", "/");
		AccountModel account = accountService.getAccountModelByAuthencated();
		if (account != null) {
			return "redirect: /ticketevent-web/" + convertUrl;
		}
		model.addAttribute("urlRedirect", urlRedirect);
		return "error/login_not_yet";
	}
	
	@RequestMapping(value = "login/{urlRedirect}", method = RequestMethod.POST)
	public String loginNotYet(@PathVariable String urlRedirect, AccountModel accountModel, ModelMap model){
		String convertUrl = urlRedirect.replace("+", "/");
		AccountModel accountGetFromData = accountService.checkLoginForm(accountModel);
		if (accountGetFromData != null) {
		    saveAuthentication(accountGetFromData);
			return "redirect: /ticketevent-web/" + convertUrl;
		}
		model.addAttribute("error", "error");
		return "error/login_not_yet";
	}
	
	private void saveAuthentication(AccountModel account) {
		AuthenticationManager authenticationManager = new ProviderManager(Arrays.asList((AuthenticationProvider) new CusAuthenticationProvider()));
		List<GrantedAuthority> grantedAuths = new ArrayList<>();
        grantedAuths.add(new SimpleGrantedAuthority(account.getUserRole().getRole()));
		Authentication user = new UsernamePasswordAuthenticationToken(account.getUserName(), account.getPassword(), grantedAuths);
		Authentication result = authenticationManager.authenticate(user);
        SecurityContextHolder.getContext().setAuthentication(result);
	}
}
