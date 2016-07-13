package pnv.intern.pyco.ticketevent.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pnv.intern.pyco.ticketevent.web.util.FileUtil;

@Controller
public class CreateEventController {

	@Autowired
    private HttpServletRequest request;

	
	@RequestMapping(value = "/create-event", method = RequestMethod.GET)
	public String createEventThemeActivity(Model model) {
		model.addAttribute("layout", "none");
		return "event-theme/create_event";
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
		FileUtil.saveImageOnServerBase64(base64Img, fullPath);
	}
	
	@ResponseBody
	@RequestMapping(value = "/upload-file-free-style", method = RequestMethod.POST)
	public String createUploadFileFreeStyle(String file, Model model, HttpServletResponse response) {
		
		if (file == null) {
			model.addAttribute("error", "Tải lên thất bại. Vì dung lượng ảnh tải lên vượt quá 2MB!");
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "response_ajax_error";
		}
		
		String base64Img = file.split(",")[1];
		String filePath = request.getServletContext().getRealPath("/resources");
		String expectPath = filePath + "/images";
        String fullPath = FileUtil.getRealPath(expectPath);
		FileUtil.saveImageOnServerBase64(base64Img, fullPath);
		
		return "http://localhost:8080/ticketevent-web" + fullPath.split("ticketevent-web")[1];
	}

	@RequestMapping(value = "/create-event-upload-image", method = RequestMethod.POST)
	public String createEventThemeActivityPost(String layout, Model model, HttpServletResponse response) {
		if ("free".equals(layout)) {
			return "event-theme/free/create_theme_free";
		}else if ("music".equals(layout)) {
			return "event-theme/music/create_theme_music";
		}else if ("study".equals(layout)) {
			return "event-theme/study/create_theme_study";
		}else if ("activity".equals(layout)) {
			return "event-theme/activity/create_theme_activity";
		}
		model.addAttribute("error", "error");
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		return "error/response_ajax_error";
	}

	@RequestMapping(value = "/create-event-step-two", method = RequestMethod.POST)
	public String createEventStepTwoPost(String layout, Model model, HttpServletResponse response) {
		/*if ("free".equals(layout)) {
			return "event-theme/free/create_theme_free";
		}else if ("music".equals(layout)) {
			return "event-theme/music/create_theme_music";
		}else if ("study".equals(layout)) {
			return "event-theme/study/create_theme_study";
		}else if ("activity".equals(layout)) {
			return "event-theme/activity/create_theme_activity";
		}
		model.addAttribute("error", "error");
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		return "response_ajax_error";*/
		return "event-theme/create_event_step_two";
	}
	
}
