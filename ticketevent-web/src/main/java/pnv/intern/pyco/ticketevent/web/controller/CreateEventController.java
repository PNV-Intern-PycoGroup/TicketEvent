package pnv.intern.pyco.ticketevent.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pnv.intern.pyco.ticketevent.services.AccountService;
import pnv.intern.pyco.ticketevent.services.EmailServices;
import pnv.intern.pyco.ticketevent.services.EventLayoutService;
import pnv.intern.pyco.ticketevent.services.EventService;
import pnv.intern.pyco.ticketevent.services.EventTypeService;
import pnv.intern.pyco.ticketevent.services.TicketService;
import pnv.intern.pyco.ticketevent.services.layout.activity.ActivityLayoutImageLibraryService;
import pnv.intern.pyco.ticketevent.services.layout.activity.ActivityLayoutService;
import pnv.intern.pyco.ticketevent.services.layout.course.CourseLayoutContentService;
import pnv.intern.pyco.ticketevent.services.layout.course.CourseLayoutService;
import pnv.intern.pyco.ticketevent.services.layout.course.CourseLayoutSpeakerService;
import pnv.intern.pyco.ticketevent.services.layout.free.FreeLayoutImageLibraryService;
import pnv.intern.pyco.ticketevent.services.layout.free.FreeLayoutService;
import pnv.intern.pyco.ticketevent.services.layout.music.MusicLayoutFamousPersonService;
import pnv.intern.pyco.ticketevent.services.layout.music.MusicLayoutImageLibraryService;
import pnv.intern.pyco.ticketevent.services.layout.music.MusicLayoutService;
import pnv.intern.pyco.ticketevent.services.model.AccountModel;
import pnv.intern.pyco.ticketevent.services.model.EventLayoutModel;
import pnv.intern.pyco.ticketevent.services.model.EventModel;
import pnv.intern.pyco.ticketevent.services.model.EventTypeModel;
import pnv.intern.pyco.ticketevent.services.model.TicketModel;
import pnv.intern.pyco.ticketevent.services.model.layout.activity.ActivityLayoutImageLibraryModel;
import pnv.intern.pyco.ticketevent.services.model.layout.activity.ActivityLayoutModel;
import pnv.intern.pyco.ticketevent.services.model.layout.course.CourseLayoutContentModel;
import pnv.intern.pyco.ticketevent.services.model.layout.course.CourseLayoutModel;
import pnv.intern.pyco.ticketevent.services.model.layout.course.CourseLayoutSpeakerModel;
import pnv.intern.pyco.ticketevent.services.model.layout.free.FreeLayoutImageLibraryModel;
import pnv.intern.pyco.ticketevent.services.model.layout.free.FreeLayoutModel;
import pnv.intern.pyco.ticketevent.services.model.layout.music.MusicLayoutFamousPersonModel;
import pnv.intern.pyco.ticketevent.services.model.layout.music.MusicLayoutImageLibraryModel;
import pnv.intern.pyco.ticketevent.services.model.layout.music.MusicLayoutModel;
import pnv.intern.pyco.ticketevent.web.clientdatacontext.CreateEventContext;
import pnv.intern.pyco.ticketevent.web.util.BarCodeUtil;
import pnv.intern.pyco.ticketevent.web.util.EncryptionUtil;
import pnv.intern.pyco.ticketevent.web.util.FileUtil;
import pnv.intern.pyco.ticketevent.web.util.NonDataConstantUtil;
import pnv.intern.pyco.ticketevent.web.util.SendEmailUtil;

@Controller
public class CreateEventController {

	@Autowired
    private HttpServletRequest request;
	@Autowired
	private EmailServices emailServices;

	@Autowired
	private EventService eventService;
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private EventTypeService eventTypeService;
	
	@Autowired
	private EventLayoutService eventLayoutService;
	
	@Autowired
	private AccountService accountService;

	@Autowired
	private FreeLayoutService freeLayoutService;
	@Autowired
	private FreeLayoutImageLibraryService freeLayoutImageLibraryService;

	@Autowired
	private ActivityLayoutService activityLayoutService;
	@Autowired
	private ActivityLayoutImageLibraryService activityLayoutImageLibraryService;
	
	@Autowired
	private MusicLayoutService musicLayoutService;
	@Autowired
	private MusicLayoutImageLibraryService musicLayoutImageLibraryService;
	@Autowired
	private MusicLayoutFamousPersonService musicLayoutFamousPersonService;

	@Autowired
	private CourseLayoutService courseLayoutService;
	@Autowired
	private CourseLayoutSpeakerService courseLayoutSpeakerService;
	@Autowired
	private CourseLayoutContentService courseLayoutContentService;

	// CREATE EVENT
	@RequestMapping(value = {"/create-event", "/edit-event/{eventId}"}, method = RequestMethod.GET)
	public String createEvent(@PathVariable Map<String, String> pathVariablesMap, HttpServletResponse response) {
		AccountModel accountLogin = accountService.getAccountModelByAuthencated();
		if (pathVariablesMap.containsKey("eventId")) {
	        try {
	        	Long eventId = Long.valueOf(pathVariablesMap.get("eventId"));

				if (accountLogin == null) {
					return "redirect: /ticketevent-web/login/edit-event+" + eventId;
				}
		        EventModel event = eventService.getEventById(eventId);
		        if (event != null) {
					AccountModel accountGetFromEvent = event.getAccount();
					if (accountGetFromEvent == null || !accountGetFromEvent.getId().equals(accountLogin.getId())) {
						response.setStatus(HttpServletResponse.SC_FORBIDDEN);
						return "redirect: /ticketevent-web/error/403";
					}
				}else {
					throw new IllegalArgumentException();
				}
			} catch (IllegalArgumentException e) {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				return "redirect: /ticketevent-web/error/404";
			}
	    }else {
	    	if (accountLogin == null) {
	    		return "redirect: /ticketevent-web/login/create-event";
			}
	    }
		return "event-theme/create_event";
	}

