package pnv.intern.pyco.ticketevent.web.controller;

import java.util.List;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pnv.intern.pyco.ticketevent.services.AccountService;
import pnv.intern.pyco.ticketevent.services.EmailServices;
import pnv.intern.pyco.ticketevent.services.EventService;
import pnv.intern.pyco.ticketevent.services.TicketService;
import pnv.intern.pyco.ticketevent.services.model.AccountModel;
import pnv.intern.pyco.ticketevent.services.model.EventModel;

@Controller
public class AdminEventController {
	
	@Autowired
	private EventService eventService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private TicketService ticketService;
	@Autowired
	private EmailServices mailService;
	
	private EventModel event;
	
	@RequestMapping(value = "admin/event-management", method = RequestMethod.GET)
	public String eventManagementPage(ModelMap model){
		AccountModel account = accountService.getAccountModelByAuthencated();
		if(account != null){
		List<EventModel> eventModels = eventService.getAllEvent();
		model.put("events", eventModels);
		model.put("account", account);
		}
		return "admin/event_management";
	}

	@RequestMapping(value = "admin/eventdelete/{id}", method = RequestMethod.GET)
	public @ResponseBody String deleteEventNotAccept(@PathVariable("id") long id){
		event = eventService.getEventById(id);
		if(event != null){
			ticketService.deleteTicketsByEventId(event.getId());
			eventService.deleteEventNotAccept(event);
		}
		return "";
	}
	
	@RequestMapping(value ="admin/sendEmailNotAcceptEvent/{content}", method = RequestMethod.GET)
	public @ResponseBody String sendEmailNotAcceptEvent(@PathVariable("content") String content){
		try {
			mailService.sendEmailDeleteEventNotAccept(event.getAccount().getEmail(), event, content);
		} catch (EmailException e) {
		}
		return "";
	}
	
	@RequestMapping(value = "admin/acceptEvent/{id}", method = RequestMethod.GET)
	public @ResponseBody String acceptEvent(@PathVariable("id") long id){
		EventModel eventModel = eventService.getEventById(id);
		if(eventModel != null){
			eventService.acceptEvent(eventModel);
		}
		return "";
	}
	
	@RequestMapping(value = "admin/deleteEvent/{id}", method = RequestMethod.GET)
	public @ResponseBody String deleteEvent(@PathVariable("id") long id){
		EventModel eventModel = eventService.getEventById(id);
		if(eventModel != null){
			eventService.deleteEvent(eventModel);
		}
		return "";
	}
}
