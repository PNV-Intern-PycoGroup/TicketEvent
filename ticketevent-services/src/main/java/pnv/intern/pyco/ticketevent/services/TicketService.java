package pnv.intern.pyco.ticketevent.services;

import java.util.List;

import pnv.intern.pyco.ticketevent.services.model.TicketModel;

public interface TicketService {
	public TicketModel getTicketById(Long id);
	public TicketModel save(TicketModel ticketModel);
	public TicketModel update(TicketModel ticketModel);
	public void delete(TicketModel ticketModel);
	public List<TicketModel> getAll();
	public void deleteTicketsByEventId(long eventID);
}
