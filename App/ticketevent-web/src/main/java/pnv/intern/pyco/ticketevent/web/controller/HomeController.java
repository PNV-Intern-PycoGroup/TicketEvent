package pnv.intern.pyco.ticketevent.web.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pnv.intern.pyco.ticketevent.repository.entity.AccountEntity;
import pnv.intern.pyco.ticketevent.repository.entity.UserInformationEntity;
import pnv.intern.pyco.ticketevent.services.AccountService;
import pnv.intern.pyco.ticketevent.services.UserInformationService;
import pnv.intern.pyco.ticketevent.services.model.AccountUserInfoModel;
import pnv.intern.pyco.ticketevent.web.util.FileUtil;

@Controller
public class HomeController {
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private UserInformationService userInfoService;

	@Autowired
    private HttpServletRequest request;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String test(ModelMap model) {
		AccountEntity account = accountService.getAccountbyUserName(SecurityContextHolder.getContext().getAuthentication().getName());
		if(account != null){
			AccountUserInfoModel acc = accountService.getAccInfor(account.getId());
			model.put("account", acc);
		}
		return "index";
	}
	
	@RequestMapping(value = "/api/{name}", method = RequestMethod.GET)
	public @ResponseBody boolean getAll(@PathVariable("name") String username){
		return accountService.findUser(username);
	}
	
	@RequestMapping(value = "/view-event-theme-music", method = RequestMethod.GET)
	public String viewEvent(Model model) {
		return "event-theme/music/event_detail_theme_music";
	}
	
	@RequestMapping(value = "/view-event-theme-study", method = RequestMethod.GET)
	public String viewEventThemeStudy(Model model) {
		return "event-theme/study/event_detail_theme_study";
	}
	
	@RequestMapping(value = "/view-event-theme-activity", method = RequestMethod.GET)
	public String viewEventThemeActivity(Model model) {
		return "event-theme/activity/event_detail_theme_activity";
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
	
	@RequestMapping(value = "/editProfile", method = RequestMethod.POST, headers ="content-type=application/json")
	public @ResponseBody String editProfile(@RequestBody AccountUserInfoModel account, Model model,  HttpServletRequest request) throws IOException{

		
		UserInformationEntity userInfor = userInfoService.handleBeforeEditProfile(account);
		
        if (!account.getAvatar().isEmpty()) {
        	if(!account.getFilenameAvatar().isEmpty()){
        	String image = account.getAvatar().split(",")[1];
        	HttpSession session = request.getSession();
    		ServletContext sc = session.getServletContext();
    		
    		String nameImage = userInfor.getAccount().getUserName() + ".jpg";
    		String imagePath = FileUtil.createPath(sc.getRealPath("/") + "resources/images/avatar/") + nameImage;
    		
    		FileUtil.saveImageOnServerBase64(image, imagePath);
               userInfor.setAvatar(nameImage);
        	}
           }
        userInfoService.saveUserInfor(userInfor);
		return "updateSuccess";
	}
}
