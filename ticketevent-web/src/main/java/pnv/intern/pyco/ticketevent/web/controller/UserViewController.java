package pnv.intern.pyco.ticketevent.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pnv.intern.pyco.ticketevent.services.AccountService;
import pnv.intern.pyco.ticketevent.services.EventService;
import pnv.intern.pyco.ticketevent.services.TicketBuyerService;
import pnv.intern.pyco.ticketevent.services.model.AccountModel;
import pnv.intern.pyco.ticketevent.services.model.EventModel;
import pnv.intern.pyco.ticketevent.services.model.TicketBuyerModel;
import pnv.intern.pyco.ticketevent.services.model.TicketOrderModel;

@Controller
public class UserViewController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private EventService eventService;
	@Autowired
	private TicketBuyerService ticketBuyerService;

	@RequestMapping(value = "event-created", method = RequestMethod.GET)
	public String viewPageEventCreated(ModelMap model){
		List<EventModel> lEventModels = eventService.getEventsByUser();
		model.put("listEvent", lEventModels);
		return "user-view/user_event_created";
	}
	
	@RequestMapping(value = "getEventPassed", method = RequestMethod.GET)
	public @ResponseBody Integer getEventPassedByUser(){
		List<EventModel> lEventModels = eventService.getEventPassedByUser();
		return lEventModels.size();
	}
	
	@RequestMapping(value = "getEventNotAcceptByUser", method = RequestMethod.GET)
	public @ResponseBody Integer getEventNotAcceptByUser(){
		List<EventModel> lEventModels = eventService.getEventNotAcceptByUser();
		return lEventModels.size();
	}
	
	@RequestMapping(value = "event-detail", method = RequestMethod.GET)
	public String viewPageEventDetail(@RequestParam("id") Long id, ModelMap model){
		if(id != null){
			EventModel event = eventService.getEventById(id);
			if(event != null){
				List<TicketOrderModel> ticketOrderModels = ticketBuyerService.getTicketListByEvent(event);
				model.put("buyers", ticketOrderModels);
				model.put("event", event);
			}
		}
		return "user-view/user_view_ticket_detail";
	}
	
	@RequestMapping(value = "ticket-ordered", method = RequestMethod.GET)
	public String viewPageTicketOrder(ModelMap model){
		AccountModel accountLogin = accountService.getAccountModelByAuthencated();
		if (accountLogin != null) {
			List<TicketBuyerModel> listTicketBuyer = ticketBuyerService.getTicketListByAccountId(accountLogin.getId());
			model.put("buyers", listTicketBuyer);
			return "user-view/user_view_ticket_order";
		}
		return "error/403";
	}
	
	@RequestMapping(value = "getTotalByDateOfEvent/{eventId}", method = RequestMethod.GET)
	public @ResponseBody Object[] getTotal(@PathVariable("eventId") int eventId) {
		Object[] objectList = eventService.getTotalByDateOfEvent(eventId);
		return objectList;
	}
	
	@ResponseBody
	@RequestMapping(value = "api/get-list-order-ticket/{buyerId}")
	public List<TicketOrderModel> getListOrderDetail(@PathVariable Long buyerId){
		List<TicketOrderModel> listTicketOrder = null;
		AccountModel accountLogin = accountService.getAccountModelByAuthencated();
		TicketBuyerModel ticketBuyer = ticketBuyerService.getTicketListById(buyerId);
		if (accountLogin != null && ticketBuyer != null && ticketBuyer.getAccount().getId().equals(accountLogin.getId())) {
			listTicketOrder = ticketBuyer.getListTicketOrder();
		}
		return listTicketOrder;
	}
}
