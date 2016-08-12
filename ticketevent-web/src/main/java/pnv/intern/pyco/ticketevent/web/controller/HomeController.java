package pnv.intern.pyco.ticketevent.web.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pnv.intern.pyco.ticketevent.repository.entity.UserInformationEntity;
import pnv.intern.pyco.ticketevent.services.AccountService;
import pnv.intern.pyco.ticketevent.services.EmailServices;
import pnv.intern.pyco.ticketevent.services.EventService;
import pnv.intern.pyco.ticketevent.services.EventTypeService;
import pnv.intern.pyco.ticketevent.services.TicketBuyerService;
import pnv.intern.pyco.ticketevent.services.TicketOrderService;
import pnv.intern.pyco.ticketevent.services.TicketService;
import pnv.intern.pyco.ticketevent.services.UserInformationService;
import pnv.intern.pyco.ticketevent.services.layout.activity.ActivityLayoutService;
import pnv.intern.pyco.ticketevent.services.layout.course.CourseLayoutService;
import pnv.intern.pyco.ticketevent.services.layout.free.FreeLayoutService;
import pnv.intern.pyco.ticketevent.services.layout.music.MusicLayoutService;
import pnv.intern.pyco.ticketevent.services.model.AccountModel;
import pnv.intern.pyco.ticketevent.services.model.AccountUserInfoModel;
import pnv.intern.pyco.ticketevent.services.model.EventModel;
import pnv.intern.pyco.ticketevent.services.model.EventTypeModel;
import pnv.intern.pyco.ticketevent.services.model.TicketBuyerModel;
import pnv.intern.pyco.ticketevent.services.model.TicketModel;
import pnv.intern.pyco.ticketevent.services.model.TicketOrderModel;
import pnv.intern.pyco.ticketevent.services.model.layout.activity.ActivityLayoutModel;
import pnv.intern.pyco.ticketevent.services.model.layout.course.CourseLayoutModel;
import pnv.intern.pyco.ticketevent.services.model.layout.free.FreeLayoutModel;
import pnv.intern.pyco.ticketevent.services.model.layout.music.MusicLayoutModel;
import pnv.intern.pyco.ticketevent.web.util.FileUtil;
import pnv.intern.pyco.ticketevent.web.util.NonDataConstantUtil;

@Controller
public class HomeController {
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private UserInformationService userInfoService;
	@Autowired
	private EventService eventService;
	@Autowired
	private EventTypeService eventTypeService;
	@Autowired
	private TicketBuyerService ticketBuyerService;
	@Autowired
	private TicketOrderService ticketOrderService;
	@Autowired
	private TicketService ticketService;

	@Autowired
	private FreeLayoutService freeLayoutService;
	@Autowired
	private ActivityLayoutService activityLayoutService;
	@Autowired
	private MusicLayoutService musicLayoutService;
	@Autowired
	private CourseLayoutService courseLayoutService;
	
