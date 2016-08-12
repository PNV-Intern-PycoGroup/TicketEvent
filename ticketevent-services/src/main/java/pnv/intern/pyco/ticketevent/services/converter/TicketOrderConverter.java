package pnv.intern.pyco.ticketevent.services.converter;

import pnv.intern.pyco.ticketevent.repository.entity.TicketBuyerEntity;
import pnv.intern.pyco.ticketevent.repository.entity.TicketEntity;
import pnv.intern.pyco.ticketevent.repository.entity.TicketOrderEntity;
import pnv.intern.pyco.ticketevent.services.model.TicketBuyerModel;
import pnv.intern.pyco.ticketevent.services.model.TicketModel;
import pnv.intern.pyco.ticketevent.services.model.TicketOrderModel;

public class TicketOrderConverter {
	public static boolean IS_CONVERT;

	public TicketOrderConverter() {
		
	}

	public static TicketOrderModel convertTicketOrderEntityToDTO(TicketOrderEntity ticketOrderEntity) {
		IS_CONVERT = true;
		
		TicketOrderModel ticketOrderModel = new TicketOrderModel();
		ticketOrderModel.setId(ticketOrderEntity.getId());
		ticketOrderModel.setBuyDate(ticketOrderEntity.getBuyDate());
		ticketOrderModel.setQuantity(ticketOrderEntity.getQuantity());
		ticketOrderModel.setStatus(ticketOrderEntity.getStatus());
		
		TicketBuyerEntity ticketBuyerEntity = ticketOrderEntity.getTicketBuyer();
		if (!TicketBuyerConverter.IS_CONVERT && ticketBuyerEntity != null) {
			ticketOrderModel.setTicketBuyer(TicketBuyerConverter.convertFromEntityToDTO(ticketBuyerEntity));
		}
		TicketEntity ticketEntity = ticketOrderEntity.getTicket();
		if (!TicketConverter.IS_CONVERT && ticketEntity != null) {
			ticketOrderModel.setTicket(TicketConverter.convertTicketEntityToTicketModel(ticketEntity));
		}
		
		IS_CONVERT = false;
		return ticketOrderModel;
	}

	public static TicketOrderEntity convertDTOToTicketOrderEntity(TicketOrderModel ticketOrderModel) {
		IS_CONVERT = true;
		
		TicketOrderEntity ticketOrderEntity = new TicketOrderEntity();
		ticketOrderEntity.setId(ticketOrderModel.getId());
		ticketOrderEntity.setBuyDate(ticketOrderModel.getBuyDate());
		ticketOrderEntity.setQuantity(ticketOrderModel.getQuantity());
		ticketOrderEntity.setStatus(ticketOrderModel.getStatus());
		
		TicketBuyerModel ticketBuyerModel = ticketOrderModel.getTicketBuyer();
		if (!TicketBuyerConverter.IS_CONVERT && ticketBuyerModel != null) {
			ticketOrderEntity.setTicketBuyer(TicketBuyerConverter.convertFromDTOToEntity(ticketBuyerModel));
		}
		TicketModel ticketModel = ticketOrderModel.getTicket();
		if (!TicketConverter.IS_CONVERT && ticketModel != null) {
			ticketOrderEntity.setTicket(TicketConverter.convertTicketModelToTicketEntity(ticketModel));
		}
		
		IS_CONVERT = false;
		return ticketOrderEntity;
	}

}
