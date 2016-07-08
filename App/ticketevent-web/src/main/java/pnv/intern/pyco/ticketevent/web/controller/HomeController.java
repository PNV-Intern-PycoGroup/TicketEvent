package pnv.intern.pyco.ticketevent.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pnv.intern.pyco.ticketevent.repository.entity.AccountEntity;
import pnv.intern.pyco.ticketevent.services.AccountService;
import pnv.intern.pyco.ticketevent.web.util.FileUtil;

@Controller
public class HomeController {
	
	@Autowired
	private AccountService accountService;

	@Autowired
    private HttpServletRequest request;

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
			accountService.Save(accountEntity);
			redirectAttributes.addFlashAttribute("message","Added successfully.");
			return "redirect: ?sucessful";
		}
		
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String Register(){
		return "index";
	}
	
	@RequestMapping(value = "/upload-file", method = RequestMethod.POST)
	public void createUploadFile(String file) {
		
		if (file == null) {
			return;
		}

		String base64Img = file.split(",")[1];
		String filePath = request.getServletContext().getRealPath("/resources/");
		String expectPath = filePath + "/images";
		
        String fullPath = FileUtil.getRealPath(expectPath);
		FileUtil.saveImageOndisk(base64Img, fullPath);
	}
	
	@ResponseBody
	@RequestMapping(value = "/upload-file-free-style", method = RequestMethod.POST)
	public String createUploadFileFreeStyle(String file) {
		
		if (file == null) {
			return "error";
		}
		
		String base64Img = file.split(",")[1];
		String filePath = request.getServletContext().getRealPath("/resources");
		String expectPath = filePath + "/images";
        String fullPath = FileUtil.getRealPath(expectPath);
		FileUtil.saveImageOndisk(base64Img, fullPath);
		
		return "http://localhost:8080/ticketevent-web" + fullPath.split("ticketevent-web")[1];
	}
	
}