	//// - STEP ONE
	@RequestMapping(value = {"/create-event-step-one", "/create-event-step-one/{eventId}"}, method = RequestMethod.GET)
	public String createEventStepOne(@PathVariable Map<String, String> pathVariablesMap, Model model, HttpServletResponse response) {
		AccountModel accountLogin = accountService.getAccountModelByAuthencated();
		if (accountLogin != null) {
			if (pathVariablesMap.containsKey("eventId")) {
		        try {
		        	Long eventId = Long.valueOf(pathVariablesMap.get("eventId"));
			        EventModel event = eventService.getEventById(eventId);
			        if (event != null) {
						AccountModel accountGetFromEvent = event.getAccount();
						if (accountGetFromEvent != null && accountGetFromEvent.getId().equals(accountLogin.getId())) {
							model.addAttribute("event", event);
						}else {
							response.setStatus(HttpServletResponse.SC_FORBIDDEN);
							model.addAttribute("error", "403");
							return "error/response_ajax_error";
						}
					}
				} catch (IllegalArgumentException e) {
					response.setStatus(HttpServletResponse.SC_NOT_FOUND);
					model.addAttribute("error", "404");
					return "error/response_ajax_error";
				}
		    }
			ArrayList<EventTypeModel> listEventType = eventTypeService.getAllEventType();
			model.addAttribute("listEventType", listEventType);
			model.addAttribute("listCityInVietNam", NonDataConstantUtil.LIST_CITY_VIETNAM);
			model.addAttribute("listHours", NonDataConstantUtil.LIST_HOURS);
			
			return "event-theme/create_event_step_one";
		}

		model.addAttribute("error", "loginError");
		return "error/response_ajax_error";
	}
	//// - END STEP ONE

	//// - STEP TWO
	@RequestMapping(value = "/create-event-layout", method = RequestMethod.POST)
	public String createEventLayoutPost(@RequestBody Long[] data, Model model, HttpServletResponse response) {
		Long layoutId = null;
		Long eventId = null;
		if (data.length == 2) {
			layoutId = data[0];
			eventId = data[1];
			if (layoutId == null && eventId == null) {
				model.addAttribute("error", "sendDataError");
				return "error/response_ajax_error";
			}
		}else {
			model.addAttribute("error", "sendDataError");
			return "error/response_ajax_error";
		}
		EventModel event = eventService.getEventById(eventId);
		if (event == null) {
			model.addAttribute("error", "eventNotFound");
			return "error/response_ajax_error";
		}
		ArrayList<EventLayoutModel> listEventLayout = eventLayoutService.getListEventLayout();
		EventLayoutModel eventLayout = null;
		for (EventLayoutModel eventLayoutModel : listEventLayout) {
			if (eventLayoutModel.getId().equals(layoutId)) {
				eventLayout = eventLayoutModel;
				if (event.getEventLayout() == null) {
					event.setEventLayout(eventLayout);
					eventService.updateEvent(event);
				}
			}
		}
		if (eventLayout != null) {
			String layout = eventLayout.getName();
			model.addAttribute("event", event);
			switch (layout) {
				case "Free":
					handleFreeLayoutBeforResponse(eventId, model);
					return "event-theme/free/create_theme_free";
				case "Activity":
					handleActivityLayoutBeforResponse(eventId, model);
					return "event-theme/activity/create_theme_activity";
				case "Music":
					handleMusicLayoutBeforResponse(eventId, model);
					return "event-theme/music/create_theme_music";
				case "Course":
					handleCourseLayoutBeforResponse(eventId, model);
					return "event-theme/study/create_theme_study";
				default:
					break;
			}
		}
		model.addAttribute("error", "error");
		return "error/response_ajax_error";
	}
	
	private void handleFreeLayoutBeforResponse(Long eventId, Model model) {
		FreeLayoutModel freeLayoutModel = freeLayoutService.findFreeLayoutByEventId(eventId);
		if (freeLayoutModel == null) {
			freeLayoutModel = new FreeLayoutModel();
			freeLayoutModel.setEventId(eventId);
			freeLayoutModel = freeLayoutService.save(freeLayoutModel);
		}
		model.addAttribute("freeLayoutModel", freeLayoutModel);
	}
	
	private void handleActivityLayoutBeforResponse(Long eventId, Model model) {
		ActivityLayoutModel activityLayoutModel = activityLayoutService.findActivityLayoutByEventId(eventId);
		if (activityLayoutModel == null) {
			activityLayoutModel = new ActivityLayoutModel();
			activityLayoutModel.setEventId(eventId);
			activityLayoutModel = activityLayoutService.save(activityLayoutModel);
		}
		model.addAttribute("activityLayout", activityLayoutModel);
	}
	
	private void handleMusicLayoutBeforResponse(Long eventId, Model model) {
		MusicLayoutModel musicLayoutModel = musicLayoutService.findMusicLayoutByEventId(eventId);
		if (musicLayoutModel == null) {
			musicLayoutModel = new MusicLayoutModel();
			musicLayoutModel.setEventId(eventId);
			musicLayoutModel = musicLayoutService.save(musicLayoutModel);
		}
		model.addAttribute("musicLayout", musicLayoutModel);
	}
	
	private void handleCourseLayoutBeforResponse(Long eventId, Model model) {
		CourseLayoutModel courseLayoutModel = courseLayoutService.findCourseLayoutByEventId(eventId);
		if (courseLayoutModel == null) {
			courseLayoutModel = new CourseLayoutModel();
			courseLayoutModel.setEventId(eventId);
			courseLayoutModel = courseLayoutService.save(courseLayoutModel);
		}
		model.addAttribute("courseLayout", courseLayoutModel);
	}

