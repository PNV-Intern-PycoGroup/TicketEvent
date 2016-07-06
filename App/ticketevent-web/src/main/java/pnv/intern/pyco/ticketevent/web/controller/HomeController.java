package pnv.intern.pyco.ticketevent.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pnv.intern.pyco.ticketevent.entity.AccountEntity;
import pnv.intern.pyco.ticketevent.services.AccountService;
import pnv.intern.pyco.ticketevent.services.EmailServices;
import pnv.intern.pyco.ticketevent.services.model.UserModel;

@Controller
public class HomeController {
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
	
	@RequestMapping(value = "/api/{name}", method = RequestMethod.GET)
	public @ResponseBody boolean getAll(@PathVariable("name") String username){
		return accountService.findUser(username);
	}

	@RequestMapping(value = "sentEmail", method = RequestMethod.POST)
	public String sentTest(String emailTo) {
		email.sentEmailCreateEvent("phamyqb@gmail.com");
		return "index";
	}
	
	
	@RequestMapping(value = "add-user", method = RequestMethod.GET)
	public String addAnUserGet(Model model){
		UserModel user = new UserModel();
		model.addAttribute("user", user);
		return "input";
	}
	
	@RequestMapping(value = "/add-user", consumes = "application/x-www-form-urlencoded", method = RequestMethod.POST)
	public String addAnUser(@ModelAttribute @Validated UserModel user, BindingResult result, Model model) {
		System.out.print("Abc");
		if (result.hasErrors()) {
			model.addAttribute("error", "Error form");
			return "input";
		}
		model.addAttribute("user", user);
		
		return "header_layout";
	}
	
	@RequestMapping(value = "/view-event", method = RequestMethod.GET)
	public String viewEvent(Model model) {
		return "event_detail_theme_music";
	}
	
	@RequestMapping(value = "/view-event-theme-study", method = RequestMethod.GET)
	public String viewEventThemeStudy(Model model) {
		return "event_detail_theme_study";
	}
	
	@RequestMapping(value = "/view-event-theme-activity", method = RequestMethod.GET)
	public String viewEventThemeActivity(Model model) {
		return "event_detail_theme_activity";
	}
	
	@RequestMapping(value = "/create-event-theme-activity", method = RequestMethod.GET)
	public String createEventThemeActivity(Model model) {
		return "create_theme_activity";
	}
	
	@RequestMapping(value = "/register", method= RequestMethod.POST)
	public String register(@Valid AccountEntity accountEntity, BindingResult result, 
			final RedirectAttributes redirectAttributes){
		if(result.hasErrors()){
			return "redirect: register.html?error";
		}else{
			//accountService.Save(accountEntity);
			redirectAttributes.addFlashAttribute("message","Added successfully.");
			return "redirect: ?sucessful";
		}
		
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String Register(){
		return "index";
	}
}
