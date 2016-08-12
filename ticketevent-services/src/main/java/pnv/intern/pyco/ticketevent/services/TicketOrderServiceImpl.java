package pnv.intern.pyco.ticketevent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pnv.intern.pyco.ticketevent.repository.TicketOrderRepository;
import pnv.intern.pyco.ticketevent.repository.entity.TicketOrderEntity;
import pnv.intern.pyco.ticketevent.services.converter.TicketOrderConverter;
import pnv.intern.pyco.ticketevent.services.model.TicketOrderModel;

@Service
public class TicketOrderServiceImpl implements TicketOrderService{

	@Autowired
	private TicketOrderRepository ticketOrderRepository;
	
	@Override
	public boolean save(TicketOrderModel ticketOrder) {
		boolean result = false;
		if (ticketOrder != null) {
			TicketOrderEntity ticketOrderEntity = ticketOrderRepository.save(TicketOrderConverter.convertDTOToTicketOrderEntity(ticketOrder));
			if (ticketOrderEntity != null) {
				result = true;
			}
		}
		return result;
	}

}
