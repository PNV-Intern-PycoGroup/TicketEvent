package pnv.intern.pyco.ticketevent.services.converter;

import java.util.ArrayList;
import java.util.List;

import pnv.intern.pyco.ticketevent.repository.entity.EventEntity;
import pnv.intern.pyco.ticketevent.repository.entity.TicketBuyerEntity;
import pnv.intern.pyco.ticketevent.repository.entity.TicketEntity;
import pnv.intern.pyco.ticketevent.repository.entity.TicketOrderEntity;
import pnv.intern.pyco.ticketevent.services.model.EventModel;
import pnv.intern.pyco.ticketevent.services.model.TicketBuyerModel;
import pnv.intern.pyco.ticketevent.services.model.TicketModel;
import pnv.intern.pyco.ticketevent.services.model.TicketOrderModel;

public class TicketConverter {
	
	public static boolean IS_CONVERT;

	public TicketConverter() {
	}

	public static TicketModel convertTicketEntityToTicketModel(TicketEntity ticketEntity) {
		IS_CONVERT = true;
		
		List<TicketOrderEntity> ticketOrderEntities = ticketEntity.getListTicketOrder();
		TicketModel ticketModel = new TicketModel();
		
		ticketModel.setId(ticketEntity.getId());
		ticketModel.setName(ticketEntity.getName());
		ticketModel.setDescription(ticketEntity.getDescription());
		ticketModel.setPrice(ticketEntity.getPrice());
		ticketModel.setIsFree(ticketEntity.getIsFree());
		
		EventEntity eventEntity = ticketEntity.getEvent();
		if (!EventConverter.IS_CONVERT && eventEntity != null) {
			ticketModel.setEvent(EventConverter.convertEventEntityToEventModel(eventEntity));
		}
		
		if(!TicketOrderConverter.IS_CONVERT && ticketOrderEntities != null){
			List<TicketOrderModel> ticketOrderModels = new ArrayList<>();
			for(TicketOrderEntity ticketOrderEntity : ticketOrderEntities){
				ticketOrderModels.add(TicketOrderConverter.convertTicketOrderEntityToDTO(ticketOrderEntity));
			}
		    ticketModel.setListTicketOrder(ticketOrderModels);
		}
		
		List<TicketBuyerEntity> listTicketBuyerEntity = ticketEntity.getListTicketBuyer();
		if(!TicketBuyerConverter.IS_CONVERT && listTicketBuyerEntity != null){
			List<TicketBuyerModel> ticketBuyerModels = new ArrayList<>();
			for(TicketBuyerEntity ticketBuyerEntity : listTicketBuyerEntity){
				ticketBuyerModels.add(TicketBuyerConverter.convertFromEntityToDTO(ticketBuyerEntity));
			}
		    ticketModel.setListTicketBuyer(ticketBuyerModels);
		}
		
		IS_CONVERT = false;
		return ticketModel;
	}

	public static TicketEntity convertTicketModelToTicketEntity(TicketModel ticketModel) {
		IS_CONVERT = true;
		
		List<TicketOrderModel> ticketOrderModels = ticketModel.getListTicketOrder();
		TicketEntity ticketEntity = new TicketEntity();
		
		
		ticketEntity.setId(ticketModel.getId());
		ticketEntity.setName(ticketModel.getName());
		ticketEntity.setDescription(ticketModel.getDescription());
		ticketEntity.setPrice(ticketModel.getPrice());
		ticketEntity.setIsFree(ticketModel.getIsFree());
		
		EventModel eventModel = ticketModel.getEvent();
		if (!EventConverter.IS_CONVERT && eventModel != null) {
			ticketEntity.setEvent(EventConverter.convertEventModelToEventEntity(eventModel));
		}
		
		if(!TicketOrderConverter.IS_CONVERT && ticketOrderModels != null){
			List<TicketOrderEntity> ticketOrderEntities = new ArrayList<>();
			for(TicketOrderModel ticketOrderModel : ticketOrderModels){
				ticketOrderEntities.add(TicketOrderConverter.convertDTOToTicketOrderEntity(ticketOrderModel));
			}
			ticketEntity.setListTicketOrder(ticketOrderEntities);
		}

		List<TicketBuyerModel> listTicketBuyerModel = ticketModel.getListTicketBuyer();
		if(!TicketBuyerConverter.IS_CONVERT && listTicketBuyerModel != null){
			List<TicketBuyerEntity> ticketBuyerEntity = new ArrayList<>();
			for(TicketBuyerModel ticketBuyerModel : listTicketBuyerModel){
				ticketBuyerEntity.add(TicketBuyerConverter.convertFromDTOToEntity(ticketBuyerModel));
			}
		    ticketModel.setListTicketBuyer(listTicketBuyerModel);
		}
		
		IS_CONVERT = false;
		return ticketEntity;
	}
}
