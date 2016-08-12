package pnv.intern.pyco.ticketevent.services;

import pnv.intern.pyco.ticketevent.services.model.TicketOrderModel;

public interface TicketOrderService {
	public boolean save(TicketOrderModel ticketOrder);
}