	private AccountModel accountModelTempl;
	private String path;
	@Autowired
	private EmailServices emailService;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelMap model) {
		AccountModel account = accountService.getAccountModelByAuthencated();
		if(account != null){
			AccountUserInfoModel aInfoModel= accountService.getAccInfor(account.getId());
			model.put("accountInfo", aInfoModel);
			model.put("account", account);
		}
		List<EventModel> listEventSlide = eventService.getEventSlide(5);
		model.put("listEventSlide", listEventSlide);
		model.put("listFamousCity", NonDataConstantUtil.LIST_FAMOUS_CITY_VIETNAM);
		return "index";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(ModelMap model) {
		AccountModel account = accountService.getAccountModelByAuthencated();
		if(account != null){
			AccountUserInfoModel aInfoModel= accountService.getAccInfor(account.getId());
			model.put("accountInfo", aInfoModel);
			model.put("account", account);
		}
		ArrayList<EventTypeModel> listEventType = eventTypeService.getAllEventType();
		model.addAttribute("listEventType", listEventType);
		model.put("listFamousCity", NonDataConstantUtil.LIST_FAMOUS_CITY_VIETNAM);
		return "search_event";
	}

	@RequestMapping(value = "/buy-ticket/{eventId}", method = RequestMethod.GET)
	public String buyTicket(@PathVariable Long eventId, ModelMap model) {
		AccountModel accountLogin = accountService.getAccountModelByAuthencated();
		if (accountLogin != null) {
			model.put("account", accountLogin);
		}
		EventModel event = eventService.getEventById(eventId);
		if (event == null) {
			return "error/404";
		}
		model.put("event", event);
		return "buy_ticket";
	}

	@ResponseBody
	@RequestMapping(value = "/buy-ticket/{eventId}", method = RequestMethod.POST)
	public String buyTicketPost(@PathVariable Long eventId, @RequestBody TicketBuyerModel ticketBuyer) {
		if (isInvalidDataSendOrderTicket(ticketBuyer)) {
			return "dataSendError";
		}
		EventModel event = eventService.getEventById(eventId);
		if (event == null) {
			return "notFound";
		}
		AccountModel accountLogin = accountService.getAccountModelByAuthencated();
		if (accountLogin != null) {
			ticketBuyer.setAccount(accountLogin);
		}
		List<TicketOrderModel> listTicketOrder = ticketBuyer.getListTicketOrder();
		ticketBuyer = ticketBuyerService.save(ticketBuyer);
		for (TicketOrderModel ticketOrder : listTicketOrder) {
			ticketOrder.setBuyDate(Calendar.getInstance().getTime());
			ticketOrder.setStatus(0);
			TicketModel ticket = ticketService.getTicketById(ticketOrder.getTicket().getId());
			ticketOrder.setTicket(ticket);
			ticketOrder.setTicketBuyer(ticketBuyer);
			ticketOrderService.save(ticketOrder);
		}
		return "orderSuccess";
	}
	
	private boolean isInvalidDataSendOrderTicket(TicketBuyerModel ticketBuyer) {
		boolean result = ticketBuyer == null || ticketBuyer.getAddress() == null
				|| ticketBuyer.getName() == null || ticketBuyer.getPhone() == null
				|| ticketBuyer.getListTicketOrder() == null;
		if (!result) {
			List<TicketOrderModel> listTicketOrder = ticketBuyer.getListTicketOrder();
			for (TicketOrderModel ticketOrder : listTicketOrder) {
				result = ticketOrder.getTicket() == null || ticketOrder.getTicket().getId() == null;
			}
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/api/get-all-event", method = RequestMethod.GET)
	public List<EventModel> getAllEvent(ModelMap model) {
		List<EventModel> listEvent = eventService.getAllEventIsAccept();
		return listEvent;
	}
	
	@RequestMapping(value = "/api/{name}", method = RequestMethod.GET)
	public @ResponseBody boolean getAll(@PathVariable("name") String username){
		return accountService.checkExitsUser(username);
	}
	
	@RequestMapping(value = "/event/{eventPath}", method = RequestMethod.GET)
	public String viewEvent(@PathVariable String eventPath, Model model) {
		EventModel event = eventService.getEventByPath(eventPath);
		if (event == null || event.getIsAccept() == 0) {
			return "error/404";
		}
		String layout = event.getEventLayout().getName();
		model.addAttribute("event", event);
		AccountModel accountLogin = accountService.getAccountModelByAuthencated();
		model.addAttribute("isNotNullAccount", accountLogin != null);
		Long eventId = event.getId();
		switch (layout) {
			case "Free":
				FreeLayoutModel freeLayout = freeLayoutService.findFreeLayoutByEventId(eventId);
				if (freeLayout == null) {
					return "error/404";
				}
				model.addAttribute("freeLayout", freeLayout);
				return "event-theme/free/event_detail_theme_free";
			case "Activity":
				ActivityLayoutModel activityLayout = activityLayoutService.findActivityLayoutByEventId(eventId);
				if (activityLayout == null) {
					return "error/404";
				}
				model.addAttribute("activityLayout", activityLayout);
				return "event-theme/activity/event_detail_theme_activity";
			case "Music":
				MusicLayoutModel musicLayout = musicLayoutService.findMusicLayoutByEventId(eventId);
				if (musicLayout == null) {
					return "error/404";
				}
				model.addAttribute("musicLayout", musicLayout);
				return "event-theme/music/event_detail_theme_music";
			case "Course":
				CourseLayoutModel courseLayout = courseLayoutService.findCourseLayoutByEventId(eventId);
				if (courseLayout == null) {
					return "error/404";
				}
				model.addAttribute("courseLayout", courseLayout);
				return "event-theme/study/event_detail_theme_study";
			default:
				return "error/404";
		}
	}
	
	
	@RequestMapping(value = "/register", method= RequestMethod.POST)
	public @ResponseBody String register(@RequestBody AccountModel accountModel, HttpServletRequest request){
		if(accountModel != null){
			path = request.getRequestURL().toString();
			accountModelTempl = accountModel;
			accountService.saveAccount(accountModel);
		}
		return null;
	}
	
	@RequestMapping(value = "sendEmailConfirmSigUp", method = RequestMethod.GET)
	public @ResponseBody String sendEmailRegister(){
		try {
			emailService.sentEmailRegister(accountModelTempl.getEmail(), path+"/confirm?user="+accountModelTempl.getUserName());
		} catch (MalformedURLException | EmailException e) {
		}
		return "";
	}
	
	
	@RequestMapping(value ="register/confirm", method=RequestMethod.GET)
	public String confirmAccount(@RequestParam("user") String userName, final RedirectAttributes redir, HttpServletRequest request) throws IOException{
		String path = request.getContextPath();
		String confirmResult = "";
			AccountModel accountModel = accountService.getAccountModelByUserName(userName);
			if(accountModel != null){
				accountService.setActive(accountModel.getId(), 1);
				accountModel.setIsActive(1);
				confirmResult = "success";
			}else{
				confirmResult = "error";
			}
		return "redirect: "+path+"?confirm="+confirmResult;
	}
	
	@RequestMapping(value = "/editProfile", method = RequestMethod.POST, headers ="content-type=application/json")
	public @ResponseBody String editProfile(@RequestBody AccountUserInfoModel account, Model model,  HttpServletRequest request) throws IOException{
		UserInformationEntity userInfor = userInfoService.handleBeforeEditProfile(account);
        if (!account.getAvatar().isEmpty()) {
        	String image = account.getAvatar().split(",")[1];
        	HttpSession session = request.getSession();
    		ServletContext sc = session.getServletContext();
    		
    		String nameImage = userInfor.getAccount().getUserName() + ".jpg";
    		String imagePath = FileUtil.createPath(sc.getRealPath("/") + "resources/images/avatar/") + nameImage;
    		
    		FileUtil.saveImageOnServerBase64(image, imagePath);
               userInfor.setAvatar(nameImage);
           }
        userInfoService.saveUserInfor(userInfor);
		return "updateSuccess";
	}
}
