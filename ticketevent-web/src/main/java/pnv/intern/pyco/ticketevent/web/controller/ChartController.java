package pnv.intern.pyco.ticketevent.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pnv.intern.pyco.ticketevent.services.AccountService;
import pnv.intern.pyco.ticketevent.services.EventService;
import pnv.intern.pyco.ticketevent.services.ProfitTicketEventService;
import pnv.intern.pyco.ticketevent.services.model.AccountModel;

@Controller
public class ChartController {

	@Autowired
	private ProfitTicketEventService profitTicketEventService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private EventService eventService;

	@RequestMapping(value = "admin/charts", method = RequestMethod.GET)
	public String getChart(ModelMap model) {
		AccountModel account = accountService.getAccountModelByAuthencated();
		if (account != null) {
			model.put("account", account);
		}
		return "admin/chart";
	}

	@RequestMapping(value = "admin/getTotal/{year}", method = RequestMethod.GET)
	public @ResponseBody Object[] getTotal(@PathVariable("year") int year) {
		Object[] objectList = eventService.getTotal(year);
		return objectList;
	}
	
	@RequestMapping(value = "admin/getYear", method = RequestMethod.GET)
	public @ResponseBody Object[] getYear() {
		Object[] objectList = eventService.getYears();
		return objectList;
	}
	
	@RequestMapping(value = "admin/getTotalByYear/{year}", method = RequestMethod.GET)
	public @ResponseBody String getTotalOfYear(@PathVariable("year") int year){
		String profit = profitTicketEventService.getProfitForYear(year);
		return profit;
	}
	
	@RequestMapping(value = "admin/counterEventOfYear/{year}", method = RequestMethod.GET)
	public @ResponseBody Integer counterEventOfYear(@PathVariable("year") int year){
		Integer count = eventService.counterEventByYear(year);
		return count;
	}
}