	@RequestMapping(value = "/create-event-step-two", method = RequestMethod.POST)
	public String createEventStepTwoPost(@RequestBody CreateEventContext eventContext, Model model, HttpServletResponse response) {
		EventModel event = eventContext.getEventModel();
		String imageThumbnailBase64 = eventContext.getImageThumbnail();
		String imageOrganizeBase64 = eventContext.getImageOrganization();
		
		if (isNullAllPropertiOfEvent(event, imageThumbnailBase64, imageOrganizeBase64)) {
			model.addAttribute("error", "eventNull");
			return "error/response_ajax_error";
		}
		AccountModel accountLogin = accountService.getAccountModelByAuthencated();
		if (accountLogin != null) {
			EventModel eventModel = null;
			Date eventStartTime = event.getStartDate();
			Date eventEndTime = event.getEndDate();
			if (eventStartTime == null || eventEndTime == null || eventStartTime.after(eventEndTime)) {
				event.setStartDate(null);
				event.setEndDate(null);
			}
			if (event.getId() == null) {
				event.setAccount(accountLogin);
				event.setCreateDate(Calendar.getInstance().getTime());
				event.setIsPublic(1);
				event.setIsAccept(0);
				eventModel = eventService.saveEvent(event);
				// save thumbnail
				if (imageThumbnailBase64 != null) {
					String thumbnailImage = FileUtil.saveImageEvent(imageThumbnailBase64, accountLogin, eventModel, "thumbnail", request);
					eventModel.setImageThumbnail(thumbnailImage);
				}
				if (imageOrganizeBase64 != null) {
					String organizeLogoImage = FileUtil.saveImageEvent(imageOrganizeBase64, accountLogin, eventModel, "organizeLogo", request);
					eventModel.setOrganizeLogo(organizeLogoImage);
				}
				eventModel.setPath(EncryptionUtil.encodeId(eventModel.getId()));
				eventModel = eventService.updateEvent(eventModel);
			}else {
				eventModel = eventService.getEventById(event.getId());
		        if (eventModel != null) {
					AccountModel accountGetFromEvent = eventModel.getAccount();
					if (accountGetFromEvent != null && accountGetFromEvent.getId().equals(accountLogin.getId())) {
						// save thumbnail
						if (imageThumbnailBase64 != null && imageThumbnailBase64.contains("data:image/")) {
							String thumbnailImage = FileUtil.saveImageEvent(imageThumbnailBase64, accountLogin, eventModel, "thumbnail", request);
							eventModel.setImageThumbnail(thumbnailImage);
						}
						if (imageOrganizeBase64 != null && imageOrganizeBase64.contains("data:image/")) {
							String organizeLogoImage = FileUtil.saveImageEvent(imageOrganizeBase64, accountLogin, eventModel, "organizeLogo", request);
							eventModel.setOrganizeLogo(organizeLogoImage);
						}
						event.setAccount(accountGetFromEvent);
						event.setCreateDate(eventModel.getCreateDate());
						event.setImageThumbnail(eventModel.getImageThumbnail());
						event.setOrganizeLogo(eventModel.getOrganizeLogo());
						event.setEventLayout(eventModel.getEventLayout());
						event.setConfirmEmail(eventModel.getConfirmEmail());
						event.setPath(eventModel.getPath());
						eventModel = eventService.updateEvent(event);
					}else {
						response.setStatus(HttpServletResponse.SC_FORBIDDEN);
						model.addAttribute("error", "404");
						return "error/response_ajax_error";
					}
				}else {
					response.setStatus(HttpServletResponse.SC_NOT_FOUND);
					model.addAttribute("error", "403");
					return "error/response_ajax_error";
				}
			}
			
			if (checkEventPassStepTwoCreateEvent(eventModel)) {
				if (eventModel.getEventLayout() != null) {
					Long[] data = {eventModel.getEventLayout().getId(), eventModel.getId()};
					return createEventLayoutPost(data, model, response);
				}
				ArrayList<EventLayoutModel> listEventLayout = eventLayoutService.getListEventLayout();
				model.addAttribute("listLayout", listEventLayout);
				model.addAttribute("event", eventModel);
				return "event-theme/create_event_step_two";
			}
			model.addAttribute("error", "error|" + eventModel.getId());
			return "error/response_ajax_error";
		}
		model.addAttribute("error", "loginError");
		return "error/response_ajax_error";
	}
	//// - END STEP TWO

	//// - LAST STEP
	@ResponseBody
	@RequestMapping(value = "/create-event-finish", method = RequestMethod.POST)
	public String createEventFinishPost(@RequestBody EventModel event) {
		AccountModel accountLogin = accountService.getAccountModelByAuthencated();
		if (accountLogin != null) {
			if (event.getId() != null && eventService.isExitEvent(event.getId(), accountLogin.getId())) {
				EventModel eventFromData = eventService.getEventById(event.getId());
				boolean isExistPath = eventService.getEventByPath(event.getPath()) != null;
				eventFromData.setIsPublic(event.getIsPublic());
				eventFromData.setConfirmEmail(event.getConfirmEmail());
				if (!isExistPath) {
					eventFromData.setPath(event.getPath());
				}
				eventService.updateEvent(eventFromData);
				if (isExistPath && !event.getPath().equals(eventFromData.getPath())) {
					return "existPathError";
				}
				if (checkEventPassFinishCreateEvent(eventFromData)) {
					HtmlEmail htmlEmail = null;
					try {
						htmlEmail = emailServices.configHtmlEmailBeforeSend();
					} catch (EmailException e) {
					}
					if (htmlEmail != null) {
						SendEmailUtil.sendEmailFinishCreateEvent(htmlEmail , eventFromData.getEmail(), eventFromData, request);
					}
					return "createEventSuccess";
				}
				return "createEventlastStepSuccess";
			}
			return "notPermission";
		}
		return "loginError";
	}
	
