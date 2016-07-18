package pnv.intern.pyco.ticketevent.web.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pnv.intern.pyco.ticketevent.services.EventService;
import pnv.intern.pyco.ticketevent.services.EventTypeService;
import pnv.intern.pyco.ticketevent.services.model.EventModel;
import pnv.intern.pyco.ticketevent.services.model.EventTypeModel;
import pnv.intern.pyco.ticketevent.web.util.FileUtil;
import pnv.intern.pyco.ticketevent.web.util.NonDataConstantUtil;

@Controller
public class CreateEventController {

	@Autowired
    private HttpServletRequest request;

	@Autowired
	private EventService eventService;
	
	@Autowired
	private EventTypeService eventTypeService;

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
			model.addAttribute("error", "error");
			return "error/response_ajax_error";
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
		/*if ("free".equals(layout)) {
			return "event-theme/free/create_theme_free";
		}else if ("music".equals(layout)) {
			return "event-theme/music/create_theme_music";
		}else if ("study".equals(layout)) {
			return "event-theme/study/create_theme_study";
		}else if ("activity".equals(layout)) {
			return "event-theme/activity/create_theme_activity";
		}*/
		/*model.addAttribute("error", "error");
		return "error/response_ajax_error";*/
		return "event-theme/music/create_theme_music";
	}

	@RequestMapping(value = "/create-event-step-one", method = RequestMethod.GET)
	public String createEventStepOne(Model model) {
		
		ArrayList<EventTypeModel> listEventType = eventTypeService.getAllEventType();
		model.addAttribute("listEventType", listEventType);
		model.addAttribute("listCityInVietNam", NonDataConstantUtil.LIST_CITY_VIETNAM);
		model.addAttribute("listHours", NonDataConstantUtil.LIST_HOURS);
		
		return "event-theme/create_event_step_one";
	}

	@RequestMapping(value = "/create-event-step-two", method = RequestMethod.POST)
	public String createEventStepTwoPost(@RequestBody EventModel event, Model model) {
//		if (eventService.isExitEvent(event.getId(), SecurityContextHolder.getContext().getAuthentication().)) {
//			
//		}
		if (event.getId() == null) {
			eventService.saveEvent(event);
		}else{
			eventService.updateEvent(event);
		}
		return "event-theme/create_event_step_two";
	}

	@RequestMapping(value = "/create-event-last-step", method = RequestMethod.POST)
	public String createEventLastStepPost(String layout, Model model, HttpServletResponse response) {
		
//		model.addAttribute("error", "error");
//		return "error/response_ajax_error";
		return "event-theme/create_event_last_step";
	}

	@RequestMapping(value = "/create-event-finish", method = RequestMethod.POST)
	public String createEventFinishPost(String layout, Model model, HttpServletResponse response) {
		
//		model.addAttribute("error", "error");
//		return "error/response_ajax_error";
		return "event-theme/create_event_last_step";
	}
	
}
