package pnv.intern.pyco.ticketevent.services.converter;

import pnv.intern.pyco.ticketevent.repository.entity.EventEntity;
import pnv.intern.pyco.ticketevent.repository.entity.TicketEntity;
import pnv.intern.pyco.ticketevent.services.model.TicketModel;

public class TicketConverter {
	
	public static boolean IS_CONVERT;

	public TicketConverter() {
		// TODO Auto-generated constructor stub
	}

	public static TicketModel convertTicketEntityToTicketModel(TicketEntity ticketEntity) {
		IS_CONVERT = true;
		
		TicketModel ticketModel = new TicketModel();
		
		ticketModel.setId(ticketEntity.getId());
		ticketModel.setName(ticketEntity.getName());
		ticketModel.setDescription(ticketEntity.getDescription());
		ticketModel.setPrice(ticketEntity.getPrice());
		
		EventEntity eventEntity = ticketEntity.getEvent();
		if (!EventConverter.IS_CONVERT && eventEntity != null) {
			ticketModel.setEvent(EventConverter.convertEventEntityToEventModel(eventEntity));
		}
		
		//ticketModel.setListTicketBuyer(ticketEntity.getListTicketBuyer());
		
		IS_CONVERT = false;
		return ticketModel;
	}
}