	@ResponseBody
	@RequestMapping(value = "/create-ticket", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public String createTicket(@RequestBody TicketModel ticket) {
		AccountModel accountLogin = accountService.getAccountModelByAuthencated();
		if (accountLogin != null) {
			if (isInvalidDataSendCreateTicket(ticket)) {
				return "sendDataError";
			}
			EventModel event = eventService.getEventById(ticket.getEvent().getId());
			if (event == null) {
				return "notFound";
			}
			if (!eventService.isExitEvent(event.getId(), accountLogin.getId())) {
				return "notPermission";
			}
			ticket.setEvent(event);
			TicketModel ticketData = ticketService.save(ticket);
			ticketData.getEvent().setAccount(null);
			BarCodeUtil.saveBarCodeTicket(ticketData, request);
			ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
			String result = "convertJsonError";
			try {
				result = objectWriter.writeValueAsString(ticketData);
			} catch (IOException e) {
			}
			return result;
		}
		return "loginError";
	}
	
	private boolean isInvalidDataSendCreateTicket(TicketModel ticket) {
		boolean result = ticket == null || ticket.getDescription() == null || ticket.getEvent() == null
				|| ticket.getEvent().getId() == null || (ticket.getIsFree() != 1 && ticket.getIsFree() != 0)
				|| ticket.getName() == null || ticket.getPrice() < 0;
		return result;
	}
	//// - END LAST STEP
	
	//// - LAYOUT
	//// 	+ FREE LAYOUT
	@RequestMapping(value = "/create-event-free-layout", method = RequestMethod.POST)
	public String createEventFreeLayout(@RequestBody FreeLayoutModel freeLayoutModel, Model model) {
		AccountModel accountLogin = accountService.getAccountModelByAuthencated();
		if (accountLogin != null) {
			if (isNullPropertiOfFreeLayout(freeLayoutModel)) {
				model.addAttribute("error", "sendDataError");
				return "error/response_ajax_error";
			}
			if (!freeLayoutService.isExistFreeLayoutByEventId(freeLayoutModel.getEventId(), freeLayoutModel.getId()) || !eventService.isExitEvent(freeLayoutModel.getEventId(), accountLogin.getId())) {
				model.addAttribute("error", "notFound");
				return "error/response_ajax_error";
			}
			freeLayoutService.update(freeLayoutModel);
			EventModel eventModel = eventService.getEventById(freeLayoutModel.getEventId());
			model.addAttribute("event", eventModel);
			return "event-theme/create_event_last_step";
		}

		model.addAttribute("error", "loginError");
		return "error/response_ajax_error";
	}
	
	private boolean isNullPropertiOfFreeLayout(FreeLayoutModel freeLayoutModel){
		boolean result = freeLayoutModel == null || freeLayoutModel.getId() == null || freeLayoutModel.getEventId() == null
				|| freeLayoutModel.getContent() == null;
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/upload-file-free-style", method = RequestMethod.POST)
	public String createUploadFileFreeStyle(@RequestBody String[] data, Model model) {
		Long eventId = null;
		if (data == null || data.length != 3) {
			return "fileNullError";
		}
		try {
			eventId = Long.valueOf(data[2]);
		} catch (IllegalArgumentException e) {}
		if (eventId == null) {
			return "eventNullError";
		}
		AccountModel accountLogin = accountService.getAccountModelByAuthencated();
		
		if (accountLogin != null) {
			if (eventService.isExitEvent(eventId, accountLogin.getId())) {
				String base64Img = data[0];
				String fileName = data[1];
				String result = FileUtil.saveImageEventFreeLayout(base64Img, accountLogin.getId(), eventId, fileName, request);
				if (result == null) {
					return "fileNullError";
				}
				FreeLayoutModel freeLayoutModel = freeLayoutService.findFreeLayoutByEventId(eventId);
				if (freeLayoutModel == null) {
					freeLayoutModel = new FreeLayoutModel();
					freeLayoutModel.setEventId(eventId);
					freeLayoutModel = freeLayoutService.save(freeLayoutModel);
				}
				FreeLayoutImageLibraryModel freeLayoutImageLibraryModel = new FreeLayoutImageLibraryModel();
				freeLayoutImageLibraryModel.setImage(result);
				freeLayoutImageLibraryModel.setFreeLayout(freeLayoutModel);
				freeLayoutImageLibraryService.save(freeLayoutImageLibraryModel);
				
				return "http://localhost:8080/ticketevent-web/resources/images/" + result;
			}
			return "eventNullError";
		}
		return "loginError";
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete-file-free-style", method = RequestMethod.POST)
	public String deleteFileFreeStyle(@RequestBody String[] data, Model model) {
		Long eventId = null;
		if (data == null || data.length != 2) {
			return "deleteFail";
		}
		String url = data[0];
		try {
			eventId = Long.valueOf(data[1]);
		} catch (IllegalArgumentException e) {}
		if (eventId == null || url == null) {
			return "eventNullError";
		}
		AccountModel accountLogin = accountService.getAccountModelByAuthencated();
		
		if (accountLogin != null) {
			if (eventService.isExitEvent(eventId, accountLogin.getId())) {
				if (url.split("resources/images/accounts/").length != 2) {
					return "deleteFail";
				}
				String urlAfterImagesFolderContainFileName = url.split("resources/images/")[1];
				boolean isDeleteSuccess = FileUtil.deleteFileUrlAfterImagesFolder(urlAfterImagesFolderContainFileName, request);
				if (isDeleteSuccess) {
					freeLayoutImageLibraryService.deleteByUrl(urlAfterImagesFolderContainFileName);
					return "deleteSuccess";
				}
				return "deleteFail";
			}
			return "eventNullError";
		}
		return "loginError";
	}
	////	+ END FREE LAYOUT

	////	+ ACTIVITY LAYOUT
	@RequestMapping(value = "/create-event-activity-layout", method = RequestMethod.POST)
	public String createEventActivityLayout(@RequestBody ActivityLayoutModel activityLayout, Model model) {
		AccountModel accountLogin = accountService.getAccountModelByAuthencated();
		if (accountLogin != null) {
			if (isNullDataSendActivityLayout(activityLayout)) {
				model.addAttribute("error", "sendDataError");
				return "error/response_ajax_error";
			}
			if (!activityLayoutService.isExistActivityLayoutByEventId(activityLayout.getEventId(), activityLayout.getId()) || !eventService.isExitEvent(activityLayout.getEventId(), accountLogin.getId())) {
				model.addAttribute("error", "notFound");
				return "error/response_ajax_error";
			}
			ActivityLayoutModel activityLayoutGetFromData = activityLayoutService.getActivityLayoutById(activityLayout.getId());
			activityLayoutGetFromData.setSologan(activityLayout.getSologan());
			activityLayoutService.update(activityLayoutGetFromData);
			if (isNullPropertyActivityLayout(activityLayoutGetFromData)) {
				model.addAttribute("error", "notEnough");
				return "error/response_ajax_error";
			}
			EventModel eventModel = eventService.getEventById(activityLayout.getEventId());
			model.addAttribute("event", eventModel);
			return "event-theme/create_event_last_step";
		}

		model.addAttribute("error", "loginError");
		return "error/response_ajax_error";
	}
	
	private boolean isNullDataSendActivityLayout(ActivityLayoutModel activityLayoutModel) {
		boolean result = activityLayoutModel == null || activityLayoutModel.getEventId() == null
				|| activityLayoutModel.getId() == null;
		return result;
	}
	
	private boolean isNullPropertyActivityLayout(ActivityLayoutModel activityLayout) {
		boolean result = activityLayout == null || activityLayout.getEventId() == null
				|| activityLayout.getSologan() == null || activityLayout.getId() == null
				|| activityLayout.getBackgroundImage() == null || activityLayout.getEventLogo() == null
				|| activityLayout.getListActivityLayoutImageLibrary() == null;
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/upload-file-activity", method = RequestMethod.POST)
	public String createUploadFileActivity(@RequestBody String[] data) {
		Long eventId = null;
		if (data == null || data.length != 3) {
			return "fileNullError";
		}
		try {
			eventId = Long.valueOf(data[2]);
		} catch (IllegalArgumentException e) {}
		if (eventId == null) {
			return "eventNullError";
		}
		AccountModel accountLogin = accountService.getAccountModelByAuthencated();
		if (accountLogin != null) {
			if (eventService.isExitEvent(eventId, accountLogin.getId())) {
				String base64Img = data[0];
				String fileName = data[1];
				String result = FileUtil.saveImageEventActivityLayout(base64Img, accountLogin.getId(), eventId, fileName, request);
				if (result == null) {
					return "fileNullError";
				}
				ActivityLayoutModel activityLayoutModel = activityLayoutService.findActivityLayoutByEventId(eventId);
				if (activityLayoutModel == null) {
					activityLayoutModel = new ActivityLayoutModel();
					activityLayoutModel.setEventId(eventId);
					activityLayoutModel = activityLayoutService.save(activityLayoutModel);
				}
				switch (fileName) {
					case "background":
						activityLayoutModel.setBackgroundImage(result);
						break;
					case "logo":
						activityLayoutModel.setEventLogo(result);
						break;
					default:
						break;
				}
				activityLayoutService.update(activityLayoutModel);
				return result;
			}
			return "eventNullError";
		}
		return "loginError";
	}
	
	@ResponseBody
	@RequestMapping(value = "/upload-image-lib-activity", method = RequestMethod.POST)
	public String createUploadImagrLibActivity(@RequestBody String[] data) {
		Long eventId = null;
		if (data == null || data.length != 3) {
			return "fileNullError";
		}
		try {
			eventId = Long.valueOf(data[2]);
		} catch (IllegalArgumentException e) {}
		if (eventId == null) {
			return "eventNullError";
		}
		AccountModel accountLogin = accountService.getAccountModelByAuthencated();
		if (accountLogin != null) {
			if (eventService.isExitEvent(eventId, accountLogin.getId())) {
				String base64Img = data[0];
				String fileName = data[1];
				String result = FileUtil.saveLibImageEventActivityLayout(base64Img, accountLogin.getId(), eventId, fileName, request);
				if (result == null) {
					return "fileNullError";
				}
				ActivityLayoutModel activityLayoutModel = activityLayoutService.findActivityLayoutByEventId(eventId);
				if (activityLayoutModel == null) {
					activityLayoutModel = new ActivityLayoutModel();
					activityLayoutModel.setEventId(eventId);
					activityLayoutModel = activityLayoutService.save(activityLayoutModel);
				}
				ActivityLayoutImageLibraryModel activityLayoutImageLibraryModel = new ActivityLayoutImageLibraryModel();
				activityLayoutImageLibraryModel.setImage(result);
				activityLayoutImageLibraryModel.setActivityLayout(activityLayoutModel);
				activityLayoutImageLibraryService.save(activityLayoutImageLibraryModel);
				return result;
			}
			return "eventNullError";
		}
		return "loginError";
	}
	////	+ END ACTIVITY LAYOUT
	////	+ MUSIC LAYOUT
	@RequestMapping(value = "/create-event-music-layout", method = RequestMethod.POST)
	public String createEventMusicLayout(@RequestBody MusicLayoutModel musicLayout, Model model) {
		AccountModel accountLogin = accountService.getAccountModelByAuthencated();
		if (accountLogin != null) {
			if (isNullDataSendCreateMusicLayout(musicLayout)) {
				model.addAttribute("error", "sendDataError");
				return "error/response_ajax_error";
			}
			if (!musicLayoutService.isExistMusicLayoutByEventId(musicLayout.getEventId(), musicLayout.getId()) || !eventService.isExitEvent(musicLayout.getEventId(), accountLogin.getId())) {
				model.addAttribute("error", "notFound");
				return "error/response_ajax_error";
			}
			MusicLayoutModel musicLayoutGetFromData = musicLayoutService.getMusicLayoutById(musicLayout.getId());
			musicLayoutGetFromData.setLinkHighlight(musicLayout.getLinkHighlight());
			musicLayoutGetFromData = musicLayoutService.update(musicLayoutGetFromData);
			if (isNullPropertyCreateMusicLayout(musicLayoutGetFromData)) {
				model.addAttribute("error", "notEnough");
				return "error/response_ajax_error";
			}
			EventModel eventModel = eventService.getEventById(musicLayout.getEventId());
			model.addAttribute("event", eventModel);
			return "event-theme/create_event_last_step";
		}
	
		model.addAttribute("error", "loginError");
		return "error/response_ajax_error";
	}
	
	private boolean isNullDataSendCreateMusicLayout(MusicLayoutModel musicLayout) {
		boolean result = musicLayout == null || musicLayout.getId() == null || musicLayout.getEventId() == null || musicLayout.getLinkHighlight() == null; 
		return result;
	}
	
	private boolean isNullPropertyCreateMusicLayout(MusicLayoutModel musicLayout) {
		boolean result = musicLayout == null || musicLayout.getId() == null || musicLayout.getEventId() == null || musicLayout.getLinkHighlight() == null
				|| musicLayout.getBannerImage() == null || musicLayout.getPlaceImage() == null || musicLayout.getListMusicLayoutImageLibrary() == null
				|| musicLayout.getListMusicLayouFamousPerson() == null; 
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/upload-file-music", method = RequestMethod.POST)
	public String createUploadFileMusic(@RequestBody String[] data) {
		Long eventId = null;
		if (data == null || data.length != 3) {
			return "fileNullError";
		}
		try {
			eventId = Long.valueOf(data[2]);
		} catch (IllegalArgumentException e) {}
		if (eventId == null) {
			return "eventNullError";
		}
		AccountModel accountLogin = accountService.getAccountModelByAuthencated();
		if (accountLogin != null) {
			if (eventService.isExitEvent(eventId, accountLogin.getId())) {
				String base64Img = data[0];
				String fileName = data[1];
				String result = FileUtil.saveImageEventMusicLayout(base64Img, accountLogin.getId(), eventId, fileName, request);
				if (result == null) {
					return "fileNullError";
				}
				MusicLayoutModel musicLayoutModel = musicLayoutService.findMusicLayoutByEventId(eventId);
				if (musicLayoutModel == null) {
					musicLayoutModel = new MusicLayoutModel();
					musicLayoutModel.setEventId(eventId);
					musicLayoutModel = musicLayoutService.save(musicLayoutModel);
				}
				switch (fileName) {
					case "banner":
						musicLayoutModel.setBannerImage(result);
						break;
					case "place":
						musicLayoutModel.setPlaceImage(result);
						break;
					default:
						break;
				}
				musicLayoutService.update(musicLayoutModel);
				return result;
			}
			return "eventNullError";
		}
		return "loginError";
	}

	@ResponseBody
	@RequestMapping(value = "/upload-image-lib-music", method = RequestMethod.POST)
	public String createUploadImagrLibMusic(@RequestBody String[] data) {
		Long eventId = null;
		if (data == null || data.length != 3) {
			return "fileNullError";
		}
		try {
			eventId = Long.valueOf(data[2]);
		} catch (IllegalArgumentException e) {}
		if (eventId == null) {
			return "eventNullError";
		}
		AccountModel accountLogin = accountService.getAccountModelByAuthencated();
		if (accountLogin != null) {
			if (eventService.isExitEvent(eventId, accountLogin.getId())) {
				String base64Img = data[0];
				String fileName = data[1];
				String result = FileUtil.saveLibImageEventMusicLayout(base64Img, accountLogin.getId(), eventId, fileName, request);
				if (result == null) {
					return "fileNullError";
				}
				MusicLayoutModel musicLayoutModel = musicLayoutService.findMusicLayoutByEventId(eventId);
				if (musicLayoutModel == null) {
					musicLayoutModel = new MusicLayoutModel();
					musicLayoutModel.setEventId(eventId);
					musicLayoutModel = musicLayoutService.save(musicLayoutModel);
				}
				MusicLayoutImageLibraryModel musicLayoutImageLibraryModel = new MusicLayoutImageLibraryModel();
				musicLayoutImageLibraryModel.setImage(result);
				musicLayoutImageLibraryModel.setMusicLayout(musicLayoutModel);
				musicLayoutImageLibraryService.save(musicLayoutImageLibraryModel);
				return result;
			}
			return "eventNullError";
		}
		return "loginError";
	}
	
	@ResponseBody
	@RequestMapping(value = "/create-famous-person-music", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public String createFamousPersonMusicLayout(@RequestBody MusicLayoutFamousPersonModel musicLayoutFamousPerson) {
		
		AccountModel accountLogin = accountService.getAccountModelByAuthencated();
		if (accountLogin != null) {
			if (isNullDataSendMusicLayoutFamousPerson(musicLayoutFamousPerson)) {
				return "dataSendError";
			}
			MusicLayoutModel musicLayout = musicLayoutService.getMusicLayoutById(musicLayoutFamousPerson.getMusicLayout().getId());
			if (musicLayout == null || !musicLayout.getEventId().equals(musicLayoutFamousPerson.getMusicLayout().getEventId()) 
					|| !eventService.isExitEvent(musicLayout.getEventId(), accountLogin.getId())) {
				return "notFound";
			}
			musicLayoutFamousPerson.setMusicLayout(musicLayout);
			String imageFamousPersonBase64 = musicLayoutFamousPerson.getImage();
			musicLayoutFamousPerson.setImage("");
			MusicLayoutFamousPersonModel musicLayoutFamousPersonGetFromData;
			if (musicLayoutFamousPerson.getId() != null) {
				musicLayoutFamousPersonGetFromData = musicLayoutFamousPersonService.update(musicLayoutFamousPerson);
			}else {
				musicLayoutFamousPersonGetFromData = musicLayoutFamousPersonService.save(musicLayoutFamousPerson);
			}
			String imageFamousPerson = FileUtil.saveImageFamousPersonMusicLayout(imageFamousPersonBase64, accountLogin.getId(),
					musicLayout.getEventId(), musicLayoutFamousPersonGetFromData.getId(), request);
			musicLayoutFamousPersonGetFromData.setImage(imageFamousPerson);
			musicLayoutFamousPersonService.update(musicLayoutFamousPersonGetFromData);
			ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
			String result = "convertJsonError";
			try {
				result = objectWriter.writeValueAsString(musicLayoutFamousPersonGetFromData);
			} catch (IOException e) {
			}
			return result;
		}
		return "loginError";
	}
	
	private boolean isNullDataSendMusicLayoutFamousPerson(MusicLayoutFamousPersonModel musicLayoutFamousPerson) {
		boolean result = musicLayoutFamousPerson == null || musicLayoutFamousPerson.getDateOfBirth() == null
				|| musicLayoutFamousPerson.getImage() == null || musicLayoutFamousPerson.getIntroduction() == null
				|| musicLayoutFamousPerson.getMusicLayout() == null || musicLayoutFamousPerson.getMusicLayout().getId() == null
				|| musicLayoutFamousPerson.getMusicLayout().getEventId() == null ||  musicLayoutFamousPerson.getName() == null;

		return result;
	}
	
	////	+ END MUSIC LAYOUT
	////	+ COURSE LAYOUT
	@RequestMapping(value = "/create-event-course-layout", method = RequestMethod.POST)
	public String createEventCourseLayout(@RequestBody CourseLayoutModel courseLayout, Model model) {
		AccountModel accountLogin = accountService.getAccountModelByAuthencated();
		if (accountLogin != null) {
			if (isNullDataSendCreateContentLayout(courseLayout)) {
				model.addAttribute("error", "sendDataError");
				return "error/response_ajax_error";
			}
			if (!courseLayoutService.isExistCourseLayoutByEventId(courseLayout.getEventId(), courseLayout.getId()) || !eventService.isExitEvent(courseLayout.getEventId(), accountLogin.getId())) {
				model.addAttribute("error", "notFound");
				return "error/response_ajax_error";
			}
			CourseLayoutModel courseLayoutGetFromData = courseLayoutService.getCourseLayoutById(courseLayout.getId());
			if (isNullPropertyCreateCourseLayout(courseLayoutGetFromData)) {
				model.addAttribute("error", "notEnough");
				return "error/response_ajax_error";
			}
			EventModel eventModel = eventService.getEventById(courseLayoutGetFromData.getEventId());
			model.addAttribute("event", eventModel);
			return "event-theme/create_event_last_step";
		}
	
		model.addAttribute("error", "loginError");
		return "error/response_ajax_error";
	}
	
	private boolean isNullDataSendCreateContentLayout(CourseLayoutModel courseLayout) {
		boolean result = courseLayout == null || courseLayout.getId() == null || courseLayout.getEventId() == null; 
		return result;
	}
	
	private boolean isNullPropertyCreateCourseLayout(CourseLayoutModel courseLayout) {
		boolean result = courseLayout == null || courseLayout.getId() == null || courseLayout.getEventId() == null || courseLayout.getBannerImage() == null
				|| courseLayout.getPlaceImage() == null || courseLayout.getListCourseLayoutContent() == null
				|| courseLayout.getListCourseLayoutSpeaker() == null; 
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/upload-file-course", method = RequestMethod.POST)
	public String createUploadFileCourse(@RequestBody String[] data) {
		Long eventId = null;
		if (data == null || data.length != 3) {
			return "fileNullError";
		}
		try {
			eventId = Long.valueOf(data[2]);
		} catch (IllegalArgumentException e) {}
		if (eventId == null) {
			return "eventNullError";
		}
		AccountModel accountLogin = accountService.getAccountModelByAuthencated();
		if (accountLogin != null) {
			if (eventService.isExitEvent(eventId, accountLogin.getId())) {
				String base64Img = data[0];
				String fileName = data[1];
				String result = FileUtil.saveImageEventCourseLayout(base64Img, accountLogin.getId(), eventId, fileName, request);
				if (result == null) {
					return "fileNullError";
				}
				CourseLayoutModel courseLayout = courseLayoutService.findCourseLayoutByEventId(eventId);
				if (courseLayout == null) {
					courseLayout = new CourseLayoutModel();
					courseLayout.setEventId(eventId);
					courseLayout = courseLayoutService.save(courseLayout);
				}
				switch (fileName) {
					case "banner":
						courseLayout.setBannerImage(result);
						break;
					case "place":
						courseLayout.setPlaceImage(result);
						break;
					default:
						break;
				}
				courseLayoutService.update(courseLayout);
				return result;
			}
			return "eventNullError";
		}
		return "loginError";
	}

	@ResponseBody
	@RequestMapping(value = "/create-speaker-course", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public String createSpeakerCourseLayout(@RequestBody CourseLayoutSpeakerModel courseLayoutSpeaker) {
		
		AccountModel accountLogin = accountService.getAccountModelByAuthencated();
		if (accountLogin != null) {
			if (isNullDataSendCourseLayoutSpeaker(courseLayoutSpeaker)) {
				return "dataSendError";
			}
			CourseLayoutModel courseLayout = courseLayoutService.findCourseLayoutByEventId(courseLayoutSpeaker.getCourseLayout().getEventId());
			if (courseLayout == null || !courseLayout.getEventId().equals(courseLayoutSpeaker.getCourseLayout().getEventId()) 
					|| !eventService.isExitEvent(courseLayout.getEventId(), accountLogin.getId())) {
				return "notFound";
			}
			courseLayoutSpeaker.setCourseLayout(courseLayout);
			String imageSpeakerBase64 = courseLayoutSpeaker.getImage();
			courseLayoutSpeaker.setImage("");
			CourseLayoutSpeakerModel courseLayoutSpeakerGetFromData;
			if (courseLayoutSpeaker.getId() != null) {
				courseLayoutSpeakerGetFromData = courseLayoutSpeakerService.update(courseLayoutSpeaker);
			}else {
				courseLayoutSpeakerGetFromData = courseLayoutSpeakerService.save(courseLayoutSpeaker);
			}
			String imageFamousPerson = FileUtil.saveImageSpeakerCourseLayout(imageSpeakerBase64, accountLogin.getId(),
					courseLayout.getEventId(), courseLayoutSpeakerGetFromData.getId(), request);
			courseLayoutSpeakerGetFromData.setImage(imageFamousPerson);
			courseLayoutSpeakerService.update(courseLayoutSpeakerGetFromData);
			ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
			String result = "convertJsonError";
			try {
				result = objectWriter.writeValueAsString(courseLayoutSpeakerGetFromData);
			} catch (IOException e) {
			}
			return result;
		}
		return "loginError";
	}
	
	private boolean isNullDataSendCourseLayoutSpeaker(CourseLayoutSpeakerModel courseLayoutSpeaker) {
		boolean result = courseLayoutSpeaker == null || courseLayoutSpeaker.getField() == null
				|| courseLayoutSpeaker.getImage() == null || courseLayoutSpeaker.getHistory() == null
				|| courseLayoutSpeaker.getCourseLayout() == null || courseLayoutSpeaker.getCourseLayout().getId() == null
				|| courseLayoutSpeaker.getCourseLayout().getEventId() == null ||  courseLayoutSpeaker.getName() == null;

		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/create-content-course", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public String createContentCourseLayout(@RequestBody CourseLayoutContentModel courseLayoutContent) {
		
		AccountModel accountLogin = accountService.getAccountModelByAuthencated();
		if (accountLogin != null) {
			if (isNullDataSendCourseLayoutContent(courseLayoutContent)) {
				return "dataSendError";
			}
			CourseLayoutModel courseLayout = courseLayoutService.findCourseLayoutByEventId(courseLayoutContent.getCourseLayout().getEventId());
			if (courseLayout == null || !courseLayout.getEventId().equals(courseLayoutContent.getCourseLayout().getEventId()) 
					|| !eventService.isExitEvent(courseLayout.getEventId(), accountLogin.getId())) {
				return "notFound";
			}
			courseLayoutContent.setCourseLayout(courseLayout);
			CourseLayoutContentModel courseLayoutContentGetFromData;
			if (courseLayoutContent.getId() != null) {
				courseLayoutContentGetFromData = courseLayoutContentService.update(courseLayoutContent);
			}else {
				courseLayoutContentGetFromData = courseLayoutContentService.save(courseLayoutContent);
			}
			ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
			String result = "convertJsonError";
			try {
				result = objectWriter.writeValueAsString(courseLayoutContentGetFromData);
			} catch (IOException e) {
			}
			return result;
		}
		return "loginError";
	}
	
	private boolean isNullDataSendCourseLayoutContent(CourseLayoutContentModel courseLayoutContent) {
		boolean result = courseLayoutContent == null || courseLayoutContent.getTitle() == null || courseLayoutContent.getContent() == null
				|| courseLayoutContent.getCourseLayout() == null || courseLayoutContent.getCourseLayout().getId() == null
				|| courseLayoutContent.getCourseLayout().getEventId() == null;

		return result;
	}
	////	+ END COURSE LAYOUT
	// - END LAYOUT
	
	private boolean checkEventPassStepTwoCreateEvent(EventModel event) {
		boolean result = event != null && event.getName() != null && event.getEventType() != null
				&& event.getPlace() != null && event.getIntroduction() != null
				&& event.getStartDate() != null && event.getEndDate() != null
				&& event.getOrganizeName() != null && event.getOrganizeInfo() != null
				&& event.getEmail() != null && event.getPhoneNumber() != null
				&& event.getImageThumbnail() != null && event.getOrganizeLogo() != null;
		
		return result;
	}
	
	private boolean checkEventPassFinishCreateEvent(EventModel event) {
		boolean result = event != null && event.getId() != null && (event.getIsPublic() == 0 || event.getIsPublic() == 1)
				&& event.getConfirmEmail() != null && event.getPath() != null && event.getListTicket() != null;
		
		return result;
	}
	
	private boolean isNullAllPropertiOfEvent(EventModel event, String imageThumbnailBase64, String imageOrganizeBase64) {
		boolean result = event.getName() == null && event.getEventType() == null
				&& event.getPlace() == null && event.getIntroduction() == null
				&& event.getStartDate() == null && event.getEndDate() == null
				&& event.getOrganizeName() == null && event.getOrganizeInfo() == null
				&& event.getEmail() == null && event.getPhoneNumber() == null
				&& imageThumbnailBase64 == null && imageOrganizeBase64 == null;
		
		return result;
	}
	
}
