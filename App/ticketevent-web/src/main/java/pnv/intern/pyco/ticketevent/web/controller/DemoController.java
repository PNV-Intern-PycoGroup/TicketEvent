package pnv.intern.pyco.ticketevent.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pnv.intern.pyco.ticketevent.services.model.UserModel;

@Controller
public class DemoController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String helloWorld(@ModelAttribute("user") UserModel users, Model model) {
		//UserModel user = demoService.getUser();
		model.addAttribute("languageUrl", "");
		model.addAttribute("user", users);
		
		return "header_layout";
	}
	
	@RequestMapping(value = "/get-user/{name}", method = RequestMethod.GET)
	public String getAnUser(@PathVariable String name, Model model) {
		UserModel user = new UserModel(name, 22, "Da Nang");
		
		model.addAttribute("user", user);
		
		return "header_layout";
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
		model.addAttribute("languageUrl", "");
		
		return "event_detail_theme_music";
	}
	
	@RequestMapping(value = "/view-event-theme-study", method = RequestMethod.GET)
	public String viewEventThemeStudy(Model model) {
		model.addAttribute("languageUrl", "");
		
		return "event_detail_theme_study";
	}
	
	@RequestMapping(value = "/view-event-theme-activity", method = RequestMethod.GET)
	public String viewEventThemeActivity(Model model) {
		model.addAttribute("languageUrl", "");
		
		return "event_detail_theme_activity";
	}
}
