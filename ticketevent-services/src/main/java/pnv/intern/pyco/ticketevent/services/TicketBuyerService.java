package pnv.intern.pyco.ticketevent.services;

import java.util.List;

import pnv.intern.pyco.ticketevent.services.model.EventModel;
import pnv.intern.pyco.ticketevent.services.model.TicketBuyerModel;
import pnv.intern.pyco.ticketevent.services.model.TicketOrderModel;

public interface TicketBuyerService {
	public List<TicketOrderModel> getTicketListByEvent(EventModel eventModel);
	public TicketBuyerModel save(TicketBuyerModel ticketBuyer);
	public List<TicketBuyerModel> getTicketListByAccountId(Long accountId);
	public TicketBuyerModel getTicketListById(Long id);
}
