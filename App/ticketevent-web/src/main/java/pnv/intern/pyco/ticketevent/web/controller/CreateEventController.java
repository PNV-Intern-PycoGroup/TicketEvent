package pnv.intern.pyco.ticketevent.web.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pnv.intern.pyco.ticketevent.repository.entity.EventEntity;
import pnv.intern.pyco.ticketevent.repository.entity.EventTypeEntity;
import pnv.intern.pyco.ticketevent.services.model.EventModel;
import pnv.intern.pyco.ticketevent.web.util.FileUtil;
import pnv.intern.pyco.ticketevent.web.util.NonDataConstantUtil;

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
		@SuppressWarnings("deprecation")
		EventEntity event = new EventEntity(1l, "abc", new EventTypeEntity(1l, "no"), null, null, new Date(116, 11, 11, 10, 0),
				new Date(116, 10, 12, 9, 30), new Date(116, 11, 25, 15, 30), "47 Nguyễn Văn Đậu, Bình Thạnh, TP Hồ Chí Minh",
				"", "", "", "", 1, 0, "");
		model.addAttribute("event", event);
		ArrayList<EventTypeEntity> listEventType = new ArrayList<EventTypeEntity>();
		listEventType.add(new EventTypeEntity(1l, "no"));
		listEventType.add(new EventTypeEntity(2l, "no1"));
		listEventType.add(new EventTypeEntity(3l, "no2"));
		model.addAttribute("listEventType", listEventType);
		model.addAttribute("listCityInVietNam", NonDataConstantUtil.LIST_CITY_VIETNAM);
		model.addAttribute("listHours", NonDataConstantUtil.LIST_HOURS);
		
		return "event-theme/create_event_step_one";
	}

	@RequestMapping(value = "/create-event-step-two", method = RequestMethod.POST, headers ="content-type=application/json")
	public String createEventStepTwoPost(@RequestBody EventModel eventModel, Model model) {
		System.out.println(eventModel.getName());
//		System.out.println(event.getIntroduction());
//		System.out.println(event.getEndDate());
//		System.out.println(event.getStartDate());
//		System.out.println(event.getIntroduction());
//		System.out.println(event.getPlace());
//		System.out.println(event.getEventType());
//		System.out.println(event.getImageThumbnail());
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
