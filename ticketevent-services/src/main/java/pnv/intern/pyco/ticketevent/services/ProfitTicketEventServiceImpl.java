package pnv.intern.pyco.ticketevent.services;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pnv.intern.pyco.ticketevent.services.model.EventModel;
import pnv.intern.pyco.ticketevent.services.model.TicketModel;
import pnv.intern.pyco.ticketevent.services.model.TicketOrderModel;

@Service
public class ProfitTicketEventServiceImpl implements ProfitTicketEventService{

	@Autowired
	private EventService eventService;
	
	@Override
	public String getProfitForYear(int year) {
		double totalProfit = 0;
		List<EventModel> eventModels = eventService.getTotalEventOfYear(year);
		if(eventModels != null){
			for(EventModel eventModel : eventModels){
				List<TicketModel> ticketModels = eventModel.getListTicket();
				if(ticketModels != null){
					for(TicketModel ticketModel : ticketModels){
						float price = ticketModel.getPrice();
						int quantity = 0;
						List<TicketOrderModel> listTicketOrder = ticketModel.getListTicketOrder();
						for (TicketOrderModel ticketOrder : listTicketOrder) {
							quantity += ticketOrder.getQuantity();
						}
						totalProfit = totalProfit + ((quantity * price)/10);
					}
				}
			}
		}
		return formatNumber(totalProfit);
	}
	
	public static String formatNumber(double number) {
        if (number == 1000) {
            return String.valueOf(number);
        }
        try {
            NumberFormat formatter = new DecimalFormat("###,###");
            String resp = formatter.format(number);
            resp = resp.replaceAll(",", ".");
            return resp;
        } catch (Exception e) {
            return "";
        }
    }
	
}
