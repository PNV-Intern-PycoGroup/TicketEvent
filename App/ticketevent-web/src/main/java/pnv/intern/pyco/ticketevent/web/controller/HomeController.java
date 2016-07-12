package pnv.intern.pyco.ticketevent.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
		model.addAttribute("layout", "none");
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
	
	@RequestMapping(value = "/editProfile", method = RequestMethod.POST)
	public @ResponseBody void editProfile(@ModelAttribute("account") AccountUserInfoModel account, Model model, @RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException{

		UserInformationEntity userInfor = userInfoService.handleBeforeEditProfile(account);
        if (!file.isEmpty()) {
            HttpSession session = request.getSession();
            ServletContext sc = session.getServletContext();
            String imagePath = sc.getRealPath("/") + "resources/images/";

            File theDir = new File(imagePath);
            if (!theDir.exists()) {
                boolean isCreated = false;

                try {
                    theDir.mkdir();
                    isCreated = true;
                } catch (SecurityException se) {
                }
                if (isCreated) {
                }
            }
            InputStream inputStream = null;
            OutputStream outputStream = null;
            if (file.getSize() > 0) {
                inputStream = file.getInputStream();
                File newFile = new File(imagePath + file.getOriginalFilename());
                if (!newFile.exists()) {
                    newFile.createNewFile();
                }
                outputStream = new FileOutputStream(imagePath
                        + file.getOriginalFilename());
                int readBytes = 0;
                byte[] buffer = new byte[8192];
                while ((readBytes = inputStream.read(buffer, 0, 8192)) != -1) {
                    outputStream.write(buffer, 0, readBytes);
                }
                outputStream.close();
                inputStream.close();
                userInfor.setAvatar(file.getOriginalFilename());
            }
        }
        userInfoService.saveUserInfor(userInfor);
	}
	
//	@RequestMapping(value = "/editProfile", method = RequestMethod.POST)
//	public String editProfile(@ModelAttribute("account") AccountUserInfoModel account, Model model, @RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException{
//
//		UserInformationEntity userInfor = userInfoService.handleBeforeEditProfile(account);
//        if (!file.isEmpty()) {
//            HttpSession session = request.getSession();
//            ServletContext sc = session.getServletContext();
//            String imagePath = sc.getRealPath("/") + "resources/images/";
//
//            File theDir = new File(imagePath);
//            if (!theDir.exists()) {
//                boolean isCreated = false;
//
//                try {
//                    theDir.mkdir();
//                    isCreated = true;
//                } catch (SecurityException se) {
//                }
//                if (isCreated) {
//                }
//            }
//            InputStream inputStream = null;
//            OutputStream outputStream = null;
//            if (file.getSize() > 0) {
//                inputStream = file.getInputStream();
//                File newFile = new File(imagePath + file.getOriginalFilename());
//                if (!newFile.exists()) {
//                    newFile.createNewFile();
//                }
//                outputStream = new FileOutputStream(imagePath
//                        + file.getOriginalFilename());
//                int readBytes = 0;
//                byte[] buffer = new byte[8192];
//                while ((readBytes = inputStream.read(buffer, 0, 8192)) != -1) {
//                    outputStream.write(buffer, 0, readBytes);
//                }
//                outputStream.close();
//                inputStream.close();
//                userInfor.setAvatar(file.getOriginalFilename());
//            }
//        }
//        userInfoService.saveUserInfor(userInfor);
//        return "/";
//	}

	@RequestMapping(value = "/create-event-theme-activity", method = RequestMethod.POST)
	public String createEventThemeActivityPost(String layout, Model model, HttpServletResponse response) {
		if ("free".equals(layout)) {
			return "create_theme_free_style";
		}else if ("music".equals(layout)) {
			return "create_theme_music";
		}else if ("study".equals(layout)) {
			return "create_theme_study";
		}
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		return "";
	}
}
